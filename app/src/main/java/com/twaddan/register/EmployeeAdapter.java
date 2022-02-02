package com.twaddan.register;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.twaddan.register.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Employee> employees;

    public EmployeeAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_list_item
                        , parent, false);
        return new EmployeeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        holder.name.setText(employees.get(position).getName());
        if (employees.get(position).getCompany() != null)
            holder.companyName.setText(employees.get(position).getCompany().getName());
        Picasso.get().load(employees.get(position).getProfile_image()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, EmployeeDetailsActivity.class)
                        .putExtra("id", employees.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public void setListData(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, companyName;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            companyName = itemView.findViewById(R.id.companyName);
            image = itemView.findViewById(R.id.image);
        }
    }

}




