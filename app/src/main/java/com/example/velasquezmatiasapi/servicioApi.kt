package com.example.velasquezmatiasapi

import retrofit2.Call
import retrofit2.http.GET

interface servicioApi {


    @GET(value = "posts/")
    fun getAllPost(): Call<List<Post>>
}