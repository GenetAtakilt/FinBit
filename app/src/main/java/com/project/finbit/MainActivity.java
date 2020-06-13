package com.project.finbit;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finbit.Base.BaseActivity;
//import com.project.finbit.adapter.EmployeeAdapter;
import com.project.finbit.adapter.EmployeeAdapter;
import com.project.finbit.api.RetrofitClient;
import com.project.finbit.entities.Employess;
import com.project.finbit.model.DefultEmployeeResponse;
import com.project.finbit.model.EmployeeResposes;
import com.project.finbit.screens.InsertEmployeeActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {



  private RecyclerView recyclerView;
  private List<DefultEmployeeResponse> defultEmployeeResponses;
   EmployeeAdapter employeeAdapter;
   private List<Employess> employessList;

//   Employess employess;
//   private ArrayList<Employess> employessArrayList;
//   private ArrayList<DefultEmployeeResponse> defultEmployeeResponseArrayList;


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
//        employessArrayList = new ArrayList<>();
//        employess = new Employess();
//
//
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        getemployeeResponse();


    }


    private void getemployeeResponse()
    {

        Call<EmployeeResposes> employeeResponseCall = RetrofitClient
                .getRetrofitClient()
                .employeeApiService()
                .getemployess();

        employeeResponseCall.enqueue(new Callback<EmployeeResposes>() {
            @Override
            public void onResponse(Call<EmployeeResposes> call, Response<EmployeeResposes> response) {

                if(!response.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this,response.code(),Toast.LENGTH_LONG);
                        return;
                    }

                defultEmployeeResponses = response.body().getData();
                //Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();

             insertEmployee();

            }

            @Override
            public void onFailure(Call<EmployeeResposes> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("error",t.getMessage());

            }
        });







    }

    private void insertEmployee()
    {
        Employess employess = new Employess();
        employessList = new ArrayList<>();


        for (DefultEmployeeResponse employeeResponse : defultEmployeeResponses)
        {
          //  Toast.makeText(MainActivity.this,employeeResponse.getEmployeeName(),Toast.LENGTH_LONG).show();

            employess.setEmployeeName(employeeResponse.getEmployeeName());
            employess.setEmployeeAge(employeeResponse.getEmployeeAge());
            employess.setEmployeeSalary(employeeResponse.getEmployeeSalary());
            employess.setProfileImage(employeeResponse.getProfileImage());



        }

        //Toast.makeText(MainActivity.this,employess.getEmployeeName(),Toast.LENGTH_LONG).show();
         employess.save();
        employessList.add(employess);


        setResult(RESULT_OK);

        //Toast.makeText(MainActivity.this,"inserted",Toast.LENGTH_LONG).show();
        employeeAdapter = new EmployeeAdapter(MainActivity.this, employessList);
        recyclerView.setAdapter(employeeAdapter);


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
