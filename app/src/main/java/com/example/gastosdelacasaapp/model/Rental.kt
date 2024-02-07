package com.example.gastosdelacasaapp.model

import androidx.room.Entity

@Entity(
    tableName = "rental",
    primaryKeys = ["customerId", "facturaId"])
data class Rental(
    val customerId: Int,
    val facturaId: Int
)
