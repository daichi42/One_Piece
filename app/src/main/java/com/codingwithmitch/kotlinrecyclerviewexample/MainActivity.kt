package com.codingwithmitch.kotlinrecyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithmitch.kotlinrecyclerviewexample.models.OnePiece
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TomeRecyclerAdapter.OnTomeItemClickListener {

    private lateinit var tomeAdapter: TomeRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()


    }

    private fun addDataSet(){
        val utils = Utils()
        val jsonFileString = utils.getJsonDataFromAsset(applicationContext, "op.json")

        val gson = Gson()
        val listTomes = object : TypeToken<List<OnePiece>>() {}.type

        val tomes: ArrayList<OnePiece> = gson.fromJson(jsonFileString, listTomes)
        val data = DataSource.createDataSet(tomes)
        tomeAdapter.submitList(data)
    }

    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            tomeAdapter = TomeRecyclerAdapter(this@MainActivity)
            adapter = tomeAdapter
        }
    }

    override fun onItemClick(item: OnePiece, position: Int) {
        val intent = Intent(this, TomeDetailsActivity::class.java)
        intent.putExtra("chapitres", item.chapitres)
        startActivity(intent)
    }


}























