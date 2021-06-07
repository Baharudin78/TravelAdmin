package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Users (
    var username : String = "",
    var tujuanAwal : String = "",
    var tujaanAkhir : String = "",
    var tempatAwal : String = "",
    var tempatAkhir : String = "",
    var tanggal : String = "",
    var total : String = "",
        ) : Parcelable