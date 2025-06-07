package com.example.templateapp.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("items")
    suspend fun fetchItems(): List<String>
}
