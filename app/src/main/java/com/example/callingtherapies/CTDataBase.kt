package com.example.callingtherapies

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Produto::class), version = 1)

abstract  class CTDataBase: RoomDatabase() {

    abstract fun produtoDAO(): ProdutoDAO
}