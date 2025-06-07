package com.example.templateapp.di

import com.example.templateapp.data.remote.ApiService
import com.example.templateapp.data.repository.DefaultExampleRepository
import com.example.templateapp.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindExampleRepository(
        impl: DefaultExampleRepository
    ): ExampleRepository

    companion object {
        private const val BASE_URL = "https://example.com/"

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)
    }
}
