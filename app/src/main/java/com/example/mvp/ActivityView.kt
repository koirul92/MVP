package com.example.mvp

interface ActivityView {
    fun showMessage(message: String)
    fun showData(data: String)
    fun clearField()
}