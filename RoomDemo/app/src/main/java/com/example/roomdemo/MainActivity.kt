package com.example.roomdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.databinding.ActivityMainBinding
import com.example.roomdemo.db.Subscriber
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Only traditional method work
    lateinit var viewModel: SubscriberViewModel

    private lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        actionBar?.show()
        viewModel = ViewModelProvider(this)[SubscriberViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
        initRecyclerView()

        viewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter { selectedItem: Subscriber -> listItemClicked(selectedItem) }
        binding.subscriberRecyclerView.adapter = adapter
        displaySubscriberList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displaySubscriberList() {
        viewModel.getSavedSubscribers().observe(this, Observer {
            Log.i("MyTag", it.toString())
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun listItemClicked(subscriber: Subscriber) {
        //Toast.makeText(this, "selected name is ${subscriber.name}", Toast.LENGTH_SHORT).show()
        viewModel.initUpdateAndDelete(subscriber)
    }
}