package app.itakura.reirei.a06sosuu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object{
        private const val QUESTION_COUNT:Int = 10
    }

    var random : Random = Random
    val questions :IntArray = IntArray(QUESTION_COUNT)
    var point : Int = 0
    var answerCount : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until QUESTION_COUNT) {
            val number = random.nextInt(1000)
            Log.d("Number", "Queation" + number.toString())
            questions[i] = number
        }

        point = 0
        answerCount = 0

        numberTextView.text = questions[answerCount].toString() + ""
        numberTextView.setTextColor(Color.BLACK)
    }


        fun maru(v: View){
            var answer = true
            val number = questions[answerCount]

            for(i in 2 until number){
                if (number % i == 0){
                    answer = false
                    Log.d("i",i.toString())
                    break
                }
            }

            if (answer){
                Toast.makeText(this,"正解",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"不正解",Toast.LENGTH_SHORT).show()
            }

            Log.d("answer", answer.toString())

            if (answer){
                point++
                Log.d("maru","正解" + point.toString())
            }else{
                Log.d("maru","不正解")
            }

            answerCount++

            if(answerCount == QUESTION_COUNT){
                numberTextView.text = point.toString() + "点"
                numberTextView.setTextColor(Color.RED)

                point = 0
                answerCount = 0
            }else{
                numberTextView.text = questions[answerCount].toString() + ""
                numberTextView.setTextColor(Color.BLACK)
            }


        }


        fun batsu(v: View){
            var answer = true
            val number = questions[answerCount]

            for(i in 2 until number){
                if (number % i == 0){
                    answer = false
                    Log.d("i",i.toString())
                    break
                }
            }

            Log.d("answer", answer.toString())

            if (answer){
                Toast.makeText(this,"不正解",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"正解",Toast.LENGTH_SHORT).show()
            }

            if (answer){
                Log.d("batsu","不正解")
            }else{
                point++
                Log.d("batsu","正解"+ point.toString())
            }

            answerCount++

            if(answerCount == QUESTION_COUNT){
                numberTextView.text = point.toString() + "点"
                numberTextView.setTextColor(Color.RED)

                point = 0
                answerCount = 0
            }else{
                numberTextView.text = questions[answerCount].toString() + ""
                numberTextView.setTextColor(Color.BLACK)
            }


        }


}