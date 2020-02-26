package com.lin.kotlinbase.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lin.kotlinbase.R
import com.lin.kotlinbase.api.entity.TimeEntity
import kotlinx.android.synthetic.main.viewholder_text.view.*

class MainViewHolderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    View.OnClickListener {

    private var data: List<TimeEntity>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType == 0) {
            true -> {
                val textViewHolder = TextMainViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.viewholder_text,
                        parent,
                        false
                    )
                )
                textViewHolder.itemView.textViewHolder.setOnClickListener(this)
                textViewHolder
            }
            false -> ImageMainViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.viewholder_image,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return data?.size?.times(2) ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextMainViewHolder -> {
                holder.itemView.textViewHolder.tag = position / 2
                holder.itemView.textViewHolder.text =
                    data?.get(position / 2)?.startTime?.append("\n")?.
                        append(data?.get(position / 2)?.endTime)?.append("\n")?.
                        append(data?.get(position / 2)?.parameter?.parameterName)?.
                            append(data?.get(position / 2)?.parameter?.parameterUnit)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    fun setDataSource(data: List<TimeEntity>?) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val intent = Intent(v.context, SecondActivity::class.java).putExtra(
            SecondActivity.DATA,
            data?.get(v.tag as? Int ?: return)
        )
        v.context.startActivity(intent)
    }
}

fun String.append(msg: String?): String {
    return this + msg
}