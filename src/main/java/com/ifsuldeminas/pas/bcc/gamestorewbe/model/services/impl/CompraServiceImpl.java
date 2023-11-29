package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.cliente.ClienteNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.compra.CompraNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.jogo.JogoNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.CompraRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ClienteService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.CompraService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.JogoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(CompraServiceImpl.class);

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private JogoService jogoService;

    @Override
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra buscarCompraPorId(Integer id) throws CompraNotFoundException {
        Optional<Compra> compra = compraRepository.findById(id);
        if (compra.isEmpty()) {
            throw new CompraNotFoundException(id);
        }
        return compra.orElse(null);
    }


    @Override
    public void addCompra(Compra compra) throws ClienteNotFoundException {
        Optional<Cliente> opc = Optional.ofNullable(clienteService.buscarClientePorId(compra.getCliente().getIdCliente()));  // Verifica se o cliente existe
        if (opc.isEmpty()) {  // Se não existe, retorna erro
            LOG.error("Erro ao adicionar Compra - Cliente não existe!");
            throw new ClienteNotFoundException(compra.getCliente().getIdCliente());
        } else {  // Se existe
            for (Item item : compra.getItens()) {  // Verifica se todos os jogos existem
                Optional<Jogo> opi = Optional.ofNullable(jogoService.buscarJogoPorId(item.getJogo().getIdJogo()));
                if (opi.isEmpty()) {  // Se não existe, retorna erro
                    LOG.error("Erro ao adicionar Item - Jogo não existe!");
                    throw new JogoNotFoundException(item.getJogo().getIdJogo());
                }
            }
            // Necessário verificar se todos os jogos existem antes de adicionar os itens para que não seja adicionado nenhum item caso algum jogo não exista
            for (Item item : compra.getItens())
                itemService.addItem(item);  // Adiciona os itens

            compra.setValorTotal(calculaValorTotal(compra));
            compraRepository.save(compra);
            LOG.info("Compra adicionada com sucesso");
        }
    }

    @Override
    public void atualizaCompra(Compra compra, Integer id) throws CompraNotFoundException {
        if (!this.compraRepository.existsById(id)) {
            throw new CompraNotFoundException(id);
        }
        Optional<Cliente> opc = Optional.ofNullable(clienteService.buscarClientePorId(compra.getCliente().getIdCliente())); // Verifica se o cliente existe
        if (opc.isEmpty()) {  // Se não existe, retorna erro
            LOG.info("Erro ao atualizar Compra - Cliente não existe!");
            throw new ClienteNotFoundException(compra.getCliente().getIdCliente());
        } else {  // Se existe
            for (Item item : compra.getItens()) {
                Optional<Jogo> opj = Optional.ofNullable(jogoService.buscarJogoPorId(item.getJogo().getIdJogo()));  // Verifica se o jogo existe
                if (opj.isEmpty()) {  // Se não existe, retorna erro
                    LOG.info("Erro ao atualizar Item - Jogo não existe!");
                    throw new JogoNotFoundException(item.getJogo().getIdJogo());
                }
            }


            Compra compraOld = buscarCompraPorId(id);  // Busca a compra atual/antiga
            // Cria lista com os itens que já existem na compra antiga e na nova
            List<Item> iguais = compra.getItens().stream().filter(c -> compraOld.getItens().stream().anyMatch(c2 -> c2.getIdItem().equals(c.getIdItem()))).toList();
            for (Item item : iguais) {
                itemService.atualizaItem(item);
                LOG.info("Item já existe na compra e será atualizado!");
            }
            // Cria lista com os itens que existem na compra nova mas não na antiga
            List<Item> novos = compra.getItens().stream().filter(c -> !compraOld.getItens().stream().anyMatch(c2 -> c2.getIdItem().equals(c.getIdItem()))).toList();
            for (Item item : novos) {
                itemService.addItem(item);
                LOG.info("Item novo não existe na compra antiga e será adicionado!");
            }
            // Verifica se os itens da compra antiga existem na compra nova e apaga os que não existem
            for (Item item : compraOld.getItens()){
                boolean possui = false;
                for (Item item2 : compra.getItens()){
                    if (item.getIdItem().equals(item2.getIdItem())){
                        possui = true;
                        break;
                    }
                }
                if (!possui){
                    itemService.deletaItem(item.getIdItem());
                    LOG.info("Item antigo não existe na compra nova e será deletado!");
                }
            }
            compra.setIdCompra(id);
            compraOld.setCliente(compra.getCliente());
            compraOld.setDataCompra(compra.getDataCompra());
            compraOld.setItens(compra.getItens());
            compraOld.setValorTotal(calculaValorTotal(compra));
            compraRepository.save(compraOld);
            LOG.info("Compra atualizada com sucesso");
        }
    }

    @Override
    public void deletaCompra(Integer id) throws CompraNotFoundException {
        if (!this.compraRepository.existsById(id)) {
            throw new CompraNotFoundException(id);
        }
        compraRepository.deleteById(id);
        LOG.info("Compra deletada com sucesso");
    }

    @Override
    public Float calculaValorTotal(Compra compra) {
        List<Item> itens = compra.getItens();
        float total = 0f;
        for (Item item : itens) {
            total += item.getValor() * item.getQuantidade();
        }
        return total;
    }
}

