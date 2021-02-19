package com.example.recyclerviewproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_custom_row.view.*

class ItemAdapter(val context: Context, val items: ArrayList<DataModel>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_custom_row,
                        parent,
                        false
                )
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = items.get(position)

        if (holder is ViewHolder) {
            holder.tvItem.text = item.itemName
            holder.description.text = item.itemDescription

            // Updating the background color according to the odd/even positions in list.
            if (position % 2 == 0) {
                holder.cardViewItem.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                R.color.khder
                        )
                )
            } else {
                holder.cardViewItem.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                R.color.khderakhor
                        )
                )
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem = view.tv_item_name
        val description = view.tv_item_description
        val cardViewItem = view.card_view_item
    }
}