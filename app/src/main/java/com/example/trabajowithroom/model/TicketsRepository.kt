package com.example.trabajowithroom.model

import com.example.trabajowithroom.data.TicketEntity

interface TicketsRepository {

    fun save (ticket: TicketEntity)
    fun getAll() : List<Ticket>
}