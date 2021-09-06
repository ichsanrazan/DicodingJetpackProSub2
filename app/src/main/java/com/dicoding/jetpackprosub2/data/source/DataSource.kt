package com.dicoding.jetpackprosub2.data.source

import androidx.lifecycle.LiveData
import com.dicoding.jetpackprosub2.data.source.local.entity.DetailEntity
import com.dicoding.jetpackprosub2.data.source.local.entity.MoviesEntity
import com.dicoding.jetpackprosub2.data.source.local.entity.TvEntity

interface DataSource {
    fun getMovies(): LiveData<List<MoviesEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<TvEntity>>
    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}