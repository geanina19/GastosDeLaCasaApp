package com.example.gastosdelacasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gastosdelacasaapp.databinding.ActivityCalcularGastosCasaBinding

class CalcularGastosCasaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalcularGastosCasaBinding

    enum class Params{
        FORMULARIO;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcularGastosCasaBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
        val formulario = intent.getParcelableExtra(Params.FORMULARIO.electricity, Formulario::class.java)

        formulario?.let {formulario -> binding.

        }

 */

        binding.carcularBoton.setOnClickListener {v->
            val numluz = binding.luzNumero

            val numgas = binding.GasNumero

            
        }
    }
}