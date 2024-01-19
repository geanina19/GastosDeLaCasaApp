package com.example.gastosdelacasaapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Formulario(
    val electricity : Double,
    val gas : Double,
    val water : Double
): Parcelable
