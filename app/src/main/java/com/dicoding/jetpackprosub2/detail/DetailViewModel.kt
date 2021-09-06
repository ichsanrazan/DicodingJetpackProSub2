package com.dicoding.jetpackprosub2.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpackprosub2.data.source.DataRepository
import com.dicoding.jetpackprosub2.data.source.local.entity.DetailEntity

class DetailViewModel(private val dataRepository: DataRepository): ViewModel() {
    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }

    private lateinit var detailData: LiveData<DetailEntity>

    fun setFilm(id: String, category: String) {
        when (category) {
            TV_SHOW -> {
                detailData = dataRepository.getDetailTvShow(id)
            }

            MOVIE -> {
                detailData = dataRepository.getDetailMovie(id)
            }
        }
    }

    fun getDataDetail() = detailData

}