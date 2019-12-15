package com.example.android.navigation.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amoba_names_table")
data class Adatb (
        @PrimaryKey(autoGenerate = true)
        var match_Id: Long = 0L,

        @ColumnInfo(name = "start_time_milli")
        val startTimeMilli: Long = System.currentTimeMillis(),

        @ColumnInfo(name = "end_time_milli")
        var endTimeMilli: Long = startTimeMilli,

        @ColumnInfo(name = "who")
        var whoWon: Int = -1,

        @ColumnInfo(name = "score")
        var scoreFinal: Int = -1,

        @ColumnInfo(name = "nameOne")
        var nameOne: String = "",

        @ColumnInfo(name = "nameTwo")
        var nameTwo: String = ""
)