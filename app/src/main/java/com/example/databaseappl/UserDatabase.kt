package com.example.databaseappl

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        var databaseInstance: UserDatabase? = null

        fun getDatabaseInstance(context: Context): UserDatabase? {
            if (databaseInstance == null) {
                synchronized(UserDatabase::class) {
                    if(databaseInstance == null) {
                        databaseInstance = Room.databaseBuilder(context.applicationContext,
                            UserDatabase::class.java, "userDatabase")
                            .allowMainThreadQueries().build()
                    }
                }
            }
            return databaseInstance
        }
//        fun destroyDatabase() {
//            databaseInstance = null
//        }
    }
}