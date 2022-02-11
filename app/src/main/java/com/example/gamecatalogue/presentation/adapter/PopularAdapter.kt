package com.example.gamecatalogue.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamecatalogue.R
import com.example.gamecatalogue.databinding.ItemPopularBinding
import com.example.gamecatalogue.presentation.model.Popular
import com.example.gamecatalogue.utils.Const

class PopularAdapter(
    private val items: MutableList<Popular> = mutableListOf(),
    private val onItemClickedCallback: OnItemClickedCallback? = null
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
        private lateinit var binding: ItemPopularBinding

        inner class PopularViewHolder(private val binding: ItemPopularBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Popular) {
                this.binding.apply {
                    Glide.with(root.context).load("${Const.baseImageUrl}${data.backgroundimage}").error(
                        R.drawable.ic_baseline_cancel_24).into(imgBackground)
                    tvName.text = data.name
                    root.setOnClickListener {
                        onItemClickedCallback?.onItemClicked(data)
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
            binding = ItemPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PopularViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount(): Int = items.size

        fun setItems(items: List<Popular>) {
            this.items.apply {
                clear()
                addAll(items)
                notifyDataSetChanged()
            }
        }

        interface OnItemClickedCallback {
            fun onItemClicked(data: Popular)
        }
}