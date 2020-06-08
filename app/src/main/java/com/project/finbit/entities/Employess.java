package com.project.finbit.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Unique;

public class Employess extends SugarRecord {

    @Unique
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName ;

    @Column(name = "employee_salary")
    private String employeeSalary;

    @Column(name = "employee_age")
    private String employeeAge;

    @Column(name = "profile_name")
    private String profileImage;


    public Employess() {
    }

    public Employess(String employeeName, String employeeSalary, String employeeAge, String profileImage) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
