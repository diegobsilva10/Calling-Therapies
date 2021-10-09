package com.example.callingtherapies

//Objeto para criar determinada quantidade de produtos de forma dinâmica
import android.content.Context

object ProdutoService {
    fun getProdutoService (context: Context): List<Produto> {
        val produtos = mutableListOf<Produto>()

        // criar 10 disciplinas
        for (i in 1..50) {
            val p = Produto()
            p.nomeProduto = "Produto: $i"
            p.precoProduto = "Preço R$: $i"
            produtos.add(p)
        }
        return produtos
    }

}