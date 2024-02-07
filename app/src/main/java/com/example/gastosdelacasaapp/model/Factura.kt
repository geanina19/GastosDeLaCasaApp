package com.example.gastosdelacasaapp.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Parcelize
@Entity
data class Factura(
    @PrimaryKey (autoGenerate = true) val facturaId: Int,
    @ColumnInfo ("electricity") val electricity : Double,
    @ColumnInfo ("gas") val gas : Double,
    @ColumnInfo ("water") val water : Double
): Parcelable