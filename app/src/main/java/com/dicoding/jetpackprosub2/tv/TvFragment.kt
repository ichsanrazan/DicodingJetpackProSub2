package com.dicoding.jetpackprosub2.tv

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
import com.dicoding.jetpackprosub2.databinding.FragmentTvBinding
import com.dicoding.jetpackprosub2.detail.DetailActivity
import com.dicoding.jetpackprosub2.detail.DetailViewModel.Companion.TV_SHOW
import com.dicoding.jetpackprosub2.utils.MarginItemDecoration
import com.dicoding.jetpackprosub2.viewmodel.ViewModelFactory

class TvFragment : Fragment(), TvAdapter.OnItemClickCallback {

    private lateinit var fragTvShowBinding: FragmentTvBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragTvShowBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            showProgressBar(true)

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
            val tvAdapter = TvAdapter()

            viewModel.getTvShows().observe(viewLifecycleOwner, {tvShows ->
                showProgressBar(false)
                tvAdapter.setTvShows(tvShows)
                tvAdapter.setOnItemClickCallback(this)
                tvAdapter.notifyDataSetChanged()
            })

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragTvShowBinding.rvTvShows) {
                addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvAdapter
            }
        }
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EX_FILM, id)
        intent.putExtra(DetailActivity.EX_CATEGORY, TV_SHOW)

        context?.startActivity(intent)
    }

    private fun showProgressBar(state: Boolean) {
        fragTvShowBinding.pbTvShows.isVisible = state
        fragTvShowBinding.rvTvShows.isInvisible = state
    }

}