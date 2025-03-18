package com.cyberpro.kotlin.KotlinRestProject.repository

import com.cyberpro.kotlin.KotlinRestProject.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User, Long> {
}