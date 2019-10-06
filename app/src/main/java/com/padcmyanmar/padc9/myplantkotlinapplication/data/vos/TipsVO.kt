package com.padcmyanmar.padc9.myplantkotlinapplication.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName



data class TipsVO(

    @SerializedName("temperature")
    @ColumnInfo(name = "temperature")
    val temperature: String,

    @SerializedName("light")
    @ColumnInfo(name = "light")
    val light: String,

    @SerializedName("placement")
    @ColumnInfo(name = "placement")
    val placement: String
)