package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Pelanggan (
    var username : String ="",
    var password : String ="",
    var nohp : String ="",
    var email : String =""
        ) : Parcelable