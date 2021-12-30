package com.example.diceroller

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

    fun setDiceType(randomNumber : Int) : Int{
        val drawableId = when(numSides) {
            4 -> set4DrawableResource(randomNumber)
            6 -> set6DrawableResource(randomNumber)
            else -> set8DrawableResource(randomNumber)
        }
        return drawableId
    }

    fun set4DrawableResource(num : Int) : Int {

        val drawableResource = when (num) {
            1 -> R.drawable.dice4face1
            2 -> R.drawable.dice4face2
            3 -> R.drawable.dice4face3
            else -> R.drawable.dice4face4
        }

        return drawableResource
    }

    fun set8DrawableResource(num : Int) : Int {

        val drawableResource = when (num) {
            1 -> R.drawable.dice8face1
            2 -> R.drawable.dice8face2
            3 -> R.drawable.dice8face3
            4 -> R.drawable.dice8face4
            5 -> R.drawable.dice8face5
            6 -> R.drawable.dice8face6
            7 -> R.drawable.dice8face7
            else -> R.drawable.dice8face8
        }
        return  drawableResource
    }

    fun set6DrawableResource(num : Int) : Int {

        val drawableResource = when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
}