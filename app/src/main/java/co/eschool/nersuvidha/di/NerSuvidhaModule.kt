package co.eschool.nersuvidha.di

import co.eschool.nersuvidha.api.NerSuvidhaApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val nerSuvidhaModule = module {

    single<Gson> {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        gsonBuilder.create()
    }

    single<NerSuvidhaApi> {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("BuildConfig.BASE_URL")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()

        retrofit.create<NerSuvidhaApi>(NerSuvidhaApi::class.java)
    }
}