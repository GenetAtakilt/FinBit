package com.project.finbit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResposes {

    private String status;
    private List<DefultEmployeeResponse> data;

    public EmployeeResposes(String status, List<DefultEmployeeResponse> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DefultEmployeeResponse> getData() {
        return data;
    }

    public void setData(List<DefultEmployeeResponse> data) {
        this.data = data;
    }
}
