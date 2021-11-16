package com.example.velasquezmatias

import android.os.Parcel
import android.os.Parcelable

data class Lobo(
    override var vida: Int = 0,
    override var mana: Int = 0,
    override var ataque: Int = 0,
    override var defensa: Int = 0,
    override var velocidad: Int = 0,
    var colorPelaje : String = "") : Creep, Parcelable {


    constructor(parcel: Parcel) :
            this(parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString().toString()) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(vida)
        parcel.writeInt(mana)
        parcel.writeInt(ataque)
        parcel.writeInt(defensa)
        parcel.writeInt(velocidad)
        parcel.writeString(colorPelaje)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lobo> {
        override fun createFromParcel(parcel: Parcel): Lobo {
            return Lobo(parcel)
        }

        override fun newArray(size: Int): Array<Lobo?> {
            return arrayOfNulls(size)
        }
    }


    fun morder(personaje : Personaje) {
        var dañoMordida = 10
        var probDoble: Int = (0..10).random()

        personaje.vida = personaje.vida - dañoMordida
        print("Se realizó un ataque de mordida de ${dañoMordida}. Vida de ${personaje.nombre}: ${personaje.vida}\n")

        if (probDoble > 8){
            print("El lobo mordió nuevamente!\n")
            personaje.vida = personaje.vida - dañoMordida
            print("Se realizó un ataque de mordida de ${dañoMordida}. Vida de ${personaje.nombre}: ${personaje.vida}\n")
        }
        if(checkearVida(personaje)){
            print("Has sido derrotado!")
        }
    }

    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }

    @Override fun hablar(){
        print("Wof Wof \n")
    }

    @Override fun avanzar(){
        var distanciaRecorrida : Int = 0;

        distanciaRecorrida = distanciaRecorrida + (this.velocidad*4)
        print("Distancia recorrida: ${distanciaRecorrida}\n")
    }

    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque ${this.ataque}, " +
                "defensa: ${this.defensa}, colorPelaje: ${this.colorPelaje}, " +
                "velocidad: ${this.velocidad}\n"
    }



}