package com.twaddan.register.room;

import androidx.room.TypeConverter;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.twaddan.register.model.Company;

public class CompanyConverter {
    @TypeConverter
    public static Company restoreList(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<Company>() {
        }.getType());
    }

    @TypeConverter
    public static String saveList(Company listOfString) {
        return new Gson().toJson(listOfString);
    }
}
