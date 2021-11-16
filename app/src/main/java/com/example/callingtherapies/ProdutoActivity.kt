    package com.example.callingtherapies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.callingtherapies.ProdutoService.existeProduto
import kotlinx.android.synthetic.main.activity_produto2.*
import kotlin.concurrent.thread

    class ProdutoActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_produto2)

            var prod = intent.getSerializableExtra("produto") as Produto

            val button: Button = findViewById(R.id.botaoSalvarOf)
            nome_produto.text = prod.name
            descricao_produto.text = prod.description
            preco_produto.text = prod.price

            button.setOnClickListener {
              //  val criarProduto = Produto()
              //  criarProduto.name = prod.name
              //  criarProduto.description = prod.description
              //  criarProduto.price = prod.price

                thread{
                    val dao = DataBaseManager.getProdutoDAO()
                        .insert(prod)
                }


                }

            }


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

            //EXIBE O NOME DO PRODUTO CLICADO
            // Toast.makeText(this, "${prod.nomeProduto}", Toast.LENGTH_LONG).show()

