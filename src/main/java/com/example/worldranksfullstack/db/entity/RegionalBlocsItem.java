package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import com.example.worldranksfullstack.model.RegionalBlocsItemModel;
import com.google.gson.annotations.SerializedName;
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
public class RegionalBlocsItem extends AbsIntegerEntity {

    @ElementCollection
    private List<String> otherNames;

    private String acronym;

    private String name;

    @ElementCollection
    private List<String> otherAcronyms;

    public RegionalBlocsItem(RegionalBlocsItemModel regionalBlocsItemModel) {
        this.otherNames = regionalBlocsItemModel.getOtherNames();
        this.acronym = regionalBlocsItemModel.getAcronym();
        this.name = regionalBlocsItemModel.getName();
        this.otherAcronyms = regionalBlocsItemModel.getOtherNames();
    }

    @ManyToMany(mappedBy = "regionalBlocs")
    private List<Country> country;

}