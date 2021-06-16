package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sopir (
    var namaSopir : String = "",
    var nohp : String = "",
    var foto : String = ""
        ) : Parcelable