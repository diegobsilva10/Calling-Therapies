package com.example.callingtherapies

//Objeto para criar determinada quantidade de produtos de forma dinâmica
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object ProdutoService {

    //URL DA API PARA CONSUMIR

    val host = "https://fastproducts.herokuapp.com"

    val TAG = "WS_CT"

    fun getProdutoService (context: Context): List<Produto> {
//        var produtos = mutableListOf<Produto>()

//        val url = "$host/products"
//
//        //VARIAVEL PARA RETORNAR COMO STRING A RESPOSTA DA CHAMADA DA ROTA
//        val json = HttpHelper.get(url)
//
//        Log.d(TAG, json)
//
//        produtos = parseJson<MutableList<Produto>>(json)

      var  produtos = DataBaseManager.getProdutoDAO().findAll()

        return produtos
    }

    inline fun <reified T> parseJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}