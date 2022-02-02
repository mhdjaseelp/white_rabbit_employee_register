package com.twaddan.register;

import com.twaddan.register.model.EmployeeResponse;
import com.twaddan.register.utilities.ApiClient;
import com.twaddan.register.utilities.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeePresenter {

    public void getEmployees(final EmployeePresenter.EmployeeList EI) {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<EmployeeResponse>> call = service.getEmployees();
        call.enqueue(new Callback<ArrayList<EmployeeResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<EmployeeResponse>> call, Response<ArrayList<EmployeeResponse>> response) {
                ArrayList<EmployeeResponse> employeeResponses = response.body();
                if (!employeeResponses.isEmpty()) {
                    EI.onListSuccess(employeeResponses);
                } else {
                    EI.onListFailure("Empty...");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EmployeeResponse>> call, Throwable t) {
                EI.onListFailure("Connection Fail");
            }
        });
    }

    public interface EmployeeList {
        void onListSuccess(ArrayList<EmployeeResponse> responses);

        void onListFailure(String msg);
    }
}
