package com.example.gastosdelacasaapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.example.gastosdelacasaapp.model.Factura

@Dao
interface FacturaDao {

    @Query("SELECT * FROM factura")
    fun list(): List<Factura>

    //---------------------eliminar---------------
    //electricidad
    @Query("DELETE FROM factura WHERE electricity=:electricity")
    fun delete(electricity: Double): Double


    //@Query("SELECT * FROM factura WHERE gas=:gas")
    //fun listAuthorBooks(gas: String): List<Factura>

    @Insert
    fun save(book: Factura)
}