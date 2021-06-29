package com.example.worldranksfullstack.payload;

import com.example.worldranksfullstack.db.entity.RegionalBlocsItem;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResRegionalBlocsItem {

    private List<String> otherNames;

    private String acronym;

    private String name;

    private List<String> otherAcronyms;

    public ResRegionalBlocsItem(RegionalBlocsItem regionalBlocsItem) {
        this.otherNames = regionalBlocsItem.getOtherNames();
        this.acronym = regionalBlocsItem.getAcronym();
        this.name = regionalBlocsItem.getName();
        this.otherAcronyms = regionalBlocsItem.getOtherAcronyms();
    }
}