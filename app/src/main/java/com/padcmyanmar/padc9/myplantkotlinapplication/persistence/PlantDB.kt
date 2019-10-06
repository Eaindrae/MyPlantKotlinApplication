package com.padcmyanmar.padc9.myplantkotlinapplication.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.PLANT_DB
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.FavPlantsVo
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO
import com.padcmyanmar.padc9.myplantkotlinapplication.persistence.daos.FavPlantDao
import com.padcmyanmar.padc9.myplantkotlinapplication.persistence.daos.PlantDao
import com.padcmyanmar.padc9.myplantkotlinapplication.persistence.daos.UserDao
import com.padcmyanmar.padc9.myplantkotlinapplication.persistence.typeconverters.PlantTypeConverter


@Database(entities = [PlantVO::class,UserVO::class,FavPlantsVo::class], version = 2, exportSchema = false)
@TypeConverters(PlantTypeConverter::class)
abstract class PlantDB: RoomDatabase() {

    abstract fun plantDao(): PlantDao
    abstract fun userDao(): UserDao
    abstract fun favPlantDao(): FavPlantDao

    companion object{
        private var INSTANCE: PlantDB? = null

        fun getInstance(context: Context): PlantDB{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, PlantDB::class.java, PLANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }

    fun areDatasExitInDB(): Boolean{
        return plantDao().getPlants().isNotEmpty()
    }
}