package com.sl.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sl.app.dao.UserDao
import com.sl.app.entity.User

@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
