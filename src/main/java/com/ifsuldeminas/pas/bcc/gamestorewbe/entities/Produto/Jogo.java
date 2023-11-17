package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data // gera getters e setters
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idJogo;
    @Column
    private String responseName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column
    private LocalDate releaseDate;
    @Column
    private Float metacritic;
    @Column
    private Integer recommendationCount;
    @Column
    private Float priceInitial;
    @Column
    private String imageUrl;

//     Nomes das variáveis devem ser iguais aos nomes dos campos do arquivo json
    public Jogo(String responseName, LocalDate releaseDate, Float metacritic, Integer recommendationCount, Float priceInitial, String imageUrl) {
        this.responseName = responseName;
        this.releaseDate = releaseDate;
        this.metacritic = metacritic;
        this.recommendationCount = recommendationCount;
        this.priceInitial = priceInitial;
        this.imageUrl = imageUrl;
    }

    public Jogo() {
    }
}
