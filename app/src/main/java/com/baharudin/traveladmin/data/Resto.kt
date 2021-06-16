package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Resto (
    var foto : String ="",
    var letak : String = "",
    var namaResto : String = "",
    var telepon : String =""
        ) :Parcelable