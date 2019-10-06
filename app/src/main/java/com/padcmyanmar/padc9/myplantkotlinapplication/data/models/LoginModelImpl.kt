package com.padcmyanmar.padc9.myplantkotlinapplication.data.models

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO

object LoginModelImpl : BaseModel(), LoginModel {
    override fun checkLoggedIn(): UserVO? {
        val userFromDB = dataBase.userDao().getLoginUser()
        if(userFromDB.isNotEmpty())
            return userFromDB[0]
        return null
    }

    override fun login(
        email: String,
        password: String,
        onSuccess: (UserVO) -> Unit, onFailure: (String) -> Unit
    ) {
        dataAgent.login(email = email, password = password, onSuccess = {
            val userList = listOf(it)
            dataBase.userDao().setLoginUser(userList)
            onSuccess(it)
        }, onFailure = onFailure)
    }

    override fun logout(userVo: UserVO) {
        dataBase.userDao().logout(userVo)
    }
}