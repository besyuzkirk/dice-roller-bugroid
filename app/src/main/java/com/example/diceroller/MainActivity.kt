package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stat = Stat()
        var dice : Dice = Dice(6)

        var sideOfDice = 6
        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val animation = AnimationUtils.loadAnimation(this,R.anim.shake)
        val rollButton: Button = findViewById(R.id.button)
        val deleteResult: Button = findViewById(R.id.button3)
        val deleteStatButton: Button = findViewById(R.id.button2)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if(R.id.radioButton == checkedId) {
                sideOfDice = 4
                diceImage.setImageResource(R.drawable.dice4face1)
                dice = Dice(sideOfDice)

            }
            if(R.id.radioButton2 == checkedId) {
                sideOfDice = 6
                diceImage.setImageResource(R.drawable.dice_6)
                dice = Dice(sideOfDice)

            }
            if(R.id.radioButton3 == checkedId) {
                sideOfDice = 8
                diceImage.setImageResource(R.drawable.dice8face1)
                dice = Dice(sideOfDice)

            }
        }

        rollButton.setOnClickListener {
            var result = dice.roll()
            val drawableResource : Int = dice.setDiceType(result)
            stat.addPoint(result)
            textView2.text = "Result: " + result
            textView.text = "Sum: " + stat.point.toString()
            diceImage.contentDescription = result.toString()
            diceImage.setImageResource(drawableResource)
            diceImage.startAnimation(animation)
        }

        deleteStatButton.setOnClickListener {
            stat.deletePoint()
            textView.text ="Sum: 0"
        }

        deleteResult.setOnClickListener {
            textView2.text = "Result: 0"
        }




    }
}




