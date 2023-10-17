package com.iesam.userform.data

import com.iesam.userform.data.local.XmlLocalDataSource
import com.iesam.userform.domain.SaveUserUseCase
import com.iesam.userform.domain.User
import com.iesam.userform.domain.UserRepository

class UserDataRepository(private val xmlLocalDataSource: XmlLocalDataSource) : UserRepository {


    override fun save(input: SaveUserUseCase.Input) {
        xmlLocalDataSource.save(input)
    }

    override fun getAll(): List<User> {
        return xmlLocalDataSource.findAll()
    }

    override fun deleteById(userId: Long) {
        xmlLocalDataSource.deleteById(userId)
    }


}