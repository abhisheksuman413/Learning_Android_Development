package com.fps69.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ContactDAO {


    @Insert
    suspend fun insertFunction(contact:Contact)

    @Update
    suspend fun updateFunction(contact:Contact)

    @Delete
    suspend fun deleteFunction(contact:Contact)


    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<Contact>>  // Yha suspend use ka ka jarurt nhi h because LiveData background thread
}