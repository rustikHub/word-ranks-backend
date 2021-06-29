package com.example.worldranksfullstack.payload;

import com.example.worldranksfullstack.db.entity.CurrenciesItem;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResCurrenciesItem {

    private String symbol;

    private String code;

    private String name;

    public ResCurrenciesItem(CurrenciesItem currenciesItem) {
        this.symbol = currenciesItem.getSymbol();
        this.code = currenciesItem.getCode();
        this.name = currenciesItem.getName();
    }
}