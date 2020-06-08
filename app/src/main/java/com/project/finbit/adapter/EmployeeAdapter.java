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
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

//    private ArrayList<Employess> employesses;



    private Context mCtx;

    private List<DefultEmployeeResponse> defultEmployeeResponses;

    public EmployeeAdapter(Context mCtx, List<DefultEmployeeResponse> defultEmployeeResponses) {
        this.mCtx = mCtx;
        this.defultEmployeeResponses = defultEmployeeResponses;
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

        holder.employeeName.setText(defultEmployeeResponses.get(position).getEmployeeName());
        holder.employeeAge.setText(defultEmployeeResponses.get(position).getEmployeeAge());
        holder.employeeSalary.setText(defultEmployeeResponses.get(position).getEmployeeSalary());

        if (defultEmployeeResponses.get(position).getProfileImage().isEmpty()) {
            holder.employeePicture.setImageResource(R.drawable.add_photo);
        } else{
            Picasso.get().load(defultEmployeeResponses.get(position).getProfileImage()).into( holder.employeePicture);
        }
        //Picasso.get().load(defultEmployeeResponses.get(position).getProfileImage()).into(holder.employeePicture);
//        holder.employeePicture.setImageDrawable(mCtx.getResources().getDrawable(defultEmployeeResponses.));
    }

    @Override
    public int getItemCount() {
        return defultEmployeeResponses.size();
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
