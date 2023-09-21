package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>()
 {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val senderTv = itemView.findViewById<TextView>(R.id.senderTv)
        val titleTv = itemView.findViewById<TextView>(R.id.titleTv)
        val summaryTv = itemView.findViewById<TextView>(R.id.summaryTv)

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val context = parent.context
         val inflater = LayoutInflater.from(context)
         // Inflate the custom layout
         val contactView = inflater.inflate(R.layout.email_item, parent, false)
         // Return a new holder instance
         return ViewHolder(contactView)
     }

     // Populate data into the item through the holder
     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         // Get the data model based on position
         val email = emails.get(position)
         // Set item views based on views and data model
         holder.senderTv.text = email.sender
         holder.titleTv.text = email.title
         holder.summaryTv.text = email.summary
     }

     override fun getItemCount(): Int {
         return emails.size
     }


 }