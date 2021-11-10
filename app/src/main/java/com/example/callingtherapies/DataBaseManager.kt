package com.example.callingtherapies

import androidx.room.Room

object DataBaseManager {
    private  var dbInstance: CTDataBase

    init{
        val context = CallingTherapiesApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            CTDataBase::class.java,
            "ct.sqlite"
        ).build()

    }

    fun getProdutoDAO(): ProdutoDAO{
        return dbInstance.produtoDAO()
    }
}