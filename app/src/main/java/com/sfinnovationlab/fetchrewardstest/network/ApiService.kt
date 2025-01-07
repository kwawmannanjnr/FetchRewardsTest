package com.sfinnovationlab.fetchrewardstest.network

import com.sfinnovationlab.fetchrewardstest.model.Item
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory



interface ApiService {
    @GET("hiring.json")
    suspend fun fetchItems(): List<Item>

    private fun createApiService(): ApiService {
        val client = OkHttpClient.Builder().build()
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

}