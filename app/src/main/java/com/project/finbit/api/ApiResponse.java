package com.project.finbit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiResponse {


    private Retrofit retrofit;
    private static ApiResponse apiResponse;
    String BASE_URL = "http://dummy.restapiexample.com/api/v1/";


    private ApiResponse()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    public static synchronized ApiResponse getRetrofitClient()
    {
        if (apiResponse == null)
        {
            apiResponse = new ApiResponse();
        }

        return apiResponse;
    }

    public EmployeeApiService employeeApiService()
    {
        return retrofit.create(EmployeeApiService.class);
    }
}
