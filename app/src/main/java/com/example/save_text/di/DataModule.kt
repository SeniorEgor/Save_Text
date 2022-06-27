package com.example.save_text.di

import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import com.example.storage.UserStorage
import com.example.storage.sharedPrefs.SharedPrefUserStorage
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}