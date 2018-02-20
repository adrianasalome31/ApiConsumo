package com.example.adriana.apiconsumo.Api;

import com.example.adriana.apiconsumo.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by adriana on 02-18-18.
 */

public interface ApiInterface {

        @GET("students")
        Call<List<Student>> getStudents();

        @POST("students")
        Call<Student> createStudent(@Body Student student);

}

