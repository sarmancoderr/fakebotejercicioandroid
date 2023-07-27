package es.sarman.hackaprende.fakebot.models

import android.util.Log
import kotlin.random.Random

class ResponsesList : ArrayList<String> {
    constructor(): super() {
        add("Si")
        add("No")
        add("Pregunta de nuevo")
        add("Es muy probable")
        add("No lo creo")
        add("No se")
        add("Tal vez")
    }

    fun getRandomResponse(): String  {
        return random()
    }

}