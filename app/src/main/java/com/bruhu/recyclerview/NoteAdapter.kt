package com.bruhu.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    // constructor w/ 2 parameters
    private val mainActivity: MainActivity,
    private val noteList: List<Note>)
    : RecyclerView.Adapter<NoteAdapter.ListItemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return ListItemHolder(itemView)
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {

    }

    inner class ListItemHolder(view: View) {
        RecyclerView.ViewHolder(view),
        View.onClickListener{
            init
        }
        override fun onClick(view: View)
        // end of ListItemHolder
    }

// end of NoteAdapter
}