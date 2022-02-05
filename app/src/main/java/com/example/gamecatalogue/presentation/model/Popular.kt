package com.example.gamecatalogue.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Popular(
    val overview: String,
    val backgroundimage: String,
    val id: Int
    val name : String
    val developer : String
) : Parcelable