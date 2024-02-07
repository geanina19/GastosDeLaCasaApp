package com.example.gastosdelacasaapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("surname")val surname: String,
    @ColumnInfo("email") val email: String
)
