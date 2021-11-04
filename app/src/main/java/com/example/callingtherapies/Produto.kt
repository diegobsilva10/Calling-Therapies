package com.example.callingtherapies

import java.io.Serializable

//clase produto para criar objeto
class Produto: Serializable {

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