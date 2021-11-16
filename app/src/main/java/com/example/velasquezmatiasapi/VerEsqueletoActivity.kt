package com.example.velasquezmatiasapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.velasquezmatias.Araña
import com.example.velasquezmatias.Esqueleto
import com.example.velasquezmatias.Lobo
import com.example.velasquezmatias.Personaje

class VerEsqueletoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_esqueleto)

        val btnVolver = findViewById<Button>(R.id.buttonVolver)
        val tvVida = findViewById<TextView>(R.id.textViewVidaEsqueletoMostrar)
        val tvMana = findViewById<TextView>(R.id.textViewManaEsqueletoMostrar)
        val tvAtaque = findViewById<TextView>(R.id.textViewAtaqueEsqueletoMostrar)
        val tvDefensa = findViewById<TextView>(R.id.textViewDefensaEsqueletoMostrar)
        val tvVelocidad = findViewById<TextView>(R.id.textViewVelocidadEsqueletoMostrar)
        val tvDureza = findViewById<TextView>(R.id.textViewDurezaEsqueletoMostrar)

        var character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        if(esqueleto1 != null){
            tvVida.text = esqueleto1.vida.toString()
            tvMana.text = esqueleto1.mana.toString()
            tvAtaque.text = esqueleto1.ataque.toString()
            tvDefensa.text = esqueleto1.defensa.toString()
            tvVelocidad.text = esqueleto1.velocidad.toString()
            tvDureza.text = esqueleto1.dureza.toString()
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this, BestiarioActivity::class.java)
            intent.putExtra("personaje",character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)
        }
    }
}