package com.example.trabajowithroom.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajowithroom.databinding.RowTicketBinding
import com.example.trabajowithroom.model.Ticket

class TicketAdapter( context : Context): RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    private val tickets = mutableListOf<Ticket>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = RowTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun getItemCount() = tickets.size


    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        tickets[position].let { ticket ->
            holder.title.text = ticket.titulo
            holder.contenido.text = ticket.contenido

            holder.ticketHolder = ticket

        }
    }


    fun submitList(it: List<Ticket>) {
        tickets.clear()
        tickets.addAll(it)

        notifyDataSetChanged()
    }

    class TicketViewHolder(binding: RowTicketBinding, var ticketHolder: Ticket? = null) :
        RecyclerView.ViewHolder(binding.root) {

        val title = binding.tvTitulo
        val contenido = binding.tvDescripcionTicket


    }
}