package com.iesam.userform.domain

class DeleteUserUseCase(private val repository: UserRepository) {

    operator fun invoke(userId: Long) {
        repository.deleteById(userId)
    }

}