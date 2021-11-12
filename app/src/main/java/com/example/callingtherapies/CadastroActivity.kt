package com.example.callingtherapies


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_produto.*

import kotlinx.android.synthetic.main.toolbar.*
import kotlin.concurrent.thread

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        setSupportActionBar(toolbar)
        // alterar título da ActionBar
        supportActionBar?.title = "Cadastro de Produto"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button: Button = findViewById(R.id.salvarP)
        val editTextnomeP = findViewById<EditText>(R.id.nomeP)
        val editTextdescicaoP = findViewById<EditText>(R.id.descricaoP)
        val editTextprecoP = findViewById<EditText>(R.id.precoP)

        button.setOnClickListener {
            //criar um objeto Produto
            val criarProduto = Produto()
            criarProduto.name = editTextnomeP.text.toString()
            criarProduto.description = editTextdescicaoP.text.toString()
            criarProduto.price = editTextprecoP.text.toString()

            //converter o criarProduto em JSON
            val gson = Gson()
            val produtoJson = gson.toJson(criarProduto)

            thread{
                val dao = DataBaseManager.getProdutoDAO()
                    .insert(criarProduto)

            }


            //           println("TESTE" + produtoJson )
        }


    }
}