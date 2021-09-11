package com.example.lowescodingchallenge.utility

sealed class Resource<out R> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val errorMsg : String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}