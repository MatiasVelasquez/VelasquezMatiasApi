package com.example.velasquezmatias

import android.os.Parcel
import android.os.Parcelable

data class Jugador(var id : Int = 0,
                   var nickname: String = "",
                   var edad: Int = 0,
                   var mail: String = "") : Parcelable{


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    )

    private  fun alerta(){
        print("Usted es menor de edad, debe salir inmediatamente del juego.\n")
    }

    private fun alerta(nickname : String){
        print("El nickname ${nickname} no está disponible para usar.\n")
    }

    override fun toString(): String {
        return "ID: ${this.id} nickname: ${this.nickname}, edad ${this.edad} " +
                "mail:  ${this.mail}\n"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nickname)
        parcel.writeInt(edad)
        parcel.writeString(mail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jugador> {
        override fun createFromParcel(parcel: Parcel): Jugador {
            return Jugador(parcel)
        }

        override fun newArray(size: Int): Array<Jugador?> {
            return arrayOfNulls(size)
        }
    }

}