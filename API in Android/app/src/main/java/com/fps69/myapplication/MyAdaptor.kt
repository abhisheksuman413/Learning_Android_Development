package com.fps69.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fps69.myapplication.databinding.EachItemBinding

class MyAdaptor(private val ItemListSEC: List<Recipe>,private val Listener : ItemCilckListener):
      RecyclerView.Adapter<MyAdaptor.ResturentItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResturentItemViewHolder {

        val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ResturentItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ResturentItemViewHolder, position: Int) {
        holder.bind(ItemListSEC[position])
    }

    override fun getItemCount(): Int {
        return ItemListSEC.size
    }



    inner class ResturentItemViewHolder(private val itembinding: EachItemBinding) : RecyclerView.ViewHolder(itembinding.root){

        fun bind(itemModel:Recipe){

            itembinding.apply {
                TVitemname.text=itemModel.name
                TVReatingText.text=itemModel.rating.toString()
                TVitemCusin.text=itemModel.cuisine
                TVitemPrepTime.text= "PrepTimeMinutes :-${itemModel.prepTimeMinutes.toString()}"


                //Using glide dependency kotlin for open image url
                Glide.with(itembinding.root).load(itemModel.image).into(itembinding.IVitempic)


            }

            itembinding.root.setOnClickListener {

                Listener.OnItemClick(adapterPosition) // adapterPosition current item ka position de dega

            }

        }

    }


    interface ItemCilckListener {

        fun OnItemClick(position: Int){

        }
        
    }
}