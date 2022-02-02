package com.twaddan.register.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.twaddan.register.model.Employee;

@Database(entities = {Employee.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class RoomDB extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
