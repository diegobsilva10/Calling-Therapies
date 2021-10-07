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
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tratamentos.*
import kotlinx.android.synthetic.main.tela_inicial2.*
import kotlinx.android.synthetic.main.toolbar.*

class ActivityTratamentos : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tratamentos)

        // alterar título da ActionBar
        supportActionBar?.title = "Tratamentos"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setSupportActionBar(toolbar)

        // configuração do menu lateral
        configuraMenuLateral()

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
            }

            R.id.nav_mensagens -> {
                Toast.makeText(this, "Clicou Mensagens", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_forum -> {
                Toast.makeText(this, "Clicou Forum", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou Localização", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_config -> {
                Toast.makeText(this, "Clicou Config", Toast.LENGTH_SHORT).show()
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }


}
