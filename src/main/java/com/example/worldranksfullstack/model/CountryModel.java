package com.example.worldranksfullstack.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryModel {

    @SerializedName("area")
    private Double area;

    @SerializedName("nativeName")
    private String nativeName;

    @SerializedName("capital")
    private String capital;

    @SerializedName("demonym")
    private String demonym;

    @SerializedName("flag")
    private String flag;

    @SerializedName("alpha2Code")
    private String alpha2Code;

    @SerializedName("languages")
    private List<LanguagesItemModel> languages;

    @SerializedName("borders")
    private List<String> borders;

    @SerializedName("subregion")
    private String subregion;

    @SerializedName("callingCodes")
    private List<String> callingCodes;

    @SerializedName("regionalBlocs")
    private List<RegionalBlocsItemModel> regionalBlocs;

    @SerializedName("gini")
    private Double gini;

    @SerializedName("population")
    private Integer population;

    @SerializedName("numericCode")
    private String numericCode;

    @SerializedName("alpha3Code")
    private String alpha3Code;

    @SerializedName("topLevelDomain")
    private List<String> topLevelDomain;

    @SerializedName("timezones")
    private List<String> timezones;

    @SerializedName("cioc")
    private String cioc;

    @SerializedName("translations")
    private TranslationsModel translations;

    @SerializedName("name")
    private String name;

    @SerializedName("altSpellings")
    private List<String> altSpellings;

    @SerializedName("region")
    private String region;

    @SerializedName("latlng")
    private List<Double> latlng;

    @SerializedName("currencies")
    private List<CurrenciesItemModel> currencies;

}