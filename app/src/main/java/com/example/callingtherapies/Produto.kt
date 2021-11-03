package com.example.callingtherapies

import java.io.Serializable

//clase produto para criar objeto
class Produto: Serializable {

    var id:Long? = null
    var nomeProduto = ""
    var precoProduto = ""
    var descricaoProduto = ""

    override fun toString(): String {
        return "Produtos(nome='$nomeProduto')"
        "Preço (preço='$precoProduto')"
        "Descrição (descrição='$descricaoProduto)"
    }
}