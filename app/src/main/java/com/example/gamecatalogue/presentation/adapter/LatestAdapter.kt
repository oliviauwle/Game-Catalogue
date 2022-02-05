package com.example.gamecatalogue.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamecatalogue.R
import com.example.gamecatalogue.databinding.ItemLatestBinding
import com.example.gamecatalogue.presentation.model.Latest
import com.example.gamecatalogue.utils.Const

class LatestAdapter {private val items: MutableList<Latest> = mutableListOf(),
    private val onItemClickedCallback: OnItemClickedCallback? = null
    ) : RecyclerView.Adapter<TvSeriesAdapter.TvSeriesViewHolder>() {
        private lateinit var binding: ItemLatestBinding

        inner class TvSeriesViewHolder(private val binding: ItemLatestBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Latest) {
                this.binding.apply {
                    Glide.with(root.context).load("${Const.baseImageUrl}${data.backgroundimage}").error(
                        R.drawable.ic_baseline_cancel_24).into(imgPoster)
                    latest.text = data.name
                    root.setOnClickListener {
                        onItemClickedCallback?.onItemClicked(data)
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
            binding = ItemLatestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TvSeriesViewHolder(binding)
        }

        override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount(): Int = items.size

        fun setItems(items: List<Latest>) {
            this.items.apply {
                clear()
                addAll(items)
                notifyDataSetChanged()
            }
        }

        interface OnItemClickedCallback {
            fun onItemClicked(data: Latest)
        }
}