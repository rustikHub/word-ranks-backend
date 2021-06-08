package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import com.example.worldranksfullstack.model.TranslationsModel;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Translations extends AbsIntegerEntity {

    private String br;

    private String de;

    private String pt;

    private String ja;

    private String hr;

    private String it;

    private String fa;

    private String fr;

    private String es;

    private String nl;

    public Translations(TranslationsModel translationsModel) {
        this.br = translationsModel.getBr();
        this.de = translationsModel.getDe();
        this.pt = translationsModel.getPt();
        this.ja = translationsModel.getJa();
        this.hr = translationsModel.getHr();
        this.it = translationsModel.getIt();
        this.fa = translationsModel.getFa();
        this.fr = translationsModel.getFr();
        this.es = translationsModel.getEs();
        this.nl = translationsModel.getNl();
    }

    @OneToOne(mappedBy = "translations")
    private Country country;
}