package com.dicoding.jetpackprosub2.detail

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.dicoding.jetpackprosub2.R
import com.dicoding.jetpackprosub2.data.source.local.entity.DetailEntity
import com.dicoding.jetpackprosub2.databinding.ActivityDetailBinding
import com.dicoding.jetpackprosub2.utils.NetworkInfo.IMAGE_URL
import com.dicoding.jetpackprosub2.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EX_FILM = "ex_film"
        const val EX_CATEGORY = "ex_category"
    }

    private lateinit var detBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detBinding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Movie Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        showProgressBar(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EX_FILM)
            val dataCategory = extras.getString(EX_CATEGORY)

            if (dataId != null && dataCategory != null) {
                viewModel.setFilm(dataId, dataCategory)
                viewModel.getDataDetail().observe(this, { detail ->
                    populateDataDetail(detail)
                })
            }
        }

    }

    private fun showProgressBar(state: Boolean) {
        detBinding.progressBar.isVisible = state
        detBinding.cardviewContainer.isInvisible = state
    }

    private fun populateDataDetail(data: DetailEntity) {
        val genre = data.genres.toString().replace("[", "").replace("]", "")

        val genreDurationText = resources.getString(R.string.genre_duration_text, genre, data.runtime.toString())

        detBinding.tvDetailGenreDuration.text = genreDurationText
        detBinding.textTitle.text = data.title
        detBinding.detailName.text = data.overview

        Glide.with(this)
                .asBitmap()
                .load(IMAGE_URL + data.posterPath)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        detBinding.circleimageMovies.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {

                    }
                })

        detBinding.circleimageMovies.tag = data.posterPath

        showProgressBar(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}