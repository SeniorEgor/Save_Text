package com.example.data.repository



import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository
import com.example.storage.UserStorage
import com.example.storage.models.User

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam : SaveUserNameParam):Boolean{
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam:SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

}