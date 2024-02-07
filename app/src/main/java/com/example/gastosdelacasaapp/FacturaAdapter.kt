package com.example.gastosdelacasaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.gastosdelacasaapp.database.AppDatabase
import com.example.gastosdelacasaapp.databinding.FacturaLayoutBinding
import com.example.gastosdelacasaapp.model.Factura

class FacturaAdapter(
    var facturas: List<Factura>,
    val context: Context,
    val db: AppDatabase
):

    Adapter<FacturaAdapter.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.factura_layout, null)
        )
    }

    override fun getItemCount(): Int {
        return facturas.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val factura = facturas[position]
        val binding = FacturaLayoutBinding.bind(holder.itemView)

        binding.idFacturaTextView.text = factura.facturaId.toString()

        binding.electricityTextView.text = factura.electricity.toString()

        binding.gasTextView.text = factura.gas.toString()

        binding.waterTextView.text = factura.water.toString()

        /*
        binding.eliminarImageView.setOnClickListener{
            val deletedRows = db.bookDao().delete(factura.facturaId)

            facturas = db.bookDao().list()

            notifyDataSetChanged()
            if(deletedRows == 0) {
                Toast.makeText(context, "No se ha eliminado ninguna factura", Toast.LENGTH_LONG).show()
            }
        }
        */
    }
}