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

class VerAranaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_arana)

        val btnVolver = findViewById<Button>(R.id.buttonVolverArañaVer)
        val tvVida = findViewById<TextView>(R.id.textViewVidaArañaMostrar)
        val tvMana = findViewById<TextView>(R.id.textViewManaArañaMostrar)
        val tvAtaque = findViewById<TextView>(R.id.textViewAtaqueArañaMostrar)
        val tvDefensa = findViewById<TextView>(R.id.textViewDefensaArañaMostrar)
        val tvVelocidad = findViewById<TextView>(R.id.textViewVelocidadArañaMostrar)
        val tvDureza = findViewById<TextView>(R.id.textViewGradoVenenoArañaMostrar)

        var character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")


        if(araña1 != null){
            tvVida.text = araña1.vida.toString()
            tvMana.text = araña1.mana.toString()
            tvAtaque.text = araña1.ataque.toString()
            tvDefensa.text = araña1.defensa.toString()
            tvVelocidad.text = araña1.velocidad.toString()
            tvDureza.text = araña1.gradoVeneno.toString()
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