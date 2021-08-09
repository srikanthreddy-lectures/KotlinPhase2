package com.example.kotlindemoapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun addUser()

    @Query("SELECT * FROM user_table")
    fun readAllUser()
}