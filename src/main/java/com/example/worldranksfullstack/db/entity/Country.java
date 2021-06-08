package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Country extends AbsIntegerEntity {

    private Double area;

    private String nativeName;

    private String capital;

    private String demonym;

    private String alpha2Code;

    @OneToOne
    Flag flag;

    @ManyToMany
    private List<LanguagesItem> languages;

    @ElementCollection
    private List<String> borders;

    private String subregion;

    @ElementCollection
    private List<String> callingCodes;

    @ManyToMany
    private List<RegionalBlocsItem> regionalBlocs;

    private Double gini;

    private Integer population;

    private String numericCode;

    private String alpha3Code;

    @ElementCollection
    private List<String> topLevelDomain;

    @ElementCollection
    private List<String> timezones;

    private String cioc;

    @OneToOne
    private Translations translations;

    private String name;

    @ElementCollection
    private List<String> altSpellings;

    private String region;

    @ElementCollection
    private List<Double> latLang;

    @ManyToMany
    private List<CurrenciesItem> currencies;

}