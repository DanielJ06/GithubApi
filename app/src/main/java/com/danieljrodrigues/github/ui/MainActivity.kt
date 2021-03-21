package com.danieljrodrigues.github.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.danieljrodrigues.github.R
import com.danieljrodrigues.github.data.Repository
import com.danieljrodrigues.github.viewmodels.MainViewModel
import com.danieljrodrigues.github.viewmodels.MainViewModelFactoryProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

    }
}