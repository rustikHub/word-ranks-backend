package com.example.worldranksfullstack.model;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguagesItemModel {

	@SerializedName("nativeName")
	private String nativeName;

	@SerializedName("iso639_2")
	private String iso639_2;

	@SerializedName("name")
	private String name;

	@SerializedName("iso639_1")
	private String iso639_1;

}