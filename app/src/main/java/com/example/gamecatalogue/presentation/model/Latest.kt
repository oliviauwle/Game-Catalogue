package com.example.gamecatalogue.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Latest(
    val overview: String,
    val title: String,
    val backgroundimage: String,
    val id: Int
    val name : String
    val developer : String
) : Parcelable