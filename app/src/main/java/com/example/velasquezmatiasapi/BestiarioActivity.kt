package com.example.velasquezmatiasapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.velasquezmatias.Araña
import com.example.velasquezmatias.Esqueleto
import com.example.velasquezmatias.Lobo
import com.example.velasquezmatias.Personaje

class BestiarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bestiario)

        val btnGenerarBicho = findViewById<Button>(R.id.buttonGenerarBichoAleatorio)
        val btnVerLobo = findViewById<Button>(R.id.buttonVerLobo)
        val btnVerAraña = findViewById<Button>(R.id.buttonVerAraña)
        val btnVerEsqueleto = findViewById<Button>(R.id.buttonVerEsqueleto)
        val btnVolver = findViewById<Button>(R.id.buttonVolverBestiario)

        var character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        btnGenerarBicho.setOnClickListener {
            generarBicho()
        }

        btnVerLobo.setOnClickListener {
            var lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
            if (lobo1?.ataque != null) {

                val intent = Intent(this, VerLoboActivity::class.java)
                intent.putExtra("personaje",character)
                intent.putExtra("lobo",lobo1)
                intent.putExtra("araña",araña1)
                intent.putExtra("esqueleto",esqueleto1)
                intent.putExtra("administrador", user)
                startActivity(intent)
            }
            else
                AlertDialog.Builder(this).apply {
                    setTitle("Error")
                    setMessage("No existe un lobo creado")
                    setPositiveButton("OK",null)
                }.show()
        }

        btnVerAraña.setOnClickListener {
            var araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
            if (araña1?.ataque != null) {
                val intent = Intent(this, VerAranaActivity::class.java)
                intent.putExtra("personaje",character)
                intent.putExtra("lobo",lobo1)
                intent.putExtra("araña",araña1)
                intent.putExtra("esqueleto",esqueleto1)
                intent.putExtra("administrador", user)
                startActivity(intent)
            }
            else
                AlertDialog.Builder(this).apply {
                    setTitle("Error")
                    setMessage("No existe una araña creado")
                    setPositiveButton("OK",null)
                }.show()
        }

        btnVerEsqueleto.setOnClickListener {
            var esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
            if (esqueleto1?.ataque != null) {
                val intent = Intent(this, VerEsqueletoActivity::class.java)
                intent.putExtra("personaje",character)
                intent.putExtra("lobo",lobo1)
                intent.putExtra("araña",araña1)
                intent.putExtra("esqueleto",esqueleto1)
                intent.putExtra("administrador", user)
                startActivity(intent)
            }
            else
                AlertDialog.Builder(this).apply {
                    setTitle("Error")
                    setMessage("No existe un esqueleto creado")
                    setPositiveButton("OK",null)
                }.show()
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
    fun generarBicho() {

        var probGenerar: Int = (1..10).random()
        var probVidaAraña: Int = (1..100).random()
        var probManaAraña: Int = (50..100).random()
        var probAtaqueAraña: Int = (1..20).random()
        var probDefensaAraña: Int = (1..10).random()
        var probVelocidadAraña: Int = (1..10).random()
        var probgradoVenenoAraña: Int = (1..10).random()

        var probVidaLobo: Int = (1..100).random()
        var probManaLobo: Int = (50..100).random()
        var probAtaqueLobo: Int = (1..30).random()
        var probDefensaLobo: Int = (1..5).random()
        var probVelocidadLobo: Int = (1..15).random()

        var probVidaEsqueleto: Int = (1..150).random()
        var probManaEsqueleto: Int = (1..50).random()
        var probAtaqueEsqueleto: Int = (1..15).random()
        var probDefensaEsqueleto: Int = (1..25).random()
        var probVelocidadEsqueleto: Int = (1..5).random()
        var probgradoDurezaEsqueleto: Int = (1..5).random()

        var character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")
        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")
        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        if (probGenerar >= 1 && probGenerar <= 3) {
            val araña1 = Araña(
                probVidaAraña,
                probManaAraña,
                probAtaqueAraña,
                probDefensaAraña,
                probVelocidadAraña,
                probgradoVenenoAraña
            )
            Toast.makeText(this, "Araña se creó existosamente", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, VerAranaActivity::class.java)
            intent.putExtra("personaje",character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)
        }
        else if (probGenerar >= 4 && probGenerar <= 7) {
            val lobo1 = Lobo(
                probVidaLobo,
                probManaLobo,
                probAtaqueLobo,
                probDefensaLobo,
                probVelocidadLobo,
                "Azul"
            )
            Toast.makeText(this, "Lobo se creó existosamente", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, VerLoboActivity::class.java)
            intent.putExtra("personaje",character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)
        } else {
            val esqueleto1 = Esqueleto(
                probVidaEsqueleto,
                probManaEsqueleto,
                probAtaqueEsqueleto,
                probDefensaEsqueleto,
                probVelocidadEsqueleto,
                probgradoDurezaEsqueleto
            )
            Toast.makeText(this, "Esqueleto se creó existosamente", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, VerEsqueletoActivity::class.java)
            intent.putExtra("personaje",character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)
        }
    }
}