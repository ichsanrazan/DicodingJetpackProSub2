package com.dicoding.jetpackprosub2.movies

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpackprosub2.databinding.FragmentMovieBinding
import com.dicoding.jetpackprosub2.detail.DetailActivity
import com.dicoding.jetpackprosub2.detail.DetailViewModel.Companion.MOVIE
import com.dicoding.jetpackprosub2.utils.MarginItemDecoration
import com.dicoding.jetpackprosub2.viewmodel.ViewModelFactory

class MoviesFragment : Fragment(), MoviesAdapter.OnItemClickCallback {

    private lateinit var fragMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            showProgressBar(true)

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            val movAdapter = MoviesAdapter()

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                showProgressBar(false)
                movAdapter.setMovies(movies)
                movAdapter.setOnItemClickCallback(this)
                movAdapter.notifyDataSetChanged()
            })

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragMovieBinding.rvMovies) {
                addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movAdapter
            }
        }
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EX_FILM, id)
        intent.putExtra(DetailActivity.EX_CATEGORY, MOVIE)

        context?.startActivity(intent)
    }

    private fun showProgressBar(state: Boolean) {
        fragMovieBinding.pbMovies.isVisible = state
        fragMovieBinding.rvMovies.isInvisible = state
    }

}