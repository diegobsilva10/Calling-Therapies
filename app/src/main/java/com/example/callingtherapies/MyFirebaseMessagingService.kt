package com.example.callingtherapies

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onNewToken(token: String? ){
        super.onNewToken(token)
        Log.d("Firebase", "Novo Token: $token")
        Prefs.setString("FB_TOKEN", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?){
        Log.d("Firebase","onMessageReceived")

        if(mensagemRemota?.notification != null){
            val titulo = mensagemRemota.notification?.title
            var corpo = mensagemRemota?.notification?.body
            Log.d("Firebase", "Titulo: ${titulo}")
            Log.d("Firebase", "Corpo: ${corpo}")

            if(mensagemRemota?.data.isNotEmpty()){
                val produtoId = mensagemRemota.data.get("produtoId")
                corpo += "$produtoId"
            }

            val intent = Intent (this, ProdutoActivity::class.java)

            NotificationUtil.create(1, intent ,titulo!!, corpo!! )
        }
    }
}