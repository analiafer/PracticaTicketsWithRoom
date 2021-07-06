package com.example.trabajowithroom.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TicketDao {

    @Insert
    fun save (ticket : TicketEntity)

    @Query("SELECT * FROM ticket")
    fun getAll() : List<TicketEntity>
}