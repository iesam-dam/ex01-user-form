package com.iesam.userform.domain

class SaveUserUseCase(private val repository: UserRepository) {

    operator fun invoke(input: Input) {
        repository.save(input)
    }

    data class Input(val name: String, val surname: String)

}