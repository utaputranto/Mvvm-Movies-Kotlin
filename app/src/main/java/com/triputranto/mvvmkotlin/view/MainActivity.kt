package com.triputranto.mvvmkotlin.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.triputranto.mvvmkotlin.R
import com.triputranto.mvvmkotlin.base.BaseActivity
import com.triputranto.mvvmkotlin.entity.Results
import com.triputranto.mvvmkotlin.viewmodel.MovieViewModel
import java.util.*

/*Created by    : Ahmad Tri Putranto
* Date / Time   : 29 December 2019 / 01.55 Am
* Last Update   : 29 December 2019 / 01.55 Am */

class MainActivity : BaseActivity() {
    private lateinit var movieViewModel: MovieViewModel

    private val listObserver = Observer<ArrayList<Results>> { movies ->
        if (movies != null) {
            Toast.makeText(this, movies[3].title, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupData()
    }

    private fun setupViewModel() {
        movieViewModel = MovieViewModel()
        movieViewModel.getMovies().observe(this, listObserver)
    }

    private fun setupData() {
        movieViewModel.setDiscoverMovie(checkLanguage())
    }
}
