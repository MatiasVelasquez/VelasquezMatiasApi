package com.example.velasquezmatias

import android.os.Parcel
import android.os.Parcelable

class Araña(override var vida: Int = 0,
            override var mana: Int = 0,
            override var ataque: Int = 0,
            override var defensa: Int = 0,
            override var velocidad: Int = 0,
            var gradoVeneno: Int = 0) : Creep, Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    fun envenenar(personaje: Personaje) {
        var probVeneno: Int = (0..10).random()
        var dañoTotal: Int = gradoVeneno + 1

        print("${personaje.nombre} recibió un picotazo venenozo!\n")
        personaje.vida = personaje.vida - 1


        if(probVeneno > 3){
            print("Envenenado!\n")
        }

        while(probVeneno > 3){
            personaje.vida = personaje.vida - dañoTotal
            print("El veneno hace efecto! -${dañoTotal} vida\n")
            probVeneno = (0..10).random()
        }
        print("Vida restante: ${personaje.vida}\n")
        if(checkearVida(personaje)){
            print("Has sido derrotado")
        }

    }


    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }

    @Override fun hablar(){
        print("Crii \n")
    }

    @Override fun avanzar(){
        var distanciaRecorrida : Int = 0;

        distanciaRecorrida = distanciaRecorrida + (this.velocidad*6)
        print("Distancia recorrida: ${distanciaRecorrida}\n")
    }


    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque ${this.ataque}, " +
                "defensa: ${this.defensa}, " +
                "velocidad: ${this.velocidad}, tipoVeneno:  ${this.gradoVeneno}.\n"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(vida)
        parcel.writeInt(mana)
        parcel.writeInt(ataque)
        parcel.writeInt(defensa)
        parcel.writeInt(velocidad)
        parcel.writeInt(gradoVeneno)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Araña> {
        override fun createFromParcel(parcel: Parcel): Araña {
            return Araña(parcel)
        }

        override fun newArray(size: Int): Array<Araña?> {
            return arrayOfNulls(size)
        }
    }

}