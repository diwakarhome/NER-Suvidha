package co.eschool.nersuvidha.config

import android.content.Context
import co.eschool.nersuvidha.R
import co.eschool.nersuvidha.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(
    private val context: Context, private val networkUtils: NetworkUtils
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkUtils.isOnline()) {
            throw IOException(context.getString(R.string.check_your_internet_connection))
        }
        return chain.proceed(chain.request().newBuilder().build())
    }
}