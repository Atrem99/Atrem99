package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Кнопки
        btn_0.setOnClickListener { action("0") }
        btn_1.setOnClickListener { action("1") }
        btn_2.setOnClickListener { action("2") }
        btn_3.setOnClickListener { action("3") }
        btn_4.setOnClickListener { action("4") }
        btn_5.setOnClickListener { action("5") }
        btn_6.setOnClickListener { action("6") }
        btn_7.setOnClickListener { action("7") }
        btn_8.setOnClickListener { action("8") }
        btn_9.setOnClickListener { action("9") }
        btn_point.setOnClickListener { action(".") }
        btn_minus.setOnClickListener { action("-")}
        btn_plus.setOnClickListener { action("+") }
        btn_skobka1.setOnClickListener { action("(") }
        btn_skobka2.setOnClickListener { action(")") }
        btn_multiplication.setOnClickListener { action("*") }
        btn_devision.setOnClickListener { action("/") }


        //Удаляем написанное
        btn_ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }

        //Стираем последнее значение
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)
            result_text.text=""
        }

        //Вычисляем
        btn_ravno.setOnClickListener {
            try{
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val resLong = result.toLong()

                if(result == resLong.toDouble())
                    result_text.text = resLong.toString()
                else
                    result_text.text = result.toString()

            }catch (e:Exception) {
                Log.d("Ошибка", "сообщение: + ${e.message}")
            }

        }
    }


    fun action (str: String){
        math_operation.append(str)
    }
}





