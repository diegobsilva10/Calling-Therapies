package com.example.callingtherapies

import android.app.Application
import java.lang.IllegalStateException

class CallingTherapiesApplication : Application () {

    override fun onCreate(){
        super.onCreate()
        appInstance = this

    }

    companion object{
        private var appInstance: CallingTherapiesApplication? = null

        fun  getInstance(): CallingTherapiesApplication {
            if (appInstance == null){
                throw IllegalStateException("Configurar o Application no Manifest")
            }

            return appInstance!!
        }
    }

}