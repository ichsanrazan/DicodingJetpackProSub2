package com.dicoding.jetpackprosub2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.jetpackprosub2.data.source.local.entity.DetailEntity
import com.dicoding.jetpackprosub2.data.source.local.entity.MoviesEntity
import com.dicoding.jetpackprosub2.data.source.local.entity.TvEntity
import com.dicoding.jetpackprosub2.data.source.remote.RemoteDataSource
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.Movie
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.MovieDetailResponse
import com.dicoding.jetpackprosub2.data.source.remote.response.tv.TvShow
import com.dicoding.jetpackprosub2.data.source.remote.response.tv.TvShowDetailResponse

class DataRepository private constructor(private val rmtDataSource: RemoteDataSource) : DataSource{
    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteData: RemoteDataSource): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData)
                }
    }

    override fun getMovies(): LiveData<List<MoviesEntity>> {
        val movieResult = MutableLiveData<List<MoviesEntity>>()

        rmtDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                val movieList = ArrayList<MoviesEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MoviesEntity(id, title, posterPath, voteAverage)
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }
        })
        return movieResult
    }

    override fun getDetailMovie(movieId: String): LiveData<DetailEntity> {
        val movieDetailResult = MutableLiveData<DetailEntity>()

        rmtDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
                if (movieDetail != null) {
                    with(movieDetail) {
                        val listGenres = ArrayList<String>()

                        for (genre in genres) {
                            listGenres.add(genre.name)
                        }

                        val detailMovie = DetailEntity(
                                backdropPath = backdropPath,
                                genres = listGenres,
                                id = id,
                                overview = overview,
                                posterPath = posterPath,
                                releaseDate = releaseDate,
                                runtime = runtime,
                                title = title,
                                voteAverage = voteAverage
                        )
                        movieDetailResult.postValue(detailMovie)
                    }
                }
            }
        }, movieId)
        return movieDetailResult
    }

    override fun getTvShows(): LiveData<List<TvEntity>> {
        val tvResult = MutableLiveData<List<TvEntity>>()

        rmtDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsLoaded(tvShows: List<TvShow>?) {
                val tvList = ArrayList<TvEntity>()
                if (tvShows != null) {
                    for (response in tvShows) {
                        with(response) {
                            val tvShow = TvEntity(id, name, posterPath, voteAverage)
                            tvList.add(tvShow)
                        }
                    }
                    tvResult.postValue(tvList)
                }
            }
        })
        return tvResult
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity> {
        val movieDetailResult = MutableLiveData<DetailEntity>()

        rmtDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?) {
                if (tvShowDetail != null) {
                    with(tvShowDetail) {
                        val listGenres = ArrayList<String>()

                        for (genre in genres) {
                            listGenres.add(genre.name)
                        }

                        val detailMovie = DetailEntity(
                                backdropPath = backdropPath,
                                genres = listGenres,
                                id = id,
                                overview = overview,
                                posterPath = posterPath,
                                releaseDate = firstAirDate,
                                runtime = episodeRunTime.average().toInt(),
                                title = name,
                                voteAverage = voteAverage
                        )
                        movieDetailResult.postValue(detailMovie)
                    }
                }
            }
        }, tvShowId)
        return movieDetailResult
    }
}