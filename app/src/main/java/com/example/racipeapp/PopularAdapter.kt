package com.example.racipeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.racipeapp.databinding.PopularRcItemBinding

class PopularAdapter (var dataList:ArrayList<Recipe>, var context: Context):RecyclerView.Adapter<PopularAdapter.ViewHolder>(){

    inner class ViewHolder(var binding: PopularRcItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var binding=PopularRcItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.popularImg
        Glide.with(context).load(dataList.get(position).img).into(holder.binding.popularImg)
        holder.binding.popularText.text=dataList.get(position).tittle
        var time=dataList.get(position).ing.split("\n").dropLastWhile { it.isEmpty()}.toTypedArray()

        holder.binding.popularTime.text = time[0]
        holder.binding.popularImg.setOnClickListener {
            var intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("img", dataList.get(position).img)
            intent.putExtra("title", dataList.get(position).tittle)
            intent.putExtra("des", dataList.get(position).des)
            intent.putExtra("ing", dataList.get(position).ing)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        }
        }


