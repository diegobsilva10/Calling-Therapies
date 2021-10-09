package com.example.callingtherapies
//clase produto para criar objeto
class Produto {

    var id:Long? = null
    var nomeProduto = ""
    var precoProduto = ""

    override fun toString(): String {
        return "Produtos(nome='$nomeProduto')"
    }
}