package com.example.gastosdelacasaapp.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Factura(
    val facturaId: Int,
    val electricity : Double,
    val gas : Double,
    val water : Double
): Parcelable