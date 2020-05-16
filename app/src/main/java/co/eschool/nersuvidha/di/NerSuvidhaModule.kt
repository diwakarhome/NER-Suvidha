package co.eschool.nersuvidha.di

import co.eschool.nersuvidha.api.NerSuvidhaApi
import co.eschool.nersuvidha.config.ConnectivityInterceptor
import co.eschool.nersuvidha.config.SharedStorage
import co.eschool.nersuvidha.user.UserRepository
import co.eschool.nersuvidha.utils.NetworkUtils
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val nerSuvidhaModule = module {

    single<Gson> {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        gsonBuilder.create()
    }

    single { SharedStorage(androidContext(), get()) }
    single { NetworkUtils(androidContext()) }

    single<NerSuvidhaApi> {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(ConnectivityInterceptor(androidContext(), get()))
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("BuildConfig.BASE_URL")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()

        retrofit.create(NerSuvidhaApi::class.java)
    }

    single { UserRepository(get()) }
}