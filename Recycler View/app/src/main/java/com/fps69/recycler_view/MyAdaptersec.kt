package com.fps69.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fps69.recycler_view.databinding.EachItemSecBinding

class MyAdaptersec(private val ItemListSEC: List<UserDataClassSEC>): RecyclerView.Adapter<MyAdaptersec.ResturentItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResturentItemViewHolder {

        val binding = EachItemSecBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ResturentItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ResturentItemViewHolder, position: Int) {
        holder.bind(ItemListSEC[position])
    }

    override fun getItemCount(): Int {
        return ItemListSEC.size
    }



    inner class ResturentItemViewHolder(private val itembinding: EachItemSecBinding) : RecyclerView.ViewHolder(itembinding.root){

        fun bind(itemModel:UserDataClassSEC){

            itembinding.apply {
                TVitemname.text=itemModel.name
                TVReatingText.text=itemModel.rating
                TVitemCusin.text=itemModel.cusine
                TVitemPrepTime.text=itemModel.prepTime


                //Using glide dependency kotlin for open image url
                Glide.with(itembinding.root).load(itemModel.image).into(itembinding.IVitempic)


            }

        }

    }
}