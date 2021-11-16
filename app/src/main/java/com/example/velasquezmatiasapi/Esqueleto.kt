package com.example.velasquezmatias

import android.os.Parcel
import android.os.Parcelable

open class Esqueleto(override var vida: Int = 0,
                     override var mana: Int = 0,
                     override var ataque: Int = 0,
                     override var defensa: Int = 0,
                     override var velocidad: Int = 0,
                     var dureza : Int = 0) : Creep, Parcelable{


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    fun reconstruirse(){
        var costo : Int = 50

        if(validarCosto(costo)){
            this.vida = 100
            print("El esqueleto se reconstruyó y recuperó por completo su vida! (${this.vida})")
        }
    }

    private fun validarCosto(costo: Int): Boolean{
        return this.mana >= costo
    }

    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }

    @Override fun hablar(){
        print("Plank Plank \n")
    }

    @Override fun avanzar(){
        var distanciaRecorrida : Int = 0;

        distanciaRecorrida = distanciaRecorrida + (this.velocidad*2)
        print("Distancia recorrida: ${distanciaRecorrida}\n")
    }

    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque ${this.ataque}, " +
                "defensa: ${this.defensa}, dureza: ${this.dureza}, " +
                "velocidad: ${this.velocidad}.\n"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(vida)
        parcel.writeInt(mana)
        parcel.writeInt(ataque)
        parcel.writeInt(defensa)
        parcel.writeInt(velocidad)
        parcel.writeInt(dureza)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Esqueleto> {
        override fun createFromParcel(parcel: Parcel): Esqueleto {
            return Esqueleto(parcel)
        }

        override fun newArray(size: Int): Array<Esqueleto?> {
            return arrayOfNulls(size)
        }
    }


}