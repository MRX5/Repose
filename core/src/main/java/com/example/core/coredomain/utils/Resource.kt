package com.example.core.coredomain.utils

sealed class Resource<out R>{
    object Idle:Resource<Nothing>()
    object Loading:Resource<Nothing>()
    data class Success<out T>(val data:T):Resource<T>()
    data class Error(val error:String):Resource<String>()

}
