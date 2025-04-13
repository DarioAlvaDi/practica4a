package com.example.tarea4a

import java.io.File

data class FileModel(val name: String, val path: String, val isDirectory: Boolean, val size: Long) {
    companion object {
        fun fromFile(file: File): FileModel {
            return FileModel(file.name, file.absolutePath, file.isDirectory, file.length())
        }
    }
}