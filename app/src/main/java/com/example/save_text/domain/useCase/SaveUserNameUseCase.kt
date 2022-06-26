package com.example.save_text.domain.useCase

import com.example.save_text.domain.models.SaveUserNameParam


class SaveUserNameUseCase {
    fun execute(param:SaveUserNameParam):Boolean {
        return !param.name.isEmpty()
    }
}