package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "camp")
@Data
public class CampEntity {
    @Id
    private int cno;

    private String title;
    private String intro;
    private String poster;
    private String managesttus;
    private String hvofbgnde;
    private String hvofenddle;
    private String operpdcl;
    private String induty;
    private String lctcl;
    private String addr;
    private String donm;

    private Integer gnrlsiteco;
    private Integer autositeco;
    private Integer glampsiteco;
    private Integer caravsiteco;
    private Integer indvdlcaravsiteco;

    private String caravacmpnyat;
    private String trleracmpnyat;
    private String animalcmgcl;

    private Integer hit;
    private Integer fcount;
    private Integer lcount;
    private Integer rcount;

    private String mapx;
    private String mapy;

    private Integer price;
    private Integer operdecl;
}
