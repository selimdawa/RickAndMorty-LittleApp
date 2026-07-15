package com.littleapp.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.littleapp.rickandmorty.data.models.CharacterModel
import com.littleapp.rickandmorty.data.models.EpisodeModel
import com.littleapp.rickandmorty.data.models.LocationModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<CharacterModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(characters: List<CharacterModel>)

    @Query("SELECT * FROM episodes")
    fun getAllEpisodes(): Flow<List<EpisodeModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisodes(episodes: List<EpisodeModel>)

    @Query("SELECT * FROM locations")
    fun getAllLocations(): Flow<List<LocationModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocations(locations: List<LocationModel>)
}