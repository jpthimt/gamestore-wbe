package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.impl;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.compra.ItemNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.jogo.JogoNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.JogoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private JogoService jogoService;

    @Override
    public List<Item> listarItem() {
        return itemRepository.findAll();
    }
    @Override
    public Item buscarItemPorId(Integer id) throws ItemNotFoundException {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isEmpty()){
            throw new ItemNotFoundException(id);
        }
        return item.orElse(null);
    }

    @Override
    public void addItem(Item item) throws JogoNotFoundException {
        Optional<Jogo> opj = Optional.ofNullable(jogoService.buscarJogoPorId(item.getJogo().getIdJogo()));
        if (opj.isEmpty()) {  // Verifica se o jogo existe
            LOG.error("Erro ao adicionar Item - Jogo não existe!");
            throw new JogoNotFoundException(item.getJogo().getIdJogo());
        } else {
            item.setValorUnid(calculaValorUnid(item));  // Calcula o valor unitário do item
            item.setValorTotal(calculaValorTotal(item));  // Calcula o valor total do item
            itemRepository.save(item);
            LOG.info("Item adicionado com sucesso");
        }
    }
    @Override
    public void atualizaItem(Item item) throws ItemNotFoundException{
        Item atual = this.buscarItemPorId(item.getIdItem());
        atual.setJogo(item.getJogo());
        atual.setQuantidade(item.getQuantidade());
        atual.setValorUnid(calculaValorUnid(item));
        atual.setValorTotal(calculaValorTotal(item));
        itemRepository.save(atual);
        LOG.info("Item atualizado com sucesso");
    }

    @Override
    public void deletaItem(Integer id) throws ItemNotFoundException{
        if (!this.itemRepository.existsById(id)){
            throw new ItemNotFoundException(id);
        }
        itemRepository.deleteById(id);
        LOG.info("Item deletado com sucesso");
    }

    @Override
    public Float calculaValorTotal(Item item) {

        return item.getValor()*item.getQuantidade();
    }

    @Override
    public Float calculaValorUnid(Item item) {
        return jogoService.buscarJogoPorId(item.getJogo().getIdJogo()).getPriceInitial();
    }
}
