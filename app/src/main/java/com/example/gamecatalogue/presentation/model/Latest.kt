package com.example.gamecatalogue.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Latest(
    val backgroundimage: String,
    val id: Int,
    val name: String,
    val description: String,
    val released: String
) : Parcelable