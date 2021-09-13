package com.example.callingtherapies


import android.content.Intent

import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val button: Button = findViewById(R.id.botao_login)
        button.setOnClickListener {
            Toast.makeText(this,"Logando Usuario",Toast.LENGTH_SHORT).show()
            val nome_usuario =  campo_usuario.text.toString()

            var intent = Intent (this, TelaInicialActivity::class.java)
            startActivity(intent)
            val params = Bundle()
            params.putString("nome_pessoa", "Diego")

            intent.putExtras(params)

            intent.putExtra("nome_usuario", nome_usuario)
        }

    }


}
