package com.example.callingtherapies


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_produto.*

import kotlinx.android.synthetic.main.toolbar.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = "Cadastro de Produto"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button: Button = findViewById(R.id.salvar)
        button.setOnClickListener {


        }
    }

//    override fun onResume() {
//        super.onResume()
//        taskSalvarProdutos()
//    }

//    var produtos = listOf<Produto>()
//    fun taskSalvarProdutos(){
//        Thread {

//            this.produtos = ProdutoService.getProdutoService(this)

//            runOnUiThread {
//                recyclerProdutos?.adapter = ProdutoAdapter(produtos) { onClickProduto(it) }
//            }
//
//        }.start()
//    }
}