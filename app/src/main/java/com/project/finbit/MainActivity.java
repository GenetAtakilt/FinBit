package com.project.finbit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finbit.Base.BaseActivity;
//import com.project.finbit.adapter.EmployeeAdapter;
import com.project.finbit.adapter.EmployeeAdapter;
import com.project.finbit.api.ApiResponse;
import com.project.finbit.api.EmployeeApiService;
import com.project.finbit.entities.Employess;
import com.project.finbit.model.DefultEmployeeResponse;
import com.project.finbit.model.EmployeeResposes;
import com.project.finbit.screens.InsertEmployeeActivity;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity implements View.OnClickListener {

   RecyclerView recyclerView;
   EmployeeAdapter employeeAdapter;
   Employess employess;
   private ArrayList<Employess> employessArrayList;


   TextView insertemployee;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




            insertemployee = findViewById(R.id.addEmployee);
            insertemployee.setOnClickListener(this);

            displayViews();
    }


    private void displayViews()
    {
        employessArrayList = new ArrayList<>();
        employess = new Employess();


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        employessArrayList.add(employess);

        employeeAdapter = new EmployeeAdapter(employessArrayList, MainActivity.this);
        recyclerView.setAdapter(employeeAdapter);
        getemployeeResponse();

    }


    private void getemployeeResponse()
    {

        Call<DefultEmployeeResponse> employeeResponseCall = ApiResponse
                .getRetrofitClient()
                .employeeApiService()
                .getemployess();

        employeeResponseCall.enqueue(new Callback<DefultEmployeeResponse>() {
            @Override
            public void onResponse(Call<DefultEmployeeResponse> call, Response<DefultEmployeeResponse> response) {



                    DefultEmployeeResponse defultEmployeeResponse = response.body();
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();



                                // Null pointer exeption
//                      Log.d("name",defultEmployeeResponse.getEmployeeName());
//                      Log.d("age",defultEmployeeResponse.getEmployeeAge());
//                      Log.d("salary",defultEmployeeResponse.getEmployeeSalary());
//                      Log.d("pic",defultEmployeeResponse.getProfileImage());


            }

            @Override
            public void onFailure(Call<DefultEmployeeResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
              Log.d("error",t.getMessage());
            }
        });



    }

    private void AddEmployee()
    {
        Intent intent = new Intent(MainActivity.this, InsertEmployeeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        AddEmployee();
    }
}
