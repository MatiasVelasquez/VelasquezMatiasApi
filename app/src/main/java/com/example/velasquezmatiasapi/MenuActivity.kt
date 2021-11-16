package com.example.velasquezmatiasapi

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.velasquezmatias.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

lateinit var service :servicioApi

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var etUsuario = findViewById<TextView>(R.id.textViewMenuUsuario)
        val btnCrearPersonaje = findViewById<Button>(R.id.ButtonCrearPersonaje)
        val btnVerPersonaje = findViewById<Button>(R.id.buttonVerPersonaje)
        val btnBestiario = findViewById<Button>(R.id.buttonBestiario)
        val btnSalir = findViewById<Button>(R.id.buttonSalir)

        val retrofit : Retrofit =  Retrofit.Builder()//Se crea instancia de retrofit
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<servicioApi>(servicioApi::class.java)//implementacion
        getAllPost()

        var user: usuario? = intent.getParcelableExtra<usuario>("administrador")

        if (user != null) {
            etUsuario.text = user.nombreUsuario
        }

        var character: Personaje? = intent.getParcelableExtra<Personaje>("personaje")

        val lobo1: Lobo? = intent.getParcelableExtra<Lobo>("lobo")
        val araña1: Araña? = intent.getParcelableExtra<Araña>("araña")
        val esqueleto1: Esqueleto? = intent.getParcelableExtra<Esqueleto>("esqueleto")

        btnCrearPersonaje.setOnClickListener {
            val intent = Intent(this, CrearPersonajeActivity::class.java)
            intent.putExtra("personaje",character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)

        }

        btnVerPersonaje.setOnClickListener {

            if (character?.nombre != null) {
                val intent = Intent(this, VerPersonajeActivity::class.java)
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
                    setMessage("No existe un personaje creado")
                    setPositiveButton("OK",null)
                }.show()
        }

        btnBestiario.setOnClickListener {
            val intent = Intent(this, BestiarioActivity::class.java)
            intent.putExtra("personaje", character)
            intent.putExtra("lobo",lobo1)
            intent.putExtra("araña",araña1)
            intent.putExtra("esqueleto",esqueleto1)
            intent.putExtra("administrador", user)
            startActivity(intent)

        }

        btnSalir.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Salir")
                setMessage("¿Estas seguro que desea salir?")
                setPositiveButton("Si"){_: DialogInterface, _: Int ->
                    finishAffinity()
                    //finish()
                }
                setNegativeButton("No",null)
            }.show()
        }
    }
    fun getAllPost(){

        var tvApi = findViewById<TextView>(R.id.textViewApi)

        service.getAllPost().enqueue(object : Callback<List<Post>> {//Recupero la lista
        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {//En caso de obtener datos
            var postList:List<Post>? = response.body()

            tvApi.text = postList?.get(1)?.title.toString()
        }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {//En caso de fallar
                t.printStackTrace()
            }

        })
    }
}