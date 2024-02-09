package com.example.gastosdelacasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.gastosdelacasaapp.database.AppDatabase
import com.example.gastosdelacasaapp.databinding.ActivityCalcularGastosCasaBinding
import com.example.gastosdelacasaapp.model.Factura

class CalcularGastosCasaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalcularGastosCasaBinding

    private lateinit var db: AppDatabase

    enum class Params{
        FORMULARIO;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcularGastosCasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.carcularBoton.setOnClickListener { v ->
            val numElecticidad = binding.electricidadNumero.text.toString().toDoubleOrNull() ?: 0.0
            val numGas = binding.gasNumero.text.toString().toDoubleOrNull() ?: 0.0
            val numAgua = binding.aguaNumero.text.toString().toDoubleOrNull() ?: 0.0

            // Sumar los tres valores directamente
            val total = numElecticidad + numGas + numAgua

            binding.totalNumero.text = total.toString()
        }

        binding.anadirButton.setOnClickListener {
            val numElecticidad = binding.electricidadNumero.text.toString().toDoubleOrNull() ?: 0.0
            val numGas = binding.gasNumero.text.toString().toDoubleOrNull() ?: 0.0
            val numAgua = binding.aguaNumero.text.toString().toDoubleOrNull() ?: 0.0

            // Sumar los tres valores directamente
            val total = numElecticidad + numGas + numAgua

            val factura = Factura(
                facturaId = 0,
                electricity = numElecticidad,
                gas = numGas,
                water = numAgua
            )

            db
                .facturaDao()
                .save(factura)

            //finish()

            val intent = Intent (
                this,
                VerFacturasActivity::class.java)
            startActivity(intent)
        }
    }
}