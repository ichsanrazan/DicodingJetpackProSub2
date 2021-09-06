package com.dicoding.jetpackprosub2.tv

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.dicoding.jetpackprosub2.data.source.local.entity.TvEntity
import com.dicoding.jetpackprosub2.databinding.ItemsMoviesBinding
import com.dicoding.jetpackprosub2.utils.NetworkInfo.IMAGE_URL

class TvAdapter: RecyclerView.Adapter<TvAdapter.TvShowViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private var tvS = ArrayList<TvEntity>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setTvShows(tvShows: List<TvEntity>) {
        if (tvShows.isNullOrEmpty()) return
        this.tvS.clear()
        this.tvS.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itmMovBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itmMovBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvS[position])
    }

    override fun getItemCount(): Int = tvS.size

    inner class TvShowViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.name
                tvItemGenre.text = tvShow.voteAverage.toString()

                Glide.with(binding.root.context)
                        .asBitmap()
                        .load(IMAGE_URL + tvShow.posterPath)
                        .transform(RoundedCorners(28))
                        .into(object : CustomTarget<Bitmap>() {
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                imgPoster.setImageBitmap(resource)
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                            }
                        })

                itemView.setOnClickListener {

                }

                itemView.setOnClickListener{onItemClickCallback.onItemClicked(tvShow.id.toString())}
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}