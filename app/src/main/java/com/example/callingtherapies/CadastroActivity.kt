package com.example.callingtherapies


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.toolbar.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = "Cadastro de Produto"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}