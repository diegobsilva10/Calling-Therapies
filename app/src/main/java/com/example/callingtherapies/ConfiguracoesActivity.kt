package com.example.callingtherapies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class ConfiguracoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)
        setSupportActionBar(toolbar)
        // alterar título da ActionBar
        supportActionBar?.title = "Configurações"
    }
}