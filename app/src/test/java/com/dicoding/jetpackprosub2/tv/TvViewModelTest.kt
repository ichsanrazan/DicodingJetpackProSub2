package com.dicoding.jetpackprosub2.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpackprosub2.data.source.DataRepository
import com.dicoding.jetpackprosub2.data.source.local.entity.TvEntity
import com.dicoding.jetpackprosub2.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<TvEntity>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = DataDummy.getTvShows()
        val tvShows = MutableLiveData<List<TvEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(movieCatalogueRepository.getTvShows()).thenReturn(tvShows)
        val tvShow = viewModel.getTvShows().value
        verify(movieCatalogueRepository).getTvShows()
        assertNotNull(tvShow)
        assertEquals(3, tvShow?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}