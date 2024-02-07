package com.example.gastosdelacasaapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gastosdelacasaapp.model.Factura
import com.example.gastosdelacasaapp.database.dao.FacturaDao
import com.example.gastosdelacasaapp.database.dao.CustomerDao
import com.example.gastosdelacasaapp.database.dao.RentalDao
import com.example.gastosdelacasaapp.model.Customer
import com.example.gastosdelacasaapp.model.Rental

@Database(entities = [Factura::class, Customer::class, Rental::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "contabilidad"
    }
    abstract fun bookDao(): FacturaDao
    abstract fun customerDao(): CustomerDao
    abstract fun rentalDao(): RentalDao
}