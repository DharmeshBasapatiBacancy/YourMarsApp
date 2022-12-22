package com.kudos.yourmarsapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kudos.yourmarsapp.databinding.RowItemAmphibiansBinding
import com.kudos.yourmarsapp.databinding.RowItemMarsBinding
import com.kudos.yourmarsapp.network.models.AmphibiansApiResponseItem
import com.kudos.yourmarsapp.network.models.MarsApiResponseItem

class AmphibiansAdapter(private val onItemClick: (AmphibiansApiResponseItem) -> Unit) :
    ListAdapter<AmphibiansApiResponseItem, AmphibiansAdapter.ViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<AmphibiansApiResponseItem>() {
            override fun areItemsTheSame(
                oldItem: AmphibiansApiResponseItem,
                newItem: AmphibiansApiResponseItem
            ) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: AmphibiansApiResponseItem,
                newItem: AmphibiansApiResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val rowItemAmphibiansBinding: RowItemAmphibiansBinding) :
        RecyclerView.ViewHolder(rowItemAmphibiansBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowItemAmphibiansBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            rowItemAmphibiansBinding.apply {

                val item = getItem(position)

                amphibians = item

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