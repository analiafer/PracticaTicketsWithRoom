package com.example.trabajowithroom.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajowithroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var ticketAdapter: TicketAdapter
    private val viewModel: TicketViewModel by viewModels { TicketViewModelFactory(applicationContext) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
        recyclerView()
        observer()


    }


    private fun recyclerView() {


        ticketAdapter = TicketAdapter(this)
        with(binding.recyclerView) {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = this@MainActivity.ticketAdapter
        }
    }

    private fun setOnClickListener() {
        binding.addTicket.setOnClickListener { buttonAddTicket() }
    }

    private fun buttonAddTicket() {

        val add = Intent(this, AddActivity::class.java)
        startActivity(add)

    }


    private fun observer() {
        viewModel.ticketLiveData.observe(this, {
            ticketAdapter.submitList(it)
            ticketAdapter.notifyDataSetChanged()
        }
        )
    }

}