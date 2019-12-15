package com.example.android.navigation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AdatbDAO {
    @Insert
    fun insert(adat: Adatb)

    @Update
    fun update(adat: Adatb)

    @Query("SELECT * from amoba_names_table WHERE match_Id = :key")
    fun get(key: Long): Adatb?

    @Query("DELETE FROM amoba_names_table")
    fun clear()

    @Query("SELECT * FROM amoba_names_table ORDER BY match_Id DESC LIMIT 1")
    fun getLast(): Adatb?

    @Query("SELECT * FROM amoba_names_table ORDER BY match_Id DESC")
    fun getAllMatch(): LiveData<List<Adatb>>
}