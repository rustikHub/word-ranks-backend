package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import com.example.worldranksfullstack.model.LanguagesItemModel;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class LanguagesItem extends AbsIntegerEntity {

    private String nativeName;

    private String iso639_2;

    private String name;

    private String iso639_1;

    public LanguagesItem(LanguagesItemModel languagesItemModel) {
        this.name = languagesItemModel.getName();
        this.nativeName = languagesItemModel.getNativeName();
        this.iso639_2 = languagesItemModel.getIso639_2();
        this.iso639_1 = languagesItemModel.getIso639_1();
    }

    @ManyToMany(mappedBy = "languages")
    private List<Country> countryList;
}