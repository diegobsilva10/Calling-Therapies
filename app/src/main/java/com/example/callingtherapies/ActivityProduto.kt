package com.example.callingtherapies

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_produto.*
import kotlinx.android.synthetic.main.activity_produto.layoutMenuLateral
import kotlinx.android.synthetic.main.activity_produto.menu_lateral
import kotlinx.android.synthetic.main.activity_tratamentos.*

import kotlinx.android.synthetic.main.toolbar.*

class ActivityProduto : DebugActivity2(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)


        //IMPLEMENTA A TOOLBAR CRIADA
        setSupportActionBar(toolbar)
        // alterar título da ActionBar
        supportActionBar?.title = "Produtos"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // configuração do menu lateral
        configuraMenuLateral()

        recyclerProdutos?. layoutManager = LinearLayoutManager(this)
        recyclerProdutos?.itemAnimator = DefaultItemAnimator()
        recyclerProdutos?.setHasFixedSize(true)
    }
    fun onClickProduto(produto: Produto){
        Toast.makeText(this, "Clicou no produto ${produto.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProdutoActivity::class.java)
        intent.putExtra("produto", produto)
        startActivity(intent)
    }


    override fun onResume() {
        super.onResume()
        taskProdutos()
    }

    var produtos = listOf<Produto>()
    fun taskProdutos(){
        Thread {

            this.produtos = ProdutoService.getProdutoService(this)

            runOnUiThread {
                recyclerProdutos?.adapter = ProdutoAdapter(produtos) { onClickProduto(it) }
            }

        }.start()
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
// CONFIGURA MENU LATERAL E EVENTOS DE CLICK
    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.abrir,
            R.string.fechar,
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Tratamentos -> {
                Toast.makeText(this, "Clicou Tratamentos", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityTratamentos::class.java)
                // fazer a chamada
                startActivity(intent)
            }

            R.id.nav_agende -> {
                Toast.makeText(this, "Clicou em Agende", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AgendeJaActivity::class.java)
                // fazer a chamada
                startActivity(intent)

            }

            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou Localize", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, activity_localize::class.java)
                startActivity(intent)

            }

            R.id.nav_config -> {
                Toast.makeText(this, "Clicou Config", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ConfiguracoesActivity::class.java)
                startActivity(intent)
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

}


