package com.littleapp.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.littleapp.rickandmorty.data.models.*

@Database(entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}