package com.project.finbit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeResposes {

    @SerializedName("employeeResposes")
    @Expose
    private DefultEmployeeResponse[] defultEmployeeResponses;

    public DefultEmployeeResponse[] getDefultEmployeeResponses()
    {
        return defultEmployeeResponses;
    }
}
