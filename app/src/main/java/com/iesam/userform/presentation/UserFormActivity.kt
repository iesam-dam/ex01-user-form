package com.iesam.userform.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.iesam.app.serialization.GsonSerialization
import com.iesam.userform.data.UserDataRepository
import com.iesam.userform.data.local.XmlLocalDataSource
import com.iesam.userform.databinding.ActivityMainBinding
import com.iesam.userform.domain.DeleteUserUseCase
import com.iesam.userform.domain.GetUsersUseCase
import com.iesam.userform.domain.SaveUserUseCase
import com.iesam.userform.domain.User

class UserFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: UserFormViewModel by lazy {
        UserFormViewModel(
            SaveUserUseCase(
                UserDataRepository(
                    XmlLocalDataSource(
                        this, GsonSerialization()
                    )
                )
            ), GetUsersUseCase(UserDataRepository(XmlLocalDataSource(this, GsonSerialization()))),
            DeleteUserUseCase(UserDataRepository(XmlLocalDataSource(this, GsonSerialization())))
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObserver()

    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupView() {
        binding.apply {
            actionSave.setOnClickListener {
                viewModel.save(getUserFromInput(), getSurnameFromInput())
            }
            actionReset.setOnClickListener {
                inputName.text = null
                inputSurname.text = null
            }
            actionShow.setOnClickListener {
                viewModel.loadUsers()
            }
        }
    }

    private fun getUserFromInput(): String = binding.inputName.text.toString()

    private fun getSurnameFromInput(): String = binding.inputSurname.text.toString()

    private fun setupObserver() {
        val observer = Observer<UserFormViewModel.UiModel> { uiModel ->
            if (uiModel.users != null) {
                bindData(uiModel.users)
            }
        }
        viewModel.uiModel.observe(this, observer)
    }

    private fun bindData(users: List<User>) {
        resetInputs()
        if (users.size > 0) {
            binding.layoutRow1.labelNameUser.text = users[0].name
            binding.layoutRow1.labelSurnameUser.text = users[0].surname
            binding.layoutRow1.actionDelete.setOnClickListener {
                viewModel.delete(users[0].id)
            }
        }
        if (users.size > 1) {
            binding.layoutRow2.labelNameUser.text = users[1].name
            binding.layoutRow2.labelSurnameUser.text = users[1].surname
            binding.layoutRow2.actionDelete.setOnClickListener {
                viewModel.delete(users[1].id)
            }
        }
        if (users.size > 2) {
            binding.layoutRow3.labelNameUser.text = users[2].name
            binding.layoutRow3.labelSurnameUser.text = users[2].surname
            binding.layoutRow3.actionDelete.setOnClickListener {
                viewModel.delete(users[2].id)
            }
        }
        if (users.size > 3) {
            binding.layoutRow4.labelNameUser.text = users[3].name
            binding.layoutRow4.labelSurnameUser.text = users[3].surname
            binding.layoutRow4.actionDelete.setOnClickListener {
                viewModel.delete(users[3].id)
            }
        }
        if (users.size > 4) {
            binding.layoutRow5.labelNameUser.text = users[4].name
            binding.layoutRow5.labelSurnameUser.text = users[4].surname
            binding.layoutRow5.actionDelete.setOnClickListener {
                viewModel.delete(users[4].id)
            }
        }
    }

    private fun resetInputs() {
        binding.apply {
            layoutRow1.labelNameUser.text = ""
            layoutRow1.labelSurnameUser.text = ""

            layoutRow2.labelNameUser.text = ""
            layoutRow2.labelSurnameUser.text = ""

            layoutRow3.labelNameUser.text = ""
            layoutRow3.labelSurnameUser.text = ""

            layoutRow4.labelNameUser.text = ""
            layoutRow4.labelSurnameUser.text = ""

            layoutRow5.labelNameUser.text = ""
            layoutRow5.labelSurnameUser.text = ""
        }
    }
}