package com.example.callingtherapies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutoDAO {

    @Query("SELECT * FROM produtos WHERE id=:id")
    fun getById(id: Long?): Produto?

    @Query("SELECT * FROM produtos")
    fun findAll():  List<Produto>

    @Insert
    fun insert(produto: Produto)

    @Query("DELETE from produtos")
    fun delete()
}