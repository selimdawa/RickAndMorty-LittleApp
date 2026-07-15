package com.littleapp.rickandmorty.utils

import com.littleapp.rickandmorty.ui.main.MainActivity

object DATA {
    const val UNKNOWN = "Unknown"
    const val RICK_AND_MORTY = "Rick & Morty"
    const val ALIVE = "Alive"
    const val BASE_URL_RICK_AND_MORTY = "https://rickandmortyapi.com/api/"

    object CLASS {
        val MAIN: Class<*> = MainActivity::class.java
    }
}