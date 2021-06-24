package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Tiket (
    var username : String = "",
    var tujuanAwal : String = "",
    var tujuanAkhir : String = "",
    var tempatAwal : String = "",
    var tempatAkhir : String = "",
    var tanggal : String = "",
    var total : Long = 0L,
        ) : Parcelable