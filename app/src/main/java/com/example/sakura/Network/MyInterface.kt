package com.example.sakura.Network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyInterface {
    @POST("user/login")
    fun getLogin(@Body hashMap: HashMap<String,String>):Call<login>
}