package com.iesam.userform.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.app.ErrorApp
import com.iesam.userform.domain.DeleteUserUseCase
import com.iesam.userform.domain.GetUsersUseCase
import com.iesam.userform.domain.SaveUserUseCase
import com.iesam.userform.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserFormViewModel(
    private val saveUserUseCase: SaveUserUseCase,
    private val getUsersUseCase: GetUsersUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> = _uiModel


    fun save(name: String, surname: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserUseCase(SaveUserUseCase.Input(name, surname))
            loadUsers()
        }
    }

    fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val users = getUsersUseCase()
            _uiModel.postValue(UiModel(users = users))
        }
    }

    fun delete(userId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteUserUseCase(userId)
            loadUsers()
        }
    }

    data class UiModel(
        val isLoading: Boolean = false,
        val error: ErrorApp? = null,
        val users: List<User>? = null
    )
}