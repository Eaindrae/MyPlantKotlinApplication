package com.padcmyanmar.padc9.myplantkotlinapplication.persistence.daos

import androidx.room.*
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.FavPlantsVo
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

@Dao
abstract class FavPlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insetFavPlant(favPlantsVo: FavPlantsVo)

    @Query("SELECT plant.* FROM plant INNER JOIN fav_plants WHERE fav_plant_id == plant_id")
    abstract fun getFavPlantList(): List<PlantVO>

    @Query("SELECT * FROM fav_plants WHERE fav_plant_id=:plantId")
    abstract fun getFavPlantByPlantId(plantId:String): FavPlantsVo

    @Delete
    abstract fun removeFavPlant(favPlantsVo: FavPlantsVo)


}