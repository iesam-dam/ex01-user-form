package com.iesam.app

sealed class ErrorApp {
    object UnknownError : ErrorApp()
}