@file:Suppress("unused")

package com.fachrizalmrsln.component.base.extensions

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun ImageView.loadImage(url: String?, placeholder: Int) {
    Glide.with(this).load(url)
        .apply(
            RequestOptions()
                .centerCrop()
                .placeholder(placeholder)
                .error(placeholder)
        )
        .into(this)
}

fun ImageView.loadImageFromAssets(assets: Int) {
    Glide.with(this).load(assets)
        .into(this)
}

fun Activity.makeStatusAndNavigationBarTransparent() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
}

fun Int.convertTimeStamp() : Long {
    return this * 1000L
}

fun String.getTotalPage(): Int {
    return this.removeRange(0, this.length - 2).toInt()
}

fun String.makeFirstIndexCapitalize(): String {
    val firstIndex = this.first().toUpperCase().toString()
    return this.replaceRange(0, 1, firstIndex)
}