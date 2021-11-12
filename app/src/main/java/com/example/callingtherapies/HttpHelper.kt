package com.example.callingtherapies

import android.util.Log
import com.example.callingtherapies.ProdutoService.TAG
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object HttpHelper {
    var client = OkHttpClient()

    val JSON = MediaType.parse("application/json; charset=utf-8")

    fun get (url: String): String{
        val request = Request.Builder().url(url).get().build()
        return getJson(request)

    }

    fun post(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    fun delete(url: String): String{
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)

    }

    fun put (url: String, json: String): String{
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).put(body).build()
        return getJson(request)


    }

    private fun getJson (request: Request): String{
        val response = client.newCall(request).execute()
        val body = response.body()
        val json = body?.string()
        return json!!

    }
}
