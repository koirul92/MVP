package com.example.mvp

interface Presenter {
    fun tambahHasil(number1: String, number2: String)
    fun clearHasil()
    fun loadHasil()
}