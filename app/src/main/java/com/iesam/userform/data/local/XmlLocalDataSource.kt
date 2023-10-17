package com.iesam.userform.data.local

import android.content.Context
import com.iesam.app.serialization.JsonSerialization
import com.iesam.userform.domain.SaveUserUseCase
import com.iesam.userform.domain.User

class XmlLocalDataSource(
    private val context: Context,
    private val serialization: JsonSerialization
) {

    private val sharedPref = context.getSharedPreferences("users", Context.MODE_PRIVATE)

    fun save(input: SaveUserUseCase.Input) {
        sharedPref.edit().apply {
            val user = userBuild(input)
            putString(user.id.toString(), serialization.toJson(user, User::class.java))
            apply()
        }
    }

    fun findAll(): List<User> {
        val usersMap = sharedPref.all as Map<String, String>
        return usersMap.values.map { jsonUser ->
            serialization.fromJson(jsonUser, User::class.java)
        }
    }

    fun deleteById(userId: Long) {
        sharedPref.edit().remove(userId.toString()).commit()
    }

    private fun userBuild(input: SaveUserUseCase.Input): User =
        User(System.currentTimeMillis(), input.name, input.surname)
}