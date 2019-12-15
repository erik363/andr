package com.example.android.navigation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Adatb::class], version = 1, exportSchema = false)
abstract class NamesDataB : RoomDatabase() {
    abstract val adatbDAO: AdatbDAO
    companion object {
        @Volatile
        private var INSTANCE: NamesDataB? = null

        fun getInstance(context: Context): NamesDataB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = databaseBuilder(
                            context.applicationContext,
                            NamesDataB::class.java,
                            "amoba_names_table"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}