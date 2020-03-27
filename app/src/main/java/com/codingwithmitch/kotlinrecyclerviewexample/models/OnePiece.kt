package com.codingwithmitch.kotlinrecyclerviewexample.models

data class OnePiece(
    var id: Int,

    var volume: String,

    var image: String,

    var chapitres: ArrayList<String>

) {

    override fun toString(): String {
        return "BlogPost(title='$volume', image='$image', username='$chapitres')"
    }


}
























