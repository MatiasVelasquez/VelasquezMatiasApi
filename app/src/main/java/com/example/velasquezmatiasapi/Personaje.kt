package com.example.velasquezmatias

import android.os.Parcel
import android.os.Parcelable

data class Personaje (var id: Int = 0,var nombre: String = "",var clase: String = "",
                      var vida: Int = 0,var mana: Int = 0,var ataque: Int = 0,
                      var defensa: Int = 0,var velocidad: Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeString(clase)
        parcel.writeInt(vida)
        parcel.writeInt(mana)
        parcel.writeInt(ataque)
        parcel.writeInt(defensa)
        parcel.writeInt(velocidad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Personaje> {
        override fun createFromParcel(parcel: Parcel): Personaje {
            return Personaje(parcel)
        }

        override fun newArray(size: Int): Array<Personaje?> {
            return arrayOfNulls(size)
        }
    }
    //Calculo si el ataque es mayor a la defensa para sacar el daño total.
    // Si el daño es mayor a 0 le hace daño. Si el creep llega a 0 de vida, muere.
    // Sino le saca 20 vida por defecto
    fun atacar(creep : Creep){
        var dañoTotal : Int = 0

        dañoTotal = this.ataque - creep.defensa
        if(dañoTotal > 0){
            creep.vida = creep.vida - dañoTotal
            print("Se realizó un ataque de ${dañoTotal}. Vida del creep: ${creep.vida} \n")
            if(checkearVida(creep)){
                print("Has derrotado al creep!")
            }
        }
        else{
            creep.vida = creep.vida - 20
            print("La defensa del creep supera tu ataque! Realizas 20 de daño. Vida del creep: ${creep.vida}\n")
            if(checkearVida(creep)){
                print("Has derrotado al creep!")
            }
        }
    }

    fun subirDefensa(){
        var maxDefensa : Int = 100
        var defensaAumentada: Int = 5
        var costo : Int = 5
        var defensaTotal : Int = maxDefensa - defensaAumentada

        if(this.defensa < maxDefensa){
            if(validarCosto(costo)){
                print("Consumiste ${costo} de mana \n")
                this.mana = this.mana - costo
                if(this.defensa <= defensaTotal) {
                    this.defensa = this.defensa + defensaAumentada;
                    print("Tu personaje aumentó la defensa, defensa actual: ${this.defensa} \n")
                } else {
                    this.defensa = this.defensa + (maxDefensa - this.defensa)
                    print("Tu personaje aumentó la defensa, defensa actual: ${this.defensa} \n")
                }
            }
            else
                print("Necesitas ${costo} de mana para subir tu defensa. Mana actual: ${this.mana} \n")
        }
        else
            print("Ya posee el máximo de defensa\n")
    }

    fun curar(){

        var maxVida : Int = 100
        var vidaCurada : Int = 40
        var costo : Int = 10;
        var curaTotal: Int = maxVida - vidaCurada

        if(this.vida < maxVida){
            if(validarCosto(costo)){
                print("Consumiste ${costo} de mana \n")
                this.mana = this.mana - costo
                if (this.vida <= curaTotal) {
                    this.vida = this.vida + vidaCurada;
                    print("Tu personaje se curó, vida actual: ${this.vida} \n")
                } else {
                    this.vida = this.vida + (maxVida - this.vida)
                    print("Tu personaje se curó, vida actual: ${this.vida} \n")
                }
            }
            else
                print("Necesitas ${costo} de mana para curarte. Mana actual: ${this.mana} \n")
        }
        else
            print("Ya posee el máximo de vida \n")
    }

    private fun validarCosto(costo: Int): Boolean{
        return this.mana >= costo
    }

    private fun alertaVida(){
        print("La vida es superior a 100. Ingrese nuevamente\n")
    }

    private fun checkearVida(creep:Creep) : Boolean{
        return creep.vida <= 0
    }

    override fun toString(): String {
        return "ID: ${this.id}, nombre: ${this.nombre}, clase: ${this.clase}, " +
                "vida: ${this.vida}, mana: ${this.mana}, " +
                "ataque: ${this.ataque}, defensa: ${this.defensa}. \n"
    }
}