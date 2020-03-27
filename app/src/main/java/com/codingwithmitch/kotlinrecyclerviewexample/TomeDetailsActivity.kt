package com.codingwithmitch.kotlinrecyclerviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithmitch.kotlinrecyclerviewexample.databinding.ActivityTomeDetailsBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tome_details.*


class TomeDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityTomeDetailsBinding
    private lateinit var chapitresAdapter: ChapitresRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tome_details)
        initRecyclerView()
        addDataSet()

    }

    private fun initRecyclerView(){

        chapitres_recycler.apply {
            layoutManager = LinearLayoutManager(this.context)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            chapitresAdapter = ChapitresRecyclerAdapter()
            adapter = chapitresAdapter
        }
    }

    private fun addDataSet(){
        val i = intent
        if (i != null) {
            val chapitres: ArrayList<String> = i
                .getSerializableExtra("chapitres") as ArrayList<String>

            chapitresAdapter.submitList(chapitres)
        }
    }
}