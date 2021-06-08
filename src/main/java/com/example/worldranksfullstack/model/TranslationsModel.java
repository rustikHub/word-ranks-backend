package com.example.worldranksfullstack.model;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslationsModel {

    @SerializedName("br")
    private String br;

    @SerializedName("de")
    private String de;

    @SerializedName("pt")
    private String pt;

    @SerializedName("ja")
    private String ja;

    @SerializedName("hr")
    private String hr;

    @SerializedName("it")
    private String it;

    @SerializedName("fa")
    private String fa;

    @SerializedName("fr")
    private String fr;

    @SerializedName("es")
    private String es;

    @SerializedName("nl")
    private String nl;
}