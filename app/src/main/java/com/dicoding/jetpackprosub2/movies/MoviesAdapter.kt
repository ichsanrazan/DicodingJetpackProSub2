package com.dicoding.jetpackprosub2.movies

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.dicoding.jetpackprosub2.data.source.local.entity.MoviesEntity
import com.dicoding.jetpackprosub2.databinding.ItemsMoviesBinding
import com.dicoding.jetpackprosub2.utils.NetworkInfo.IMAGE_URL

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private var movies = ArrayList<MoviesEntity>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovies(movies: List<MoviesEntity>){
        if (movies.isNullOrEmpty()) return
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itmMovBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itmMovBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.voteAverage.toString()

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(IMAGE_URL + movie.posterPath)
                    .transform(RoundedCorners(28))
                    .into(object : CustomTarget<Bitmap>() {
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            imgPoster.setImageBitmap(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })

                itemView.setOnClickListener {onItemClickCallback.onItemClicked(movie.id.toString())}
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}