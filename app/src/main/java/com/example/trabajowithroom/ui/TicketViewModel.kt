package com.example.trabajowithroom.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trabajowithroom.data.TicketEntity
import com.example.trabajowithroom.model.Ticket
import com.example.trabajowithroom.model.TicketsRepository

class TicketViewModel (private val repository: TicketsRepository) : ViewModel(){

    val ticketLiveData = MutableLiveData<List<Ticket>>()



    fun getAll(){
        ticketLiveData.value = repository.getAll()
    }


    fun saveTicket(titulo: String, contenido : String){
        repository.save(TicketEntity(titulo = titulo, descripcion = contenido))
        ticketLiveData.value = repository.getAll()
    }




}