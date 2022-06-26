package com.example.save_text.domain.useCase

import com.example.save_text.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Yahor", lastName = "Pauliutsin")
    }
}