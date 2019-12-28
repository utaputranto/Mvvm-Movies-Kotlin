package com.triputranto.mvvmkotlin.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import java.util.*

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    fun checkLanguage(): String {
        var language = Locale.getDefault().toString()
        if (language == "in_ID") {
            language = "id_ID"
        }
        return language
    }
}