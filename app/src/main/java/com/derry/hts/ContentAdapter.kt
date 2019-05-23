package com.derry.hts

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_list_item.view.*


class ContentAdapter(private val contentArray: Array<String>, private val context: Context) :
    RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.textViewMeta?.text = "Sandra B -- $position hour ago"
        holder.textViewTitle?.text = contentArray[position]
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.qrcode)
        val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources, bitmap)
        circularBitmapDrawable.isCircular = true
        holder.imageViewProfile?.setImageDrawable(circularBitmapDrawable)
    }

    override fun getItemCount(): Int {
       return contentArray.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(LayoutInflater.from(context).inflate(R.layout.content_list_item, parent, false))
    }


    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewMeta: TextView? = itemView.contentMeta
        val textViewTitle: TextView? = itemView.contentTitle
        val imageViewProfile: ImageView? = itemView.contentProfile
    }
}