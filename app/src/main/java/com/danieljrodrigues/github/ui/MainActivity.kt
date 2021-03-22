package com.danieljrodrigues.github.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danieljrodrigues.github.R
import com.danieljrodrigues.github.adapters.EventsAdapter
import com.danieljrodrigues.github.data.Repository
import com.danieljrodrigues.github.databinding.ActivityMainBinding
import com.danieljrodrigues.github.utils.NetworkResult
import com.danieljrodrigues.github.viewmodels.MainViewModel
import com.danieljrodrigues.github.viewmodels.MainViewModelFactoryProvider

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    lateinit var mAdapter: EventsAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        val eventRepository = Repository()
        val viewModelFactoryProvider = MainViewModelFactoryProvider(eventRepository)
        mViewModel =
            ViewModelProvider(this, viewModelFactoryProvider).get(MainViewModel::class.java)

        mViewModel.getEvents()
        mViewModel.eventsResponse.observe(this, Observer { res ->
            when (res) {
                is NetworkResult.Success -> {
                    Log.i("Data", res.toString())
                    res.data?.let { mAdapter.setData(it) }
                }
            }
        })
    }

    private fun setupRecyclerView() {
        mAdapter = EventsAdapter()
        binding.rvEvents.adapter = mAdapter
        binding.rvEvents.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}