package com.danieljrodrigues.github.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.danieljrodrigues.github.databinding.EventCardItemBinding
import com.danieljrodrigues.github.models.Event

class EventsAdapter : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    private var events = emptyList<Event>()

    class EventViewHolder(private val binding: EventCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): EventViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EventCardItemBinding.inflate(layoutInflater, parent, false)
                return EventViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentPosition = events[position]
        holder.bind(currentPosition)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    fun setData(data: List<Event>) {
        events = data
        notifyDataSetChanged()
    }

}