package com.example.velasquezmatiasapi

import android.os.Parcel
import android.os.Parcelable

data class usuario (var nombreUsuario : String="",var clave : String ="") : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreUsuario)
        parcel.writeString(clave)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<usuario> {
        override fun createFromParcel(parcel: Parcel): usuario {
            return usuario(parcel)
        }

        override fun newArray(size: Int): Array<usuario?> {
            return arrayOfNulls(size)
        }
    }

    fun cambiarNombre(){
        this.nombreUsuario = "NombreCambiado"
    }

}
