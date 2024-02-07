package com.example.gastosdelacasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.gastosdelacasaapp.databinding.ActivityVerCrearBinding

class VerCrearActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerCrearBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerCrearBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.verCrearToolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //carga esto en la actividad
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.verFacturasActivityItem -> {
                val intent = Intent(this, VerFacturasActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.calcularFacturaActivityItems -> {
                val intent = Intent(this, CalcularGastosCasaActivity::class.java)
                startActivity(intent)
                true
            }

            else ->
                return super.onOptionsItemSelected(item)
        }
    }


}