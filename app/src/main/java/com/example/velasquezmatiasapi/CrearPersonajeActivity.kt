package com.example.velasquezmatiasapi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.widget.Toast
import com.example.velasquezmatias.*
import kotlin.concurrent.thread


class CrearPersonajeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_personaje)

        val etNombre = findViewById<EditText>(R.id.editTextNombrePersonaje)
        val etClase = findViewById<EditText>(R.id.editTextClasePersonaje)
        val etVida = findViewById<EditText>(R.id.editTextVidaPersonaje)
        val etMana = findViewById<EditText>(R.id.editTextManaPersonaje)
        val etAtaque = findViewById<EditText>(R.id.editTextAtaquePersonaje)
        val etDefensa = findViewById<EditText>(R.id.editTextDefensaPersonaje)
        val etVelocidad = findViewById<EditText>(R.id.editTextVelocidadPersonaje)
        val btnAceptar = findViewById<Button>(R.id.buttonAceptarCrearPersonaje)
        val btnCancelar = findViewById<Button>(R.id.buttonCancelarCrearPersonaje)

        val character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        btnAceptar.setOnClickListener {
            crearPersonaje(etNombre,etClase,etVida,etMana,etAtaque,etDefensa,etVelocidad)
        }

        btnCancelar.setOnClickListener {
            if (character != null){
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("personaje", character)
                intent.putExtra("lobo",lobo1)
                intent.putExtra("araña",araña1)
                intent.putExtra("esqueleto",esqueleto1)
                intent.putExtra("administrador", user)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("lobo",lobo1)
                intent.putExtra("araña",araña1)
                intent.putExtra("esqueleto",esqueleto1)
                intent.putExtra("administrador", user)
                startActivity(intent)
            }


        }
    }

    fun crearPersonaje(etNombre: EditText,etClase: EditText,etVida: EditText,etMana: EditText,etAtaque: EditText,etDefensa: EditText,etVelocidad: EditText){
        val nombrePersonajeIngresa = etNombre.text.toString()
        val clasePersonajeIngresa = etClase.text.toString()
        val vidaPersonajeIngresa = Integer.parseInt(etVida.text.toString())
        val manaPersonajeIngresa = Integer.parseInt(etMana.text.toString())
        val ataquePersonajeIngresa = Integer.parseInt(etAtaque.text.toString())
        val defensaPersonajeIngresa = Integer.parseInt(etDefensa.text.toString())
        val velocidadPersonajeIngresa = Integer.parseInt(etVelocidad.text.toString())

        val personaje1 = Personaje(1,nombrePersonajeIngresa,clasePersonajeIngresa,vidaPersonajeIngresa,manaPersonajeIngresa,ataquePersonajeIngresa,defensaPersonajeIngresa,velocidadPersonajeIngresa)


        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        Toast.makeText(this, "${personaje1.nombre} se creó existosamente", Toast.LENGTH_SHORT).show()

        Thread.sleep(2000)

        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("personaje", personaje1)
        intent.putExtra("lobo",lobo1)
        intent.putExtra("araña",araña1)
        intent.putExtra("esqueleto",esqueleto1)
        intent.putExtra("administrador", user)
        startActivity(intent)
    }
}