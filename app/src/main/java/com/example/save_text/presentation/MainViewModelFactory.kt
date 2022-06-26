package com.example.save_text.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.data.repository.UserRepositoryImpl
import com.example.domain.useCase.GetUserNameUseCase
import com.example.domain.useCase.SaveUserNameUseCase
import com.example.storage.sharedPrefs.SharedPrefUserStorage

class MainViewModelFactory(context:Context):ViewModelProvider.Factory{

        private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
        saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}