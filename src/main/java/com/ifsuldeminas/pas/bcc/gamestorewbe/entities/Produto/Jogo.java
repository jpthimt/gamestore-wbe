package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data // gera getters e setters
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idJogo;
    @Column
    private String responseName;
    @Column
    private String releaseDate;
    @Column
    private Float metacritic;
    @Column
    private Integer recommendationCount;
    @Column
    private Float priceInitial;
    @Column
    private String imageURL;

//     Nomes das variáveis devem ser iguais aos nomes dos campos do arquivo json
    public Jogo(String responseName, String releaseDate, Float metacritic, Integer recommendationCount, Float priceInitial, String imageURL) {
        this.responseName = responseName;
        this.releaseDate = releaseDate;
        this.metacritic = metacritic;
        this.recommendationCount = recommendationCount;
        this.priceInitial = priceInitial;
        this.imageURL = imageURL;
    }

    public Jogo() {
    }
}
