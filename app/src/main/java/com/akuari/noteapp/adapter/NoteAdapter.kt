package com.akuari.noteapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.akuari.noteapp.model.NoteModel
import com.akuari.noteapp.R
import com.akuari.noteapp.databinding.ItemNoteBinding


class NoteAdapter(private val items: List<NoteModel>, private val onItemClick: (noteData: NoteModel) -> Unit) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        
        return NoteViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_note, parent, false))
    }

    
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        
        holder.bind(items[position])
        
        holder.itemView.setOnClickListener {
            
            onItemClick(items[position])
        }
    }

    
    override fun getItemCount(): Int {
        
        return items.size
    }

    
    class NoteViewHolder(var itemNoteBinding: ItemNoteBinding) : RecyclerView.ViewHolder(itemNoteBinding.root) {
        
        fun bind(noteData: NoteModel?) {
            
            itemNoteBinding.noteData = noteData
            
            itemNoteBinding.executePendingBindings()
        }
    }
}
