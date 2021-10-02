package com.example.callingtherapies

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.widget.*

import kotlinx.android.synthetic.main.activity_tela_inicial.mensagemTelaInicial
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.tela_inicial2.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.thread

class TelaInicialActivity : DebugActivity2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial2)
        progressbar.visibility = View.GONE




        val args = intent.extras
        val nome_usuario2 = args?.getString("nome_usuario")
        Toast.makeText(this, "Bem Vindo: $nome_usuario2", Toast.LENGTH_SHORT).show()
        val nome_usuario = args?.getString("nome_usuario")


        mensagemTelaInicial.text = nome_usuario
        //IMPLEMENTA A TOOLBAR CRIADA
        setSupportActionBar(toolbar)


        //EVENTOS DE CLICK ATRAVÉS DO ID DO BOTÃO (ID LOCALIZADO tela_inicial2.xml)
        val buttonProduto: Button = findViewById(R.id.botao1)
        buttonProduto.setOnClickListener {

            //INTENT CRIADA PARA MUDAR PARA A ACTIVITY PRODUTO AO CLICAR NO BOTÃO
            var intent = Intent(this, ActivityProduto::class.java)
            intent.putExtra("nome_usuario", nome_usuario)
            startActivity(intent)

        }

        //AÇÃO DE BOTÃO DO TRATAMENTO
        val buttonTratamentos: Button = findViewById(R.id.botao2)
        buttonTratamentos.setOnClickListener {

            //INTENT CRIADA PARA MUDAR PARA A ACTIVITY PRODUTO AO CLICAR NO BOTÃO
            var intent = Intent(this, ActivityTratamentos::class.java)
            intent.putExtra("nome_usuario", nome_usuario)
            startActivity(intent)


        }
        val buttonAgende: Button = findViewById(R.id.botao3)
        buttonAgende.setOnClickListener {

            //INTENT CRIADA PARA MUDAR PARA A ACTIVITY PRODUTO AO CLICAR NO BOTÃO
            var intent = Intent(this, AgendeJaActivity::class.java)
            intent.putExtra("nome_usuario", nome_usuario)
            startActivity(intent)

        }
        val buttonSair: Button = findViewById(R.id.botao_sair)
        buttonSair.setOnClickListener { cliqueSair(botao_sair) }

    }

    fun criarProgressBar(){
        Toast.makeText(this, "Atualizando", Toast.LENGTH_LONG).show()
        progressbar.visibility = View.VISIBLE
        val currentProgress = 600
        ObjectAnimator.ofInt(progressbar, "progress", currentProgress)
            .start()



    }

    fun offProgressBar(){
        Thread.sleep(1000)
        progressbar.visibility = View.GONE
    }


    fun cliqueSair(botao_sair: Button) {
        val returnIntent = Intent(this, MainActivity::class.java);
        returnIntent.putExtra("result", "Saída do BrewerApp");
        setResult(Activity.RESULT_OK, returnIntent);
    }


    // método sobrescrito para inflar o menu na Actionbar
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

                    return false
                }

            })
        return true
    }


    @SuppressLint("ResourceType")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem Toast na tela
        // a comparação é feita com o recurso de id definido no xml

        if (id == R.id.action_atualizar) {
            GlobalScope.launch(context =  Dispatchers.Main) {
                criarProgressBar()


            }

            GlobalScope.launch(context = Dispatchers.Main){




            }




        } else if (id == R.id.action_adicionar_produtos) {
            Toast.makeText(this, "Adicionar Produtos", Toast.LENGTH_SHORT).show()
            // criar intent
            val intent = Intent(this, CadastroActivity::class.java)
            // colocar parâmetros (opcional)
            val params = Bundle()
            intent.putExtras(params)
            // fazer a chamada
            startActivity(intent)

        } else if (id == R.id.action_configuracoes) {
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            //INTENT CRIADA PARA MUDAR DE PAGINA AO CLICAR NO BOTÃO
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            // colocar parâmetros (opcional)
            val params = Bundle()
            intent.putExtras(params)
            // fazer a chamada
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun <T> findViewById(pb: ProgressBar?) {

    }


}

