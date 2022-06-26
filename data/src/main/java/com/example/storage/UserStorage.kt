package com.example.storage

import com.example.storage.models.User


interface UserStorage {

    fun save(user : User):Boolean

    fun get(): User
}