package com.example.callingtherapies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : DebugActivity2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nome_usuario2 = args?.getString("nome_usuario")
        Toast.makeText(this, "Bem Vindo: $nome_usuario2", Toast.LENGTH_SHORT).show()
        val nome_usuario = args?.getString("nome_usuario")
        mensagemTelaInicial.text = nome_usuario

    }
}