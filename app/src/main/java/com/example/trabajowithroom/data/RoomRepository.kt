package com.example.trabajowithroom.data

import com.example.trabajowithroom.model.Ticket
import com.example.trabajowithroom.model.TicketsRepository

class RoomRepository(private val dao : TicketDao) : TicketsRepository {

    override fun save(ticket: TicketEntity) {
        val entity = TicketEntity(
            titulo = ticket.titulo,
            descripcion = ticket.descripcion
        )
        dao.save(entity)
    }

    override fun getAll(): List<Ticket> {
        return dao.getAll().map {
            Ticket(id= it.id, titulo = it.titulo,contenido = it.descripcion)
        }
    }
}