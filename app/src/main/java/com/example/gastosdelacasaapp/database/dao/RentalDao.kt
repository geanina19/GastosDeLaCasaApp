package com.example.gastosdelacasaapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gastosdelacasaapp.model.Factura
import com.example.gastosdelacasaapp.model.Customer
import com.example.gastosdelacasaapp.model.CustomerWithRentals
import com.example.gastosdelacasaapp.model.Rental

@Dao
interface RentalDao {

    @Query("select * from rental")
    fun list(): List<Rental>

    @Insert
    fun save(rental: Rental)
}