package com.iesam.userform.domain

class GetUsersUseCase(private val repository: UserRepository) {

    operator fun invoke(): List<User> {
        return repository.getAll()
    }

}