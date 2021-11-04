    package com.example.callingtherapies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_produto2.*

    class ProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto2)

        val prod = intent.getSerializableExtra("produto") as Produto

        nome_produto.text = prod.name
        descricao_produto.text = prod.description
        preco_produto.text = prod.price

        //EXIBE O NOME DO PRODUTO CLICADO
        // Toast.makeText(this, "${prod.nomeProduto}", Toast.LENGTH_LONG).show()
    }
}