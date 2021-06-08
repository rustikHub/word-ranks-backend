package com.example.worldranksfullstack.db.entity;

import com.example.worldranksfullstack.db.entity.template.AbsIntegerEntity;
import com.example.worldranksfullstack.model.CurrenciesItemModel;
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
public class CurrenciesItem extends AbsIntegerEntity {

    private String symbol;

    private String code;

    private String name;

    public CurrenciesItem(CurrenciesItemModel currenciesItemModel) {
        this.symbol = currenciesItemModel.getSymbol();
        this.code = currenciesItemModel.getCode();
        this.name = currenciesItemModel.getName();
    }

    @ManyToMany(mappedBy = "currencies")
    private List<Country> countryList;
}