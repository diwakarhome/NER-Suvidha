package co.eschool.nersuvidha.utils

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtils(private val context: Context) {

    fun isOnline(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null) {
            if (networkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}