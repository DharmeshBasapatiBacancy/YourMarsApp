package com.kudos.yourmarsapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kudos.yourmarsapp.databinding.RowItemMarsBinding
import com.kudos.yourmarsapp.network.models.MarsApiResponseItem

class MarsPhotosAdapter(private val onItemClick: (MarsApiResponseItem) -> Unit) :
    ListAdapter<MarsApiResponseItem, MarsPhotosAdapter.ViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<MarsApiResponseItem>() {
            override fun areItemsTheSame(
                oldItem: MarsApiResponseItem,
                newItem: MarsApiResponseItem
            ) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MarsApiResponseItem,
                newItem: MarsApiResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val rowItemMarsBinding: RowItemMarsBinding) :
        RecyclerView.ViewHolder(rowItemMarsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowItemMarsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            rowItemMarsBinding.apply {

                val item = getItem(position)

                photo = item

                // This is important, because it forces the data binding to execute immediately,
                // which allows the RecyclerView to make the correct view size measurements
                executePendingBindings()

                itemView.setOnClickListener {
                    onItemClick(item)
                }

            }
        }
    }

}