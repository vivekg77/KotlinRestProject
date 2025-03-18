package com.cyberpro.kotlin.KotlinRestProject.service

import com.cyberpro.kotlin.KotlinRestProject.model.User
import com.cyberpro.kotlin.KotlinRestProject.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {

        return userRepository.findAll()
    }

    fun getUserById(id: Long): User? {

        return userRepository.findById(id).orElse(null)
    }

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(id: Long, updatedUser: User): User? {

        if (!userRepository.existsById(id)) return null
        val user = updatedUser.copy(id = id)
        return userRepository.save(user)
    }


}





