package com.ewapps.receitasfavoritas.application

import android.app.Application
import com.ewapps.receitasfavoritas.model.database.FavDishRepository
import com.ewapps.receitasfavoritas.model.database.FavDishRoomDatabase

class FavDishApplication : Application() {

    private val database by lazy { FavDishRoomDatabase.getDatabase(this@FavDishApplication) }

    val repository by lazy { FavDishRepository(database.favDishDao()) }
}