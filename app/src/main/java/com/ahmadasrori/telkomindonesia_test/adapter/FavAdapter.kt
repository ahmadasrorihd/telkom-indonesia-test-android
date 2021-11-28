package com.ahmadasrori.telkomindonesia_test.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.telkomindonesia_test.databinding.ItemStoryBinding
import com.ahmadasrori.telkomindonesia_test.model.Story

class FavAdapter (
    private val items: List<Story>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<FavAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVH(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.tvNama.text = "Story #${item.stori_id}"
        holder.binding.layoutItem.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemVH(mainBinding: ItemStoryBinding) :
        RecyclerView.ViewHolder(mainBinding.root) {
        val binding = mainBinding
    }

}