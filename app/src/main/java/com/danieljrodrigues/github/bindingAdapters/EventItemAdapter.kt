package com.danieljrodrigues.github.bindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

class EventItemAdapter {

    companion object {

        @BindingAdapter(value=["actorName", "repoName", "eventType"], requireAll = true)
        @JvmStatic
        fun setTitleText(textView: TextView, actorName: String, repoName: String, eventType: String) {
            when {
                eventType.contains("WatchEvent") -> {
                    textView.text = "$actorName starred $repoName"
                }
                eventType.contains("CreateEvent") -> {
                    textView.text = "$actorName created a repository $repoName"
                }
                eventType.contains("ForkEvent") -> {
                    textView.text = "$actorName forked $repoName"
                }
                else -> {
                    textView.text = "$actorName made $repoName public"
                }
            }
        }
    }

}