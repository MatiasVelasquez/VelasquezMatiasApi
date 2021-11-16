package com.example.velasquezmatias

interface Creep {

    var vida: Int
    var mana: Int
    var ataque: Int
    var defensa: Int
    var velocidad: Int

    fun atacar(personaje : Personaje){
        var dañoTotal : Int = 0

        dañoTotal = this.ataque - personaje.defensa
        if(dañoTotal > 0){
            personaje.vida = personaje.vida - dañoTotal
            print("Se realizó un ataque de ${dañoTotal}. Vida de ${personaje.nombre}: ${personaje.vida}\n" )
            if(checkearVida(personaje)){
                print("Has sido derrotado!")
            }
        } else {
            personaje.vida = personaje.vida - 10;
            print("Tu defensa supera el ataque del creep! Recibes 10 de daño. Vida de ${personaje.nombre}: ${personaje.vida}\n")
            if(checkearVida(personaje)){
                print("Has sido derrotado!")
            }
        }
    }

    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }


}