package com.koje.framework

import android.app.Application
import com.koje.beam.BuildConfig
import com.koje.beam.R

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        init(this)
    }

    companion object {
        val idReceivers = R.id.receivers
        lateinit var instance: Application

        fun init(value: Application) {
            instance = value
        }

        fun debugging():Boolean{
            return BuildConfig.DEBUG
        }

    }


}