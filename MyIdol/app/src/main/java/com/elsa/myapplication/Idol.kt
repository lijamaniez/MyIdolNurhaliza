package com.elsa.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class Idol (
    val imgIdol : Int,
    val nameIdol : String,
    val descIdol: String
): Parcelable {

}