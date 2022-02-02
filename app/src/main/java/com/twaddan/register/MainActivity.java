package com.twaddan.register;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twaddan.register.model.Employee;
import com.twaddan.register.model.EmployeeResponse;
import com.twaddan.register.room.DatabaseClient;
import com.twaddan.register.room.EmployeeDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmployeePresenter.EmployeeList {

    ProgressBar loading;
    RecyclerView listRv;
    EmployeeAdapter employeeAdapter;
    EmployeePresenter employeePresenter;
    List<Employee> employees;
    EmployeeDao employeeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRv = findViewById(R.id.list);
        loading = findViewById(R.id.loader);
        employeeAdapter = new EmployeeAdapter(this, new ArrayList<>());
        employeePresenter = new EmployeePresenter();

        listRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        listRv.setAdapter(employeeAdapter);

        employeeDao = DatabaseClient.getInstance(this).getAppDatabase().employeeDao();
        employees = getFromRoomDB();

        if (employees.isEmpty()) {
            loadApi();
        } else {
            loading.setVisibility(View.GONE);
            employeeAdapter.setListData((ArrayList<Employee>) employees);
        }
    }

    List<Employee> getFromRoomDB(){
        return employeeDao.getAll();
    }

    void loadApi() {
        loading.setVisibility(View.VISIBLE);
        employeePresenter.getEmployees(this);
    }

    @Override
    public void onListSuccess(ArrayList<EmployeeResponse> responses) {
        loading.setVisibility(View.GONE);
        for (int i = 0; i < responses.size(); i++) {
            Employee employee = new Employee(responses.get(i).getId(),
                    responses.get(i).getName(),
                    responses.get(i).getUsername(),
                    responses.get(i).getProfileImage(),
                    responses.get(i).getEmail(),
                    responses.get(i).getAddress(),
                    responses.get(i).getPhone(),
                    responses.get(i).getWebsite(),
                    responses.get(i).getCompany());
            employeeDao.insertEmployee(employee);
        }
        employeeAdapter.setListData((ArrayList<Employee>) getFromRoomDB());
    }

    @Override
    public void onListFailure(String msg) {
        loading.setVisibility(View.GONE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}