package com.example.gastosdelacasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gastosdelacasaapp.databinding.ActivityCalcularGastosCasaBinding
import com.example.gastosdelacasaapp.model.Factura

class CalcularGastosCasaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalcularGastosCasaBinding

    enum class Params{
        FORMULARIO;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcularGastosCasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtén el formulario desde el intent
        val factura = intent.getParcelableExtra<Factura>(Params.FORMULARIO.name)

        binding.carcularBoton.setOnClickListener { v ->
            val numElecticidad = binding.electricidadNumero.text.toString().toDoubleOrNull() ?: 0.0
            val numGas = binding.gasNumero.text.toString().toDoubleOrNull() ?: 0.0
            val numAgua = binding.aguaNumero.text.toString().toDoubleOrNull() ?: 0.0

            // Sumar los tres valores directamente
            val total = numElecticidad + numGas + numAgua

            binding.totalNumero.text = total.toString()
        }
    }
}