package com.example.gastosdelacasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.gastosdelacasaapp.database.AppDatabase
import com.example.gastosdelacasaapp.databinding.ActivityVerFacturasBinding

class VerFacturasActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityVerFacturasBinding

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerFacturasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.recycleViewToolbar)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        // createInitialData()
        binding.facturasRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

        binding.facturasRecyclerView.adapter = FacturaAdapter(
            db.facturaDao().list(), this, db
        )

    }

    //--------------

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.factura_context_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.crearFacturaItem -> {
                val intent = Intent(
                    this, CalcularGastosCasaActivity::class.java
                )
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        val adapter = binding.facturasRecyclerView.adapter as FacturaAdapter

        adapter.facturas = db.facturaDao().list()

        adapter.notifyDataSetChanged()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.factura_context_menu, menu)
    }

}