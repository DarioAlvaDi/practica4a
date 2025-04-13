package com.example.tarea4a

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import android.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecer tema según el modo del sistema
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        setContentView(R.layout.activity_main)

        // Verificar permisos de almacenamiento
        if (checkPermissions()) {
            // Cargar la interfaz principal
            loadFileSystem()
        } else {
            requestStoragePermission()
        }
    }

    private fun checkPermissions(): Boolean {
        // Comprobación de permisos para acceder al almacenamiento
        return true // Implementar comprobación real de permisos
    }

    private fun requestStoragePermission() {
        // Solicitar permisos de almacenamiento
        val permissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                loadFileSystem()
            } else {
                Toast.makeText(this, "Permiso de almacenamiento denegado", Toast.LENGTH_SHORT).show()
            }
        }
        permissionRequest.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    private fun loadFileSystem() {
        // Cargar el sistema de archivos y mostrar los directorios
        val externalStorage = File("/storage/emulated/0")
        val files = externalStorage.listFiles()
        files?.forEach { file ->
            println(file.name)
        }
    }
}