package com.yeyq.kursakademiaandroida.core.bindings

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yeyq.kursakademiaandroida.core.adapter.BindableAdapter
import com.yeyq.kursakademiaandroida.core.base.UiState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UiState) {
        progressBar.isVisible = uiState == UiState.Pending
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)

    }

    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .into(imageView)
    }

    @BindingAdapter(value = ["app:roundImageUrl", "app:roundPlaceholder"], requireAll = false)
    @JvmStatic
    fun setRoundImage(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }

}