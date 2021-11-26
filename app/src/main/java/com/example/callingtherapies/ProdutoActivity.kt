    package com.example.callingtherapies

    import android.Manifest
    import android.content.Intent
    import android.os.Bundle
    import android.view.Menu
    import android.view.MenuItem
    import android.widget.Button
    import android.widget.SearchView
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.app.ActivityCompat
    import kotlinx.android.synthetic.main.activity_produto2.*
    import kotlinx.android.synthetic.main.toolbar.*
    import kotlin.concurrent.thread


    class ProdutoActivity : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_produto2)

            //IMPLEMENTA A TOOLBAR CRIADA
            setSupportActionBar(toolbar)
            // alterar título da ActionBar
            supportActionBar?.title = "Produtos"






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

                thread {
                    val dao = DataBaseManager.getProdutoDAO()
                        .insert(prod)
                }


            }


        }


        fun saveOffline(produto: Produto): Boolean {
            val dao = DataBaseManager.getProdutoDAO()

            if (!existeProduto(produto)) {
                dao.insert(produto)
            }

            return true

        }

        fun existeProduto(produto: Produto): Boolean {
            val dao = DataBaseManager.getProdutoDAO()
            return dao.getById(produto.id) != null
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            // infla o menu com os botões da ActionBar
            menuInflater.inflate(R.menu.bottom_menu_main, menu)
            // vincular evento de buscar
            (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {

                    override fun onQueryTextChange(newText: String): Boolean {
                        // ação enquanto está digitando
                        return false
                    }

                    override fun onQueryTextSubmit(query: String): Boolean {
                        // ação  quando terminou de buscar e enviou
                        return false
                    }

                }
            )
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // id do item clicado
            val id = item?.itemId
            // verificar qual item foi clicado e mostrar a mensagem Toast na tela
            // a comparação é feita com o recurso de id definido no xml
            if (id == R.id.action_buscar) {
                Toast.makeText(this, "Buscar", Toast.LENGTH_LONG).show()
            } else if (id == R.id.action_adicionar_produtos) {
                Toast.makeText(this, "Adicionar Produtos", Toast.LENGTH_LONG).show()
                // criar intent
                val intent = Intent(this, CadastroActivity::class.java)
                // colocar parâmetros (opcional)
                val params = Bundle()
                intent.putExtras(params)
                // fazer a chamada
                startActivity(intent)
            } else if (id == R.id.action_configuracoes) {
                Toast.makeText(this, "Configurações", Toast.LENGTH_LONG).show()
                //INTENT CRIADA PARA MUDAR DE PAGINA AO CLICAR NO BOTÃO
                val intent = Intent(this, ConfiguracoesActivity::class.java)
                // colocar parâmetros (opcional)
                val params = Bundle()
                intent.putExtras(params)
                // fazer a chamada
                startActivity(intent)
            }
            // botão up navigation
            else if (id == android.R.id.home) {
                finish()
            }
            return super.onOptionsItemSelected(item)
        }



        //EXIBE O NOME DO PRODUTO CLICADO
        // Toast.makeText(this, "${prod.nomeProduto}", Toast.LENGTH_LONG).show()
    }
