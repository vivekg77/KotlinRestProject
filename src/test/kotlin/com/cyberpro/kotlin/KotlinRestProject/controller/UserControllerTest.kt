package com.cyberpro.kotlin.KotlinRestProject.controller

import com.cyberpro.kotlin.KotlinRestProject.model.User
import com.cyberpro.kotlin.KotlinRestProject.repository.UserRepository
import com.cyberpro.kotlin.KotlinRestProject.service.UserService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(UserController::class)
class UserControllerTest(@Autowired val mockMvc: MockMvc){

//    @Autowired
//    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var userService : UserService

    @Test
    fun `should return list of users`(){

        //Arrange
        val users = listOf(User(1, "Vivek", "vivek@abc.com"))
        whenever(userService.getAllUsers()).thenReturn(users)


        //Act and //Assert
        mockMvc.get("/api/users")
            .andExpect{
                status{isOk()}
                jsonPath("$[0].name").value("Vivek")
            }


    }

    @Test
    fun `should return a User when passed an Id`(){

        //Arrange
        val user = User(1, "Vivek", "vivek@abc.com")
        whenever(userService.getUserById(1)).thenReturn(user)


        //Act and //Assert
        mockMvc.get("/api/users/1")
            .andExpect{
                status{isOk()}
                jsonPath("$.name").value("Vivek")
            }




    }

}