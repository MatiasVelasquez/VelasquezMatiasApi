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

class VerLoboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_lobo)

        val btnVolver = findViewById<Button>(R.id.buttonVolverVerLobo)
        val tvVida = findViewById<TextView>(R.id.textViewVidaLoboMostrar)
        val tvMana = findViewById<TextView>(R.id.textViewManaLoboMostrar)
        val tvAtaque = findViewById<TextView>(R.id.textViewAtaqueLoboMostrar)
        val tvDefensa = findViewById<TextView>(R.id.textViewDefensaLoboMostrar)
        val tvVelocidad = findViewById<TextView>(R.id.textViewVelocidadLoboMostrar)
        val tvColorPelaje = findViewById<TextView>(R.id.textViewColorPelajeLoboMostrar)

        var character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        if(lobo1 != null){
            tvVida.text = lobo1.vida.toString()
            tvMana.text = lobo1.mana.toString()
            tvAtaque.text = lobo1.ataque.toString()
            tvDefensa.text = lobo1.defensa.toString()
            tvVelocidad.text = lobo1.velocidad.toString()
            tvColorPelaje.text = lobo1.colorPelaje
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