package com.bruhu.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    // constructor w/ 2 parameters
    private val mainActivity: MainActivity,
    private val noteList: List<Note>):
    RecyclerView.Adapter<NoteAdapter.ListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        // returns instance, complete and inflated w/ ready-to-use layout
        return ListItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        // internally used function, it supplies the current numbers of items in List
        if (noteList != null) {
            return noteList.size
        }
        // error
        return -1
    }

    override fun onBindViewHolder(
        holder: ListItemHolder, position: Int) {

        val note = noteList!![position]
        holder.mTitle.text = note.title
        // Show the first 15 characters of the actual note
        holder.mDescription.text =
            note.description!!.substring(0, 15)

        // What is the status of the note?
        when {
            note.idea -> holder.status.text =
                mainActivity.resources.getString(R.string.idea_text)

            note.important -> holder.status.text =
                mainActivity.resources.getString(R.string.important_text)


            note.todo -> holder.status.text =
                mainActivity.resources.getString(R.string.todo_text)
        }


    }

    inner class ListItemHolder(view: View):
        RecyclerView.ViewHolder(view),
        View.OnClickListener {
            /* reference to each TextView widgets in the layout */
            internal var mTitle = view.findViewById<View>(R.id.textViewTitle) as TextView
            internal var mDescription = view.findViewById<View>(R.id.textViewDescription) as TextView
            internal var status = view.findViewById<View>(R.id.textViewStatus) as TextView
            // init sets whole view as clickable so onClick is triggered
            init {
                view.isClickable = true
                view.setOnClickListener(this)
            }
        }
        // the call will show the clicked note
        override fun onClick(view: View){
            mainActivity.showNote(adapterPosition)
        }
        // end of ListItemHolder
    }

// end of NoteAdapter
}