package com.example.tarea4a

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun checkPermission(context: Context, permission: String): Boolean {
    return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}

fun requestPermission(context: Context, permission: String) {
    ActivityCompat.requestPermissions(context as Activity, arrayOf(permission), 1)
}