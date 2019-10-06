package com.padcmyanmar.padc9.myplantkotlinapplication.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

@Dao
abstract class PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlants(movies: List<PlantVO>): LongArray

    @Query("select * from plant")
    abstract fun getPlants(): List<PlantVO>

    @Query("SELECT * FROM plant WHERE plant_id= :id")
    abstract fun getPlantsById(id: String): PlantVO
}
