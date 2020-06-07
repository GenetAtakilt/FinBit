package com.project.finbit.screens;

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


        employess.setEmployee_name(name);
        employess.setEmployee_age(age);
        employess.setEmployee_salary(salary);

        employess.save();
        setResult(RESULT_OK);

        Toast.makeText(InsertEmployeeActivity.this,"inserted",Toast.LENGTH_LONG).show();

        employess.setEmployee_name("uui");
        employess.setEmployee_age("jk");
        employess.setEmployee_salary("nn");


    }

    public void addData(View view)
    {


        insertData();
    }

}
