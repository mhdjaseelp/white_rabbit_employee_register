package com.twaddan.register.utilities;

import com.twaddan.register.model.EmployeeResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("5d565297300000680030a986")
    Call<ArrayList<EmployeeResponse>> getEmployees();

}
