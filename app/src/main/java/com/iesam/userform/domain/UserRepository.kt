package com.iesam.userform.domain

interface UserRepository {

    fun save(input: SaveUserUseCase.Input)
    fun getAll(): List<User>
    fun deleteById(userId: Long)
}