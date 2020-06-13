package com.project.finbit.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.project.finbit.Base.BaseActivity;
import com.project.finbit.R;
import com.project.finbit.entities.Employess;

public class InsertEmployeeActivity extends BaseActivity {


    EditText employeeName, employeeAge, employeeSalary;
    ImageView employeePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_employee);

        employeeName = findViewById(R.id.eName);
        employeeAge = findViewById(R.id.eage);
        employeeSalary = findViewById(R.id.eSalary);
        employeePhoto = findViewById(R.id.ePhoto);
    }


    public void insertData()
    {
        Employess employess = new Employess();

        String name = employeeName.getText().toString();
        String age = employeeAge.getText().toString();
        String salary = employeeSalary.getText().toString();


        employess.setEmployeeName(name);
        employess.setEmployeeAge(age);
        employess.setEmployeeSalary(salary);


        employess.save();
        setResult(RESULT_OK);

        Toast.makeText(InsertEmployeeActivity.this,"inserted",Toast.LENGTH_LONG).show();

//        employess.setEmployeeName("uui");
//        employess.setEmployeeAge("jk");
//        employess.setProfileImage("nn");


    }

    public void addData(View view)
    {


        insertData();


    }

}
