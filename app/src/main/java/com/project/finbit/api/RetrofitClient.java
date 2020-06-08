package com.project.finbit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private Retrofit retrofit;
    private static RetrofitClient apiResponse;
    String BASE_URL = "http://dummy.restapiexample.com/api/v1/";


    private RetrofitClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    public static synchronized RetrofitClient getRetrofitClient()
    {
        if (apiResponse == null)
        {
            apiResponse = new RetrofitClient();
        }

        return apiResponse;
    }

    public EmployeeApiService employeeApiService()
    {
        return retrofit.create(EmployeeApiService.class);
    }
}
