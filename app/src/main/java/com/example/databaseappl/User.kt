package com.example.databaseappl

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "usersTable", indices = [Index(value = ["userId", "Name", "Email"], unique = true)])
class User {

    @PrimaryKey
    var userId: Int? = null

    @ColumnInfo(name = "Name")
    var userName: String? = null

    @ColumnInfo(name = "Email")
    var userEmail: String? = null


}