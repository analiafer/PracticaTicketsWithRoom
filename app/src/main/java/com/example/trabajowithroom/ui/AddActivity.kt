package com.example.trabajowithroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.trabajowithroom.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var bindingAdd : ActivityAddBinding
    private val vm: TicketViewModel by viewModels{ TicketViewModelFactory(applicationContext) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAdd = ActivityAddBinding.inflate(layoutInflater)
        setContentView(bindingAdd.root)

        addDataToDatabase()

    }


    private fun addDataToDatabase(){

        val titulo = bindingAdd.tvTitulo.text.toString()
        val contenido = bindingAdd.tvDescripcion.text.toString()
        val butonSave = bindingAdd.buttonAceptar


        butonSave.setOnClickListener {

            if(titulo.isNotEmpty() && contenido.isNotEmpty()){
            vm.saveTicket(titulo, contenido)
            finish()
            }else{
                Toast.makeText(this, "El titulo o el contenido no pueden estar vacios", Toast.LENGTH_SHORT).show()
            }

        }

    }

}