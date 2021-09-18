package com.example.callingtherapies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class ActivityProduto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        //IMPLEMENTA A TOOLBAR CRIADA
        setSupportActionBar(toolbar)
        // alterar título da ActionBar
        supportActionBar?.title = "Produtos"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}