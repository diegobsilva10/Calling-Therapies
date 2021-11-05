package com.example.callingtherapies


import android.content.Intent

import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.tela_inicial2.*

class MainActivity : DebugActivity2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        campo_usuario.setText(Prefs.getString("nome_user"))
        campo_senha.setText(Prefs.getString("senha_user"))
        checkBoxLogin.isChecked = Prefs.getBoolean("lembrar_login")

        //EVENTO DE CLICK ATRAVÉS DO ID DO BOTÃO LOGIN (ID LOCALIZADO LOGIN_XML)
        val button: Button = findViewById(R.id.botao_login)
        button.setOnClickListener {



            val nome_usuario = campo_usuario.text.toString()
            val senha = campo_senha.text.toString()
            val check_login = checkBoxLogin.isChecked

            if (check_login) {
                Prefs.setString("nome_user", nome_usuario)
                Prefs.setString("senha_user", senha)
            } else{
                Prefs.setString("nome_user", "")
                Prefs.setString("senha_user", "")
            }
            Prefs.setBoolean("lembrar_login", check_login)

            if (nome_usuario == "aluno" && senha == "impacta"){
                //INTENT CRIADA PARA MUDAR DE PAGINA AO CLICAR NO BOTÃO
                var intent = Intent (this, TelaInicialActivity::class.java)
                //EXIBE MENSAGEM NA TELA
                Toast.makeText(this,"Logando Usuario",Toast.LENGTH_SHORT).show()
                intent.putExtra("nome_usuario", nome_usuario)
                startActivity(intent)

            }else{
                Toast.makeText(this,"Usuario ou Senha Incorreto",Toast.LENGTH_SHORT).show()
            }

        }

    }


}
