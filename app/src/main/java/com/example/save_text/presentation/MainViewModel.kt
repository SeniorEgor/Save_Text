package com.example.save_text.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.useCase.GetUserNameUseCase
import com.example.domain.useCase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {


    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        _resultLive.value = "save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }

}