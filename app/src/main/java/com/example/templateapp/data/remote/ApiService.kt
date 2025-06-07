package com.example.templateapp.data.remote

import retrofit2.http.GET

// Retrofit turns this interface into a concrete implementation at runtime.
// It contains the HTTP endpoints our app can call.
interface ApiService {
    // Simple GET request that returns a list of item names.
    @GET("items")
    suspend fun fetchItems(): List<String>
}
