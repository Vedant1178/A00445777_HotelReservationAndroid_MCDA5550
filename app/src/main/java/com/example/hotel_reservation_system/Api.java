package com.example.hotel_reservation_system;

//import retrofit.RestAdapter;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {


    public static ApiInterface getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                          .baseUrl("http://vedantpatelhotelreservation-env.eba-ye9d3dzb.us-east-1.elasticbeanstalk.com/")
                          .addConverterFactory(GsonConverterFactory.create())
                          .build();


        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }
}
