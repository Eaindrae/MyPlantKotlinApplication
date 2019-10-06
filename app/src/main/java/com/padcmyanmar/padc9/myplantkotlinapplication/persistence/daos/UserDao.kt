package com.padcmyanmar.padc9.myplantkotlinapplication.persistence.daos

import androidx.room.*
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun setLoginUser(events: List<UserVO>): LongArray

    @Query("SELECT * FROM user")
    abstract fun getLoginUser(): List<UserVO>

    @Query("SELECT * FROM user WHERE user_id=:id")
    abstract fun getUserById(id: String): UserVO

    @Delete
    abstract fun logout(userVo: UserVO)
}