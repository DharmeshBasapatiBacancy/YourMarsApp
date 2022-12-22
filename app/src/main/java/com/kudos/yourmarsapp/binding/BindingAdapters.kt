package com.kudos.yourmarsapp.binding

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kudos.yourmarsapp.R
import com.kudos.yourmarsapp.databinding.RowItemAmphibiansBinding
import com.kudos.yourmarsapp.network.models.AmphibiansApiResponseItem
import com.kudos.yourmarsapp.network.models.MarsApiResponseItem
import com.kudos.yourmarsapp.utils.Status
import com.kudos.yourmarsapp.views.adapters.AmphibiansAdapter
import com.kudos.yourmarsapp.views.adapters.MarsPhotosAdapter

@BindingAdapter("listData")
fun bindMarsRecyclerView(recyclerView: RecyclerView, data: List<MarsApiResponseItem>?) {
    val adapter = recyclerView.adapter as MarsPhotosAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData")
fun bindAmphibiansRecyclerView(recyclerView: RecyclerView, data: List<AmphibiansApiResponseItem>?) {
    val adapter = recyclerView.adapter as AmphibiansAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: Status) {
    when (status) {
        Status.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        Status.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        Status.SUCCESS -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("amphibiansApiStatus")
fun bindAmphibiansStatus(statusImageView: ImageView, status: Status) {
    when (status) {
        Status.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        Status.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        Status.SUCCESS -> {
            statusImageView.visibility = View.GONE
        }
    }
}