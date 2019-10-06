package com.padcmyanmar.padc9.myplantkotlinapplication.data.models

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO

interface LoginModel {
    fun login(
        email: String,
        password: String,
        onSuccess: (UserVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun logout(userVo: UserVO)

    fun checkLoggedIn():UserVO?
}