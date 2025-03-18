package com.cyberpro.kotlin.KotlinRestProject.controller

import com.cyberpro.kotlin.KotlinRestProject.model.User
import com.cyberpro.kotlin.KotlinRestProject.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {




    @GetMapping
    fun getAllUsers() : List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long) : ResponseEntity<User>{

        val user = userService.getUserById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun createUser(@RequestBody user: User) : User = userService.createUser(user)




}