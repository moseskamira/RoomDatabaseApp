package com.example.databaseappl

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertUser(user: User)

    @Query("SELECT * FROM usersTable")
    fun fetUsers(): List<User>
}