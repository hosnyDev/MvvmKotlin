package com.hosnydevteast.mvvmkotlin.util

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast


fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}


fun Context.alert(msg: String) {
    AlertDialog.Builder(this)
        .setMessage(msg)
        .setPositiveButton("ok", null)
        .create()
        .show()
}

fun ProgressBar.showProgress() {
    visibility = View.VISIBLE
}

fun ProgressBar.goneProgress() {
    visibility = View.GONE
}
