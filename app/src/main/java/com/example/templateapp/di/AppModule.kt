package com.example.templateapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.templateapp.data.remote.ApiService
import com.example.templateapp.data.repository.DefaultExampleRepository
import com.example.templateapp.data.repository.ExampleRepository
import com.example.templateapp.data.repository.UserPreferenceRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import java.time.LocalDate
import javax.inject.Singleton

// Hilt module that supplies app wide dependencies.
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val BASE_URL = "http://10.0.2.2:3000/"

    // Configure JSON parsing that ignores unknown fields.
    @Provides @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false

        /*
        serializersModule = SerializersModule {
            contextual(LocalDate::class, LocalDateSerializer)
        }
        */
    }

    /*
    // Uncomment this section when you have a backend to talk to.
    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()


    @Provides
    @Singleton
    fun provideDierentuinApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository (dierentuinApiService : ApiService ): ExampleRepository {
        return DefaultExampleRepository( dierentuinApiService )
    }
    */

    // ExampleRepository used throughout the app. Swap the implementation here
    // when you need to fetch data from a different source.
    @Provides
    @Singleton
    fun provideRepository (): ExampleRepository {
        return DefaultExampleRepository()
    }


    // DataStore instance used for persistent user settings.
    @Provides
    @Singleton
    fun providePreferencesDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = PreferenceDataStoreFactory.create(
        corruptionHandler = ReplaceFileCorruptionHandler(
            produceNewData = { emptyPreferences() }
        ),
        migrations = listOf(
            SharedPreferencesMigration(context, "user_prefs")
        ),
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
        produceFile = { context.preferencesDataStoreFile("user_preferences") }
    )

    // Repository that exposes typed accessors for DataStore values.
    @Provides
    @Singleton
    fun provideUserPreferenceRepository(
        dataStore: DataStore<Preferences>
    ): UserPreferenceRepository = UserPreferenceRepository(dataStore)
}
