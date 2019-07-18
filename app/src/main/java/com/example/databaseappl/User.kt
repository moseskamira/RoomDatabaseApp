package com.example.databaseappl

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "usersTable")
class User {

    @PrimaryKey
    var userId: Int? = null

    @ColumnInfo(name = "Name")
    var userName: String? = null

    @ColumnInfo(name = "Email")
    var userEmail: String? = null

// constructor(userId: Int, userName: String, userEmail: String) {
//     this.userId = userId
//     this.userName = userName
//     this.userEmail = userEmail
// }


}