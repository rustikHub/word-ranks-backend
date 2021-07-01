package com.example.worldranksfullstack.payload;

import com.example.worldranksfullstack.db.entity.LanguagesItem;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResLanguagesItem {

    private String nativeName;

    private String iso639_2;

    private String name;

    private String iso639_1;

    public ResLanguagesItem(LanguagesItem languagesItem) {
        this.nativeName = languagesItem.getNativeName();
        this.iso639_2 = languagesItem.getIso639_2();
        this.name = languagesItem.getName();
        this.iso639_1 = languagesItem.getIso639_1();
    }

}