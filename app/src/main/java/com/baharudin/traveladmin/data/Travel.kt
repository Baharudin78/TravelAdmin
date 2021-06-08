package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Travel (
    val travel : String = "",
    val foto : String = "",
    val harga : String = "",
    val fasilitas : String =""
        ) : Parcelable