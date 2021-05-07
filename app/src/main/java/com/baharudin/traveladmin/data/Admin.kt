package com.baharudin.traveladmin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Admin (
        val username : String ="",
        val password : String =""
        ) : Parcelable