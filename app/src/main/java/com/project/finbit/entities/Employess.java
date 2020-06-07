package com.project.finbit.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Unique;

public class Employess extends SugarRecord {

    @Unique
    @Column(name = "id")
    private String id;

    @Column(name = "Employee_name")
    private String employee_name ;

    @Column(name = "Employee_salary")
    private String employee_salary;

    @Column(name = "Employee_age")
    private String employee_age;

    @Column(name = "Profile_name")
    private String profile_image;

    public Employess() {
    }

    public Employess(String employee_name, String employee_salary, String employee_age, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }


    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}