package com.twaddan.register.room;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.twaddan.register.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("SELECT * FROM employee WHERE id = :id")
    Employee getEmployee(int id);

    @Insert(onConflict = REPLACE)
    void insertEmployee(Employee employee);

    @Delete
    void delete(Employee employee);

}