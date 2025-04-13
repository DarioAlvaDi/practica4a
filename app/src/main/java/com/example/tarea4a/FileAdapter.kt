package com.example.tarea4a
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileAdapter(private val files: List<FileModel>) : RecyclerView.Adapter<FileAdapter.FileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.file_item_view, parent, false)
        return FileViewHolder(view)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        val file = files[position]
        holder.bind(file)
    }

    override fun getItemCount(): Int {
        return files.size
    }

    class FileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referencia al TextView con el ID fileNameTextView
        private val fileNameTextView: TextView = itemView.findViewById(R.id.fileNameTextView)

        fun bind(file: FileModel) {
            // Asignación del nombre del archivo al TextView
            fileNameTextView.text = file.name

            itemView.setOnClickListener {
                // Manejar click para abrir archivo o navegar a directorio
            }
        }
    }
}