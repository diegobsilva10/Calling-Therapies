package com.example.callingtherapies

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.tela_inicial2.*
import kotlinx.android.synthetic.main.toolbar.*

class ActivityTratamentos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial2)

        //IMPLEMENTA A TOOLBAR CRIADA
        setSupportActionBar(toolbar)
        // alterar título da ActionBar
        supportActionBar?.title = "Tratamentos"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //EVENTOS DE CLICK ATRAVÉS DO ID DO BOTÃO LOGIN (ID LOCALIZADO tela_inicial2.xml)
        //AÇÃO DE BOTÃO DO PRODUTOS
        val buttonProduto: Button = findViewById(R.id.botao1)
        buttonProduto.setOnClickListener {

//            //EXIBE MENSAGEM NA TELA
//            Toast.makeText(this,"Produtos",Toast.LENGTH_SHORT).show()


            //INTENT CRIADA PARA MUDAR PARA A ACTIVITY PRODUTO AO CLICAR NO BOTÃO
            var intent = Intent(this, ActivityProduto::class.java)

            startActivity(intent)
        }


        val buttonAgende: Button = findViewById(R.id.botao3)
        buttonAgende.setOnClickListener {

//            //EXIBE MENSAGEM NA TELA
//            Toast.makeText(this,"Produtos",Toast.LENGTH_SHORT).show()


            //INTENT CRIADA PARA MUDAR PARA A ACTIVITY PRODUTO AO CLICAR NO BOTÃO
            var intent = Intent(this, AgendeJaActivity::class.java)

            startActivity(intent)
        }
        val buttonSair :  Button = findViewById(R.id.botao_sair)
        buttonSair.setOnClickListener {cliqueSair(botao_sair)}
    }
    fun cliqueSair(botao_sair: Button) {
        val returnIntent = Intent(this, MainActivity::class.java);
        returnIntent.putExtra("result", "Saída do BrewerApp");
        setResult(Activity.RESULT_OK, returnIntent);
        finish()
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

            })
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
    }
