package com.dicoding.jetpackprosub2.tv

import androidx.lifecycle.ViewModel
import com.dicoding.jetpackprosub2.data.source.DataRepository

class TvViewModel(private val movieCatalogueRepository: DataRepository): ViewModel() {
    fun getTvShows() = movieCatalogueRepository.getTvShows()
}