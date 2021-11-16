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

class VerPersonajeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verpersonaje)

        val btnVolver = findViewById<Button>(R.id.buttonVolverVerPersonaje)
        var tvNombre = findViewById<TextView>(R.id.textViewNombrePersonaje)
        val tvClase = findViewById<TextView>(R.id.textViewClasePersonajeMostrar)
        val tvVida = findViewById<TextView>(R.id.textViewVidaPersonajeMostrar)
        val tvMana = findViewById<TextView>(R.id.textViewManaPersonajeMostrar)
        val tvAtaque = findViewById<TextView>(R.id.textViewAtaquePersonajeMostrar)
        val tvDefensa = findViewById<TextView>(R.id.textViewDefensaPersonajeMostrar)
        val tvVelocidad = findViewById<TextView>(R.id.textViewVelocidadPersonajeMostrar)

        val character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        if(character != null){
            tvNombre.text = character.nombre
            tvClase.text = character.clase
            tvVida.text = character.vida.toString()
            tvMana.text = character.mana.toString()
            tvAtaque.text = character.ataque.toString()
            tvDefensa.text = character.defensa.toString()
            tvVelocidad.text = character.velocidad.toString()
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("personaje",character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)
        }

    }

}