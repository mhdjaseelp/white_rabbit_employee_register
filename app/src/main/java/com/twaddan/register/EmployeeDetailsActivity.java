package com.twaddan.register;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.twaddan.register.model.Employee;
import com.twaddan.register.room.DatabaseClient;
import com.twaddan.register.room.EmployeeDao;

public class EmployeeDetailsActivity extends AppCompatActivity {

    EmployeeDao employeeDao;
    Employee employee;
    int id;
    TextView name, username, email, phone, address, website, company;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        initializeViews();
        id = getIntent().getIntExtra("id", 0);
        employeeDao = DatabaseClient.getInstance(this).getAppDatabase().employeeDao();
        employee = employeeDao.getEmployee(id);
        setValues();
    }

    void initializeViews() {
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        website = findViewById(R.id.website);
        company = findViewById(R.id.company);
        image = findViewById(R.id.image);
    }

    void setValues() {
        if (!TextUtils.isEmpty(employee.getName()))
            name.setText(employee.getName());
        if (!TextUtils.isEmpty(employee.getUsername()))
            username.setText(employee.getUsername());
        if (!TextUtils.isEmpty(employee.getEmail()))
            email.setText(employee.getEmail());
        if (!TextUtils.isEmpty(employee.getPhone()))
            phone.setText(employee.getPhone());
        if (!TextUtils.isEmpty(employee.getWebsite()))
            website.setText(employee.getWebsite());
        if (!TextUtils.isEmpty(employee.getProfile_image()))
            Picasso.get().load(employee.getProfile_image()).into(image);
        if (employee.getCompany() != null) {
            String companyDetails = employee.getCompany().getName() + "\n" + employee.getCompany().getCatchPhrase() + "\n" + employee.getCompany().getBs();
            company.setText(companyDetails);
        }
        if (employee.getAddress() != null) {
            String fullAddress = employee.getAddress().getStreet() + "\n" + employee.getAddress().getSuite() + "\n" + employee.getAddress().getCity() + "\n" + employee.getAddress().getZipcode() + "\n" + employee.getAddress().getGeo().getLat() + ", " + employee.getAddress().getGeo().getLng();
            address.setText(fullAddress);
        }
    }

    public void onClickBack(View view) {
        finish();
    }
}