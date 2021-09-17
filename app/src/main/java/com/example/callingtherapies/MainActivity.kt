package com.example.callingtherapies


import android.content.Intent

import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        //EVENTO DE CLICK ATRAVÉS DO ID DO BOTÃO LOGIN (ID LOCALIZADO LOGIN_XML)
        val button: Button = findViewById(R.id.botao_login)
        button.setOnClickListener {
            //EXIBE MENSAGEM NA TELA
            Toast.makeText(this,"Logando Usuario",Toast.LENGTH_SHORT).show()
            val nome_usuario = campo_usuario.text.toString()

            //INTENT CRIADA PARA MUDAR DE PAGINA AO CLICAR NO BOTÃO
            var intent = Intent (this, TelaInicialActivity::class.java)
            intent.putExtra("nome_usuario", nome_usuario)
            startActivity(intent)
        }

    }


}
