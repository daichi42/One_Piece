package com.codingwithmitch.kotlinrecyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chapitres_item.view.*
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class ChapitresRecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private var items: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChapitresViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.chapitres_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is ChapitresViewHolder -> {
                holder.bind(items[position])
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<String>){
        items = blogList
    }

    class ChapitresViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val c = itemView.chapitre

        fun bind(chapitre: String){
            c.text = chapitre
        }

    }

}
