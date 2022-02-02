package com.twaddan.register.room;

import androidx.room.TypeConverter;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.twaddan.register.model.Address;
import com.twaddan.register.model.EmployeeResponse;

import java.util.ArrayList;

public class AddressConverter {
    @TypeConverter
    public static Address restoreList(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<Address>() {
        }.getType());
    }

    @TypeConverter
    public static String saveList(Address listOfString) {
        return new Gson().toJson(listOfString);
    }
}
