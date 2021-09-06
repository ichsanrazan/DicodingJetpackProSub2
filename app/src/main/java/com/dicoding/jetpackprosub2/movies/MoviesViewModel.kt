package com.dicoding.jetpackprosub2.movies

import androidx.lifecycle.ViewModel
import com.dicoding.jetpackprosub2.data.source.DataRepository

class MoviesViewModel(private val movieCatalogueRepository: DataRepository): ViewModel() {
    fun getMovies() = movieCatalogueRepository.getMovies()
}