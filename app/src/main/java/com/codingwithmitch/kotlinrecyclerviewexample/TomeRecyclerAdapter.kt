package com.codingwithmitch.kotlinrecyclerviewexample


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.kotlinrecyclerviewexample.models.OnePiece
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*


class TomeRecyclerAdapter(private var clickListener: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<OnePiece> = ArrayList()

    private var itemsCopy = items.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(items[position], clickListener)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<OnePiece>){
        items = blogList
    }

    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val tome_image = itemView.blog_image
        val tome_title = itemView.blog_title
        val tome_numero = itemView.blog_author

        fun bind(onePiece: OnePiece, action:OnTomeItemClickListener){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

           /*val assetManager: AssetManager = context
            val `is`: InputStream = assetManager.open("assets/"+ onePiece.image)
            val bitmap = BitmapFactory.decodeStream(`is`)
            tome_image.setImageBitmap(bitmap)*/

            tome_title.text = onePiece.volume
            tome_numero.text = "Tome " + onePiece.id

            itemView.setOnClickListener{
                action.onItemClick(onePiece,adapterPosition)
            }

        }

    }

    interface OnTomeItemClickListener{
        fun onItemClick(item: OnePiece, position: Int)
    }

}
