package com.lin.kotlinbase.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lin.kotlinbase.R
import kotlinx.android.synthetic.main.viewholder_image.view.*

class ImageMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.imageViewHolder.setImageResource(R.mipmap.ic_launcher_round)
    }
}