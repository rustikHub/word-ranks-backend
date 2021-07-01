package com.example.worldranksfullstack.payload;

import com.example.worldranksfullstack.db.entity.Country;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResCountry {

    private Double area;

    private String nativeName;

    private String capital;

    private String demonym;

    private UUID flag_id;

    private String alpha2Code;

    private ArrayList<ResLanguagesItem> languages;

    private List<String> borders;

    private String subregion;

    private List<String> callingCodes;

    private ArrayList<ResRegionalBlocsItem> regionalBlocs;

    private Double gini;

    private Integer population;

    private String numericCode;

    private String alpha3Code;

    private List<String> topLevelDomain;

    private List<String> timezones;

    private String cioc;

    private ResTranslations translations;

    private String name;

    private List<String> altSpellings;

    private String region;

    private List<Double> latlng;

    private List<ResCurrenciesItem> currencies;


    public ResCountry(Country country) {
        this.area = country.getArea();
        this.nativeName = country.getNativeName();
        this.capital = country.getCapital();
        this.demonym = country.getDemonym();
        this.flag_id = country.getFlag().getAttachment().getId();
        this.alpha2Code = country.getAlpha2Code();
        this.languages = country.getLanguages().stream().map(ResLanguagesItem::new).collect(Collectors.toCollection(ArrayList::new));
        this.borders = country.getBorders();
        this.subregion = country.getSubregion();
        this.callingCodes = country.getCallingCodes();
        this.regionalBlocs = country.getRegionalBlocs().stream().map(ResRegionalBlocsItem::new).collect(Collectors.toCollection(ArrayList::new));
        this.gini = country.getGini();
        this.population = country.getPopulation();
        this.numericCode = country.getNumericCode();
        this.alpha3Code = country.getAlpha3Code();
        this.topLevelDomain = country.getTopLevelDomain();
        this.timezones = country.getTimezones();
        this.cioc = country.getCioc();
        this.translations = new ResTranslations(country.getTranslations());
        this.name = country.getName();
        this.altSpellings = country.getAltSpellings();
        this.region = country.getRegion();
        this.latlng = country.getLatLang();
        this.currencies = country.getCurrencies().stream().map(ResCurrenciesItem::new).collect(Collectors.toList());
    }
}