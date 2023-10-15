package com.example.myapplicationxml.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationxml.databinding.ItemRecyledataLayoutBinding
import com.example.myapplicationxml.model.UserDetail

class CustomAdapter(productList: List<UserDetail>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var dataList: List<UserDetail> = productList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyledataLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataList[position])

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(private val binding: ItemRecyledataLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: UserDetail) {
            binding.apply {
                country.also {
                    nameTextview.text = it.title
                    Glide.with(binding.root.context)
                        .load("https://images.dog.ceo/breeds/mexicanhairless/n02113978_147.jpg")
                        .into(binding.imvCorner)
                }
            }
        }
    }
}