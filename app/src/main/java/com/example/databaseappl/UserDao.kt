package com.example.databaseappl

import android.arch.persistence.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertUser(user: User)

    @Query("SELECT * FROM usersTable")
    fun fetUsers(): List<User>

    @Delete
    fun deleteUser(user: User): Int
}