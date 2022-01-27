package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button14.setOnClickListener{calculate(1)}
        binding.button13.setOnClickListener{calculate(2)}
        binding.button12.setOnClickListener{calculate(3)}
        binding.button4.setOnClickListener{calculate(7)}
        binding.button7.setOnClickListener{calculate(4)}
        binding.button10.setOnClickListener{calculate(6)}
        binding.button11.setOnClickListener{calculate(5)}
        binding.button5.setOnClickListener{calculate(9)}
        binding.button6.setOnClickListener{calculate(8)}
        binding.button2.setOnClickListener{calculate(0)}

        binding.button.setOnClickListener{
            if(binding.textView.text.isNotEmpty())
            binding.textView.text = binding.textView.text.substring(0,binding.textView.text.length-1)
            calculateResult()
        }

        binding.button3.setOnClickListener{
            if(binding.textView2.text != "0" && binding.textView.text[binding.textView.text.length-1]!='+')
            binding.textView.text = binding.textView.text.toString() + "+"
        }

        binding.button15.setOnClickListener{
            binding.textView.text = "0"
            calculateResult()
        }


    }

    fun calculate(int: Int){
        if(binding.textView.text == "0") binding.textView.text = ""
        binding.textView.text = binding.textView.text.toString() + int.toString()

        calculateResult()
    }
    fun calculateResult(){
        try {
            if(binding.textView.text.isEmpty()) binding.textView2.text = "0"
            val numbers = binding.textView.text.toString().split("+")
            var res = 0L
            for (i in numbers){
                if(i=="")continue
                res += i.toLong()}
            binding.textView2.text = res.toString()
        }catch (e:Exception){

        }

    }
}