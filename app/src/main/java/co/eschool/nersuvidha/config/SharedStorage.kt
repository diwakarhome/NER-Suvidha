package co.eschool.nersuvidha.config

import android.content.Context
import com.google.gson.Gson

class SharedStorage(context: Context, private val gson: Gson) {
    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    companion object {
        const val SHARED_PREFS = "NER_SHARED_PREFS"
    }
}