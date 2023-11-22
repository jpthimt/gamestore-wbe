package com.ifsuldeminas.pas.bcc.gamestorewbe.repositories;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
