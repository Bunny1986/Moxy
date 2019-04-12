package com.kenyrim.moxy.service;

import com.kenyrim.moxy.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /**
     Retrofit получит аннотацию с вашим URL-адресом и нашим методом, который вернет нам ContactList
    */
    @GET("JSONSample.json")
    Call<Example> getMyJSON();

}
