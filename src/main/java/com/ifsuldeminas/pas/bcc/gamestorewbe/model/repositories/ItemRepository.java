package com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
