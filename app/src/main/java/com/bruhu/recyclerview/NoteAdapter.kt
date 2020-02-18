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
        // returns instance, complete and inflated w/ ready-to-use layout
        return ListItemHolder(itemView)
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        val note = noteList[position]
        holder.title.text = note.title

        // Show the first 15 characters of the actual note
        // IF THE USER ENTERES A NOTE UNDER 15 CHARS THE APP WILL CRASH
        holder.description.text = note.description!!.substring(0, 15)

        // What is the status of the note?
        when{
            note.idea -> holder.status.text = mainActivity.resources.getString(R.string.idea_text)
            note.important -> holder.status.text = mainActivity.resources.getString(R.string.important_text)
            note.todo -> holder.status.text = mainActivity.resources.getString(R.string.todo_text)
        }

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