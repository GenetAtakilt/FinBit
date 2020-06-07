package com.project.finbit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.finbit.R;
import com.project.finbit.entities.Employess;
import com.project.finbit.model.DefultEmployeeResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employess> employesses;
    private Context mCtx;

    public EmployeeAdapter(ArrayList<Employess> employesses, Context mCtx) {
        this.employesses = employesses;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.finbit_home, null);
        EmployeeViewHolder holder =  new EmployeeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        holder.employeeName.setText(employesses.get(position).getEmployee_name());
        holder.employeeAge.setText(employesses.get(position).getEmployee_age());
        holder.employeeSalary.setText(employesses.get(position).getEmployee_salary());
        Picasso.get().load(employesses.get(position).getProfile_image()).into(holder.employeePicture);
    }

    @Override
    public int getItemCount() {
        return employesses.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder
    {

        TextView employeeName, employeeAge, employeeSalary;
        ImageView employeePicture;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);


            employeeName = itemView.findViewById(R.id.employeeName);
            employeeAge = itemView.findViewById(R.id.employeeage);
            employeeSalary = itemView.findViewById(R.id.employeeSalary);
            employeePicture = itemView.findViewById(R.id.employeePhoto);
        }
    }

}
