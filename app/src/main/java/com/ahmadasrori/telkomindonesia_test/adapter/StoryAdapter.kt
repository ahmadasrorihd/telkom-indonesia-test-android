package com.ahmadasrori.telkomindonesia_test.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.telkomindonesia_test.databinding.ItemStoryBinding

class StoryAdapter (
    private val items: List<String>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<StoryAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVH(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.tvNama.text = "Story #$item"
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