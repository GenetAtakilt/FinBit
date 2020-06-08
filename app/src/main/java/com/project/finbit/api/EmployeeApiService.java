package com.project.finbit.api;

import com.project.finbit.model.DefultEmployeeResponse;
import com.project.finbit.model.EmployeeResposes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeApiService {



    @GET("employees")
    Call<EmployeeResposes> getemployess();
}
