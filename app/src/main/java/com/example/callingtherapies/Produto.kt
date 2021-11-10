package com.example.callingtherapies

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//clase produto para criar objeto

@Entity(tableName = "produtos")
class Produto: Serializable {

    @PrimaryKey
    var id:Long? = null
    var name = ""
    var description = ""
    var price= ""

    override fun toString(): String {
        return "Produtos(nome='$name')"
        "Preço (preço='$description')"
        "Descrição (descrição='$price)"
    }
}