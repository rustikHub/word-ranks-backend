package com.example.worldranksfullstack.payload;

import com.example.worldranksfullstack.db.entity.Translations;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResTranslations {

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

    public ResTranslations(Translations translations) {
        this.br = translations.getBr();
        this.de = translations.getDe();
        this.pt = translations.getPt();
        this.ja = translations.getJa();
        this.hr = translations.getHr();
        this.it = translations.getIt();
        this.fa = translations.getFa();
        this.fr = translations.getFr();
        this.es = translations.getEs();
        this.nl = translations.getNl();
    }
}