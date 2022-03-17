package com.example.mynavigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

/*
for enable to use @Parcelize you must add in build.gradle:App :
apply plugin: 'org.jetbrains.kotlin.android.extensions'
android {
    androidExtensions {
        experimental = true
    }
}
 */
@Parcelize
data class Money(val amount: BigDecimal): Parcelable