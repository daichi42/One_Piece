package com.codingwithmitch.kotlinrecyclerviewexample

import com.codingwithmitch.kotlinrecyclerviewexample.models.OnePiece

class DataSource{

    companion object{

        fun createDataSet(onePiece: ArrayList<OnePiece>): ArrayList<OnePiece>{



            return onePiece
        }
    }
}