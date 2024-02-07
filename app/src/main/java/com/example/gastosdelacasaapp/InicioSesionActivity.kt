package com.example.gastosdelacasaapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gastosdelacasaapp.databinding.ActivityInicioSesionBinding

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioSesionBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonIniciarSesion.setOnClickListener {v ->
            if(binding.nombreUsuario.text.isEmpty())
            {
                Toast.makeText(
                    this,
                    "Debe intriducir su nombre",
                    Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                if (binding.contrasena.text.toString() == "Nohay2sin3") {
                    val intent = Intent (
                        this,
                        VerCrearActivity::class.java)
                        startActivity(intent)
                }
                else {
                    Toast.makeText(
                        this,
                        "Login Inválido",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}