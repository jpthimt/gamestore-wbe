package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.CompraService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.ItemServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private CompraService compraService;
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        List<Compra> compras = compraService.listarCompras();
        return ResponseEntity.ok().body(compras);
    }

    @PostMapping
    void addCompra(@RequestBody Compra compra) {
        boolean ok = true;
        if (!compraService.verificaCliente(compra)) {
            LOG.error("Erro ao adicionar Compra - Cliente não existe!");
            ok = false;  // Se o cliente não existe, não adiciona a compra
        } else {
            for (Item item : compra.getItens()) {  // Para cada item da compra
                if (itemService.verificaJogo(item)) {
                    LOG.error("Erro ao adicionar Item - Jogo não existe!");
                    ok = false;  // Se o jogo não existe, não adiciona o item
                } else {
                    item.setValorUnid(itemService.calculaValorUnid(item));  // Calcula o valor unitário do item
                    item.setValorTotal(itemService.calculaValorTotal(item));  // Calcula o valor total do item
                    itemService.addItem(item);  // Adiciona o item
                    LOG.info("Item salvo com sucesso!");
                }
            }
            if (ok) {  // Se o cliente e o jogo existem, adiciona a compra
                compra.setValorTotal(compraService.calculaValorTotal(compra));  // Calcula o valor total da compra
                compraService.addCompra(compra);  // Adiciona a compra
                LOG.info("Compra salva com sucesso!");
            }
        }
    }

    @PostMapping("/addLista")
    public ResponseEntity<List<Compra>> addCompra(@RequestBody List<Compra> compras) {
        boolean ok = true;
        for (Compra compra : compras) {  // Para cada compra
            ok = true;
            if (!compraService.verificaCliente(compra)) {
                LOG.error("Erro ao adicionar Compra - Cliente não existe!");
                ok = false;  // Se o cliente não existe, não adiciona a compra
            } else {
                for (Item item : compra.getItens()) {  // Para cada item da compra
                    if (itemService.verificaJogo(item)) {
                        LOG.error("Erro ao adicionar Item - Jogo não existe!");
                        ok = false;  // Se o jogo não existe, não adiciona o item
                    } else {
                        item.setValorUnid(itemService.calculaValorUnid(item));  // Calcula o valor unitário do item
                        item.setValorTotal(itemService.calculaValorTotal(item));  // Calcula o valor total do item
                        itemService.addItem(item);  // Adiciona o item
                        LOG.info("Item salvo com sucesso!");
                    }
                }
                if (ok) {  // Se o cliente e o jogo existem, adiciona a compra
                    compra.setValorTotal(compraService.calculaValorTotal(compra));  // Calcula o valor total da compra
                    compraService.addCompra(compra);  // Adiciona a compra
                    LOG.info("Compra salva com sucesso!");
                }
            }
        }
        return ResponseEntity.ok().body(compras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizaCompra(@RequestBody Compra compra, @PathVariable Integer id) {
        Compra compraAtualizada = compra;
        compraAtualizada.setIdCompra(id);
        if (!compraService.verificaCliente(compraAtualizada)) {
            LOG.info("Erro ao atualizar Compra - Cliente não existe!");
            return ResponseEntity.badRequest().build();  // Se o cliente não existe, não atualiza a compra
        }else{
            for(Item item : compraAtualizada.getItens()){
                if (itemService.verificaJogo(item)){
                    LOG.info("Erro ao atualizar Item - Jogo não existe!");
                    return ResponseEntity.badRequest().build();  // Se o jogo não existe, não atualiza o item
                }else{
                    item.setValorUnid(itemService.calculaValorUnid(item));  // Calcula o valor unitário do item
                    item.setValorTotal(itemService.calculaValorTotal(item));  // Calcula o valor total do item
                    itemService.atualizaItem(item);  // Atualiza o item
                    LOG.info("Item atualizado com sucesso!");  // Se o jogo existe, atualiza o item
                }
            }
            compraService.atualizaCompra(compraAtualizada);  // Se o cliente e jogo existem, atualiza a compra
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Compra> deletaCompra(@PathVariable Integer id) {
        compraService.deletaCompra(id);
        return ResponseEntity.noContent().build();
    }
}
