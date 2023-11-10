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
    public Jogo(String ResponseName, String ReleaseDate, Float Metacritic, Integer RecommendationCount, Float PriceInitial, String imageURL) {
        responseName = ResponseName;
        releaseDate = ReleaseDate;
        metacritic = Metacritic;
        recommendationCount = RecommendationCount;
        priceInitial = PriceInitial;
        this.imageURL = imageURL;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Float metacritic) {
        this.metacritic = metacritic;
    }

    public Integer getRecommendationCount() {
        return recommendationCount;
    }

    public void setRecommendationCount(Integer recommendationCount) {
        this.recommendationCount = recommendationCount;
    }

    public Float getPriceInitial() {
        return priceInitial;
    }

    public void setPriceInitial(Float priceInitial) {
        this.priceInitial = priceInitial;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
