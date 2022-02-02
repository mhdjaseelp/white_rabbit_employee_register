package com.twaddan.register.room;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static DatabaseClient mInstance;
    private Context mCtx;
    //our app database object
    private RoomDB roomDB;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        roomDB = Room.databaseBuilder(mCtx, RoomDB.class, "EmployeeRegister")
                .allowMainThreadQueries()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public RoomDB getAppDatabase() {
        return roomDB;
    }
}
