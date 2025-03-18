package com.cyberpro.kotlin.KotlinRestProject.service

import com.cyberpro.kotlin.KotlinRestProject.model.User
import com.cyberpro.kotlin.KotlinRestProject.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class UserServiceTest{


    private val userRepository: UserRepository = mock()
    private val userService = UserService(userRepository)

    @Test
    fun shouldReturnAllUsers(){
//    fun `should return all users`(){
        //Arrange
        val users = listOf(User(1, "Vivek", "vivek@abc.com"))

        whenever(userRepository.findAll()).thenReturn(users)

        //Act
        var result = userService.getAllUsers()

        //Assert
        assertEquals(1, result.size)
        assertEquals("Vivek", result[0].name)

    }

    @Test
    fun shouldReturnUserById(){

        //Arrange
        val user = User(1, "Vivek", "vivek@abc.com")
        whenever(userRepository.findById(1)).thenReturn(Optional.of(user))

        //Act
        var result = userService.getUserById(1)

        //Assert
        assertNotNull(result)
        assertEquals("Vivek", result?.name)

    }

    @Test
    fun shouldSaveAUser(){

        //Arrange
        val user = User(0, "Vivek", "vivek@abc.com")
        val savedUser = User(1, "Vivek", "vivek@abc.com")
        whenever(userRepository.save(user)).thenReturn(savedUser)

        //Act
        var result = userService.createUser(user)

        //Assert
        assertNotNull(result)
        assertEquals("Vivek", result.name)

    }


}