package com.example.gastosdelacasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gastosdelacasaapp.R
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.gastosdelacasaapp.database.AppDatabase
import com.example.gastosdelacasaapp.databinding.ActivityVerFacturasBinding
import com.example.gastosdelacasaapp.model.Factura
import com.example.gastosdelacasaapp.model.Customer
import com.example.gastosdelacasaapp.model.Rental
import java.util.Date

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
            db.bookDao().list(), this, db
        )

    }

    //--------------

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.factura_context_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.volverPrincipioItem -> {
                val intent = Intent(
                    this, VerCrearActivity::class.java
                )
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        val adapter = binding.facturasRecyclerView.adapter as FacturaAdapter

        adapter.facturas = db.bookDao().list()

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