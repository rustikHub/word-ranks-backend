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

    private String name;

    private String nativeName;

    private String capital;

    private String region;

    private String demonym;

    private Double gini;

    private Integer population;

    private String numericCode;

    @Column(unique = true)
    private String alpha3Code;

    @Column(unique = true)
    private String alpha2Code;

    private String cioc;

    private String subregion;

    @OneToOne
    Flag flag;

    @ManyToMany
    private List<LanguagesItem> languages;

    @ElementCollection
    private List<String> borders;

    @ElementCollection
    private List<String> callingCodes;

    @ManyToMany
    private List<RegionalBlocsItem> regionalBlocs;

    @ElementCollection
    private List<String> topLevelDomain;

    @ElementCollection
    private List<String> timezones;

    @OneToOne
    private Translations translations;

    @ElementCollection
    private List<String> altSpellings;

    @ElementCollection
    private List<Double> latLang;

    @ManyToMany
    private List<CurrenciesItem> currencies;

}