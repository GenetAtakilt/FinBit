package com.project.finbit.api;

import com.project.finbit.model.DefultEmployeeResponse;
import com.project.finbit.model.EmployeeResposes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeApiService {



    @GET("employees")
    Call<DefultEmployeeResponse> getemployess();
}
