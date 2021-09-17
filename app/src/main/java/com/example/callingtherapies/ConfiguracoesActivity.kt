package com.example.callingtherapies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class ConfiguracoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)
        setSupportActionBar(toolbar)
        // alterar título da ActionBar
        supportActionBar?.title = "Configurações"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
