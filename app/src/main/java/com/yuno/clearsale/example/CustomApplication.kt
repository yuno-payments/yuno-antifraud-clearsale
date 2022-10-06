package com.yuno.clearsale.example

import android.app.Application
import com.yuno.antifraud.clearsale.initYunoClearSale

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initYunoClearSale("Your ClearSale app key")
    }
}