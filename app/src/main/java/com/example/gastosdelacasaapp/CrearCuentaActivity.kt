package com.example.gastosdelacasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gastosdelacasaapp.databinding.ActivityCrearCuentaBinding

class CrearCuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearCuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCrearCuenta.setOnClickListener {
            val mensajes = mutableListOf<String>()

            if (binding.nombreUsuarioCrearCuentaEditText.text.isEmpty())
            {
                mensajes.add("nombre de usuario")
            }

            val email = binding.emailEditText.text.toString()
                if (email.isEmpty())
                {
                    mensajes.add("correo electrónico")
                }
                else if (!email.contains("@"))
                {
                    mensajes.add("correo electrónico debe contener '@'")
                }

            if (binding.contrasenaEditText.text.isEmpty())
            {
                mensajes.add("contraseña")
            }

            if (mensajes.isNotEmpty())
            {
                val mensajeCompleto = mensajes.joinToString(", ")
                Toast.makeText(
                    this,
                    "Faltan los siguientes campos: $mensajeCompleto",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Creada cuenta con éxito",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent (
                    this,
                    VerFacturasActivity::class.java
                )
                startActivity(intent)
            }
        }


    }
}