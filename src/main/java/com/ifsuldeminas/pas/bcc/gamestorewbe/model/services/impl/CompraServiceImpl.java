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
        if (!compra.isPresent()) {
            throw new CompraNotFoundException(id);
        }
        return compra.orElse(null);
    }


    @Override
    public void addCompra(Compra compra) throws ClienteNotFoundException {
        Optional<Cliente> opc = Optional.ofNullable(clienteService.buscarClientePorId(compra.getCliente().getIdCliente()));
        if (!opc.isPresent()) {
            LOG.error("Erro ao adicionar Compra - Cliente não existe!");
            throw new ClienteNotFoundException(compra.getCliente().getIdCliente());
        } else {
            for (Item item : compra.getItens()) {  // Para cada item da compra
                Optional<Jogo> opi = Optional.ofNullable(jogoService.buscarJogoPorId(item.getJogo().getIdJogo()));
                if (!opi.isPresent()) {
                    LOG.error("Erro ao adicionar Item - Jogo não existe!");
                    throw new JogoNotFoundException(item.getJogo().getIdJogo());
                }
            }
            for (Item item : compra.getItens())
                itemService.addItem(item);  // Adiciona o item

            compra.setValorTotal(calculaValorTotal(compra));
            compraRepository.save(compra);
            LOG.info("Compra adicionada com sucesso");
        }
    }

    @Override
    public void atualizaCompra(Compra compra, Integer id) throws CompraNotFoundException {
        Optional<Cliente> opc = Optional.ofNullable(clienteService.buscarClientePorId(compra.getCliente().getIdCliente())); // Verifica se o cliente existe
        if (!opc.isPresent()) {  // Se não existe, retorna erro
            LOG.info("Erro ao atualizar Compra - Cliente não existe!");
            throw new ClienteNotFoundException(compra.getCliente().getIdCliente());
        } else {  // Se existe
            for (Item item : compra.getItens()) {
                Optional<Jogo> opj = Optional.ofNullable(jogoService.buscarJogoPorId(item.getJogo().getIdJogo()));  // Verifica se o jogo existe
                if (!opj.isPresent()) {  // Se não existe, retorna erro
                    LOG.info("Erro ao atualizar Item - Jogo não existe!");
                    throw new JogoNotFoundException(item.getJogo().getIdJogo());
                }
            }
            Compra compraAtual = buscarCompraPorId(compra.getIdCompra());  // Busca a compra atual/antiga

            for (Item item : compra.getItens()) {
                // Verifica se o item já existe na compra atual/antiga
                boolean atualNovo = compraAtual.getItens().stream().filter(c -> c.getIdItem().equals(item.getIdItem())).findFirst().isPresent();
                if(atualNovo){  // Se existe, atualiza o item
                    LOG.info("Item já existe na compra e será atualizado!");
                    itemService.atualizaItem(item);
                }else{  // Se não existe
                    for (Item itemAtual : compraAtual.getItens()) {
                        if (!atualNovo){  // Se o item não existe na compra atual/antiga, mas existe na compra nova/atualizada, adiciona o item
                            itemService.addItem(item);
                            LOG.info("Item novo não existe na compra antiga e será adicionado!");
                        }else{  // Se o item não existe na compra nova/atualizada, mas existe na compra atual/antiga, deleta o item
                            itemService.deletaItem(itemAtual.getIdItem());
                            LOG.info("Item antigo não existe na compra nova e será deletado!");
                        }
                    }
                }
            }
            compra.setIdCompra(id);
            compraAtual.setCliente(compra.getCliente());
            compraAtual.setDataCompra(compra.getDataCompra());
            compraAtual.setItens(compra.getItens());
            compraAtual.setValorTotal(calculaValorTotal(compra));
            compraRepository.save(compraAtual);
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
        Float total = 0f;
        for (Item item : itens) {
            total += item.getValor() * item.getQuantidade();
        }
        return total;
    }
}

