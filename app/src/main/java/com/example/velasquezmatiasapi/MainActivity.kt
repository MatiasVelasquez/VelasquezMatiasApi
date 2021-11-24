package com.example.velasquezmatiasapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsuario = findViewById<EditText>(R.id.editTextUsuario)
        val etClave = findViewById<EditText>(R.id.editTextClave)
        val btnlogin = findViewById<Button>(R.id.buttonIngresar)

        btnlogin.setOnClickListener {
            ingresar(etUsuario, etClave)
        }
    }

    fun ingresar(etUsuario: EditText, etClave: EditText) {

        var nombreUsuarioIngresa = etUsuario.text.toString()
        var claveIngresa = etClave.text.toString()

        val administrador = usuario(nombreUsuarioIngresa,claveIngresa)

        if (administrador.nombreUsuario == "admin" && administrador.clave == "admin") {

            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("administrador", administrador)

            startActivity(intent)
        } else {
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
        }

    }
}