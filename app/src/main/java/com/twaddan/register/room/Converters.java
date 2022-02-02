package com.twaddan.register.room;

import androidx.room.TypeConverter;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.twaddan.register.model.EmployeeResponse;

import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<EmployeeResponse> restoreList(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<ArrayList<EmployeeResponse>>() {
        }.getType());
    }

    @TypeConverter
    public static String saveList(ArrayList<EmployeeResponse> listOfString) {
        return new Gson().toJson(listOfString);
    }
}
