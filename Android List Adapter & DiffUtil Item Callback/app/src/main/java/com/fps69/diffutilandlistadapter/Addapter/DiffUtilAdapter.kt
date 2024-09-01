package com.fps69.diffutilandlistadapter.Addapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fps69.diffutilandlistadapter.DataClass.User
import com.fps69.diffutilandlistadapter.databinding.ItemForRecyclerviewBinding

class DiffUtilAdapter : RecyclerView.Adapter<DiffUtilAdapter.DiffUtilViewHolder>() {
    class DiffUtilViewHolder(val binding: ItemForRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    val diffUtil = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffUtilViewHolder {
        val binding =
            ItemForRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiffUtilViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: DiffUtilViewHolder, position: Int) {
        val empData = differ.currentList[position]
        holder.binding.apply {
            tvEmployeeItemName.text = empData.userName
        }
    }
}