package com.padcmyanmar.padc9.myplantkotlinapplication.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="plant")
data class PlantVO (

    @PrimaryKey
    @SerializedName("plant_id")
    @ColumnInfo(name = "plant_id")
    val plantid: String,

    @SerializedName("plant_name")
    @ColumnInfo(name = "plant_name")
    val plant_name: String,


    @SerializedName("plant_type")
    val plantType: List<String>,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String,


    @SerializedName("top_tip")
    @ColumnInfo(name = "top_tip")
    val topTip: String,

    @SerializedName("tips")
    @Embedded(prefix = "tips_")
    val tips: TipsVO,

    @SerializedName("uploaded_user")
    @Embedded(prefix = "tips_")
    val uploadedUserVo: UploadedUserVO,

    @SerializedName("plant_photo")
    @ColumnInfo(name = "plant_photo")
    val plantPhoto: String






)



