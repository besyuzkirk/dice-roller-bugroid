package com.example.diceroller

class Stat() {

    var point = 0

    fun addPoint(result : Int) {
        point = point + result
    }

    fun deletePoint() {
        this.point = 0
    }

}