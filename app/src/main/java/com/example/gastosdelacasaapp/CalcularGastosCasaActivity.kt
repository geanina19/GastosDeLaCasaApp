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

    private var idFacturaEditar: Int? = null

    enum class Params {
        ID_FACTURA;
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

        idFacturaEditar = intent.extras?.getInt(Params.ID_FACTURA.name)

        idFacturaEditar?.let { idFacturaEditar ->
            binding.anadirButton.text = "Modificar"
            db.facturaDao().findById(idFacturaEditar)?.let { factura ->
                binding.electricidadNumero.setText(factura.electricity.toString())
                binding.gasNumero.setText(factura.gas.toString())
                binding.aguaNumero.setText(factura.water.toString())

            }
        }

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


            if (idFacturaEditar == null) {
                val factura = Factura(
                    facturaId = 0,
                    electricity = numElecticidad,
                    gas = numGas,
                    water = numAgua
                )

                db
                    .facturaDao()
                    .save(factura)
            } else {
                val factura = Factura(
                    facturaId = idFacturaEditar!!,
                    electricity = numElecticidad,
                    gas = numGas,
                    water = numAgua
                )

                db
                    .facturaDao()
                    .update(factura)
            }


            finish()
        }
    }
}