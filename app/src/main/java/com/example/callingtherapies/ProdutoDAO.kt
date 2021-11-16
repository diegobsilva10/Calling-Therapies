package com.example.callingtherapies

import androidx.room.*

@Dao
interface ProdutoDAO {

    @Query("SELECT * FROM produtos WHERE id=:id")
    fun getById(id: Long?): Produto?

    @Query("SELECT * FROM produtos")
    fun findAll():  List<Produto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(produto: Produto)


    @Delete
    fun delete(produto: Produto)
}