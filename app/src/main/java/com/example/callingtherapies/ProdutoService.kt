package com.example.callingtherapies

//Serviço que vai consumir a API e mostrar na Acitvity
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.callingtherapies.ProdutoService.parseJson as parseJson

object ProdutoService {

    //URL DA API PARA CONSUMIR

    val host = "https://fastproducts.herokuapp.com"

    val TAG = "WS_CT"

    fun getProdutoService (context: Context): List<Produto> {
        var produtos = listOf<Produto>()
        try {
            val url = "$host/products"

            //VARIAVEL PARA RETORNAR COMO STRING A RESPOSTA DA CHAMADA DA ROTA
            val json = HttpHelper.get(url)
            produtos = parseJson(json)

            // SALVAR OS DADOS RETORNADOS DA API
            for (p in produtos){
                saveOffline(p)
            }
//            Log.d(TAG, json)
//
            produtos = parseJson<MutableList<Produto>>(json)

//        DataBaseManager.getProdutoDAO().delete()

        }catch(e: Exception){
             produtos = DataBaseManager.getProdutoDAO().findAll()
        }


        return produtos
    }

    fun saveOffline(produto: Produto) : Boolean {
        val dao = DataBaseManager.getProdutoDAO()

        if (! existeProduto(produto)) {
            dao.insert(produto)
        }

        return true

    }

    fun existeProduto(produto: Produto): Boolean {
        val dao = DataBaseManager.getProdutoDAO()
        return dao.getById(produto.id) != null
    }



    inline fun <reified T> parseJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}