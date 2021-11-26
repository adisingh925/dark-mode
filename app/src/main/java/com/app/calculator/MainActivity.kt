package com.app.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.calculator.databinding.ActivityMainBinding
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text:String

        binding.zero.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"0"
            binding.typespace.setText(text)
            result(text)
        }

        binding.one.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"1"
            binding.typespace.setText(text)
            result(text)
        }

        binding.two.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"2"
            binding.typespace.setText(text)
            result(text)
        }

        binding.three.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"3"
            binding.typespace.setText(text)
            result(text)
        }

        binding.four.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"4"
            binding.typespace.setText(text)
            result(text)
        }

        binding.five.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"5"
            binding.typespace.setText(text)
            result(text)
        }

        binding.six.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"6"
            binding.typespace.setText(text)
            result(text)
        }

        binding.seven.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"7"
            binding.typespace.setText(text)
            result(text)
        }

        binding.eight.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"8"
            binding.typespace.setText(text)
            result(text)
        }

        binding.nine.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"9"
            binding.typespace.setText(text)
            result(text)
        }

        binding.add.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"+"
            binding.typespace.setText(text)
            check += 1
            result(text)
        }

        binding.subtract.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"-"
            binding.typespace.setText(text)
            check += 1
            result(text)
        }

        binding.multiply.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"*"
            binding.typespace.setText(text)
            check += 1
            result(text)
        }

        binding.divide.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"/"
            binding.typespace.setText(text)
            check += 1
            result(text)
        }

        binding.exponent.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"^"
            binding.typespace.setText(text)
            check += 1
            result(text)
        }

        binding.percent.setOnClickListener()
        {
            text = binding.typespace.text.toString()+"%"
            binding.typespace.setText(text)
            check += 1
            result(text)
        }

        binding.clearall.setOnClickListener()
        {
            binding.typespace.text = null
            binding.displayspace.text = null
            check = 0
        }

        binding.delete.setOnClickListener()
        {
            if(binding.typespace.length()!=0)
            {
                val stringBuilder = StringBuilder(binding.typespace.text)
                val find = binding.typespace.text.last().toString()
                if(find == "+" || find == "-" || find == "/" || find == "*" || find == "^" || find == "%")
                {
                    check -= 1
                }
                stringBuilder.deleteCharAt(binding.typespace.text.length-1)
                binding.typespace.setText(stringBuilder.toString())
                binding.displayspace.text = null

                if(stringBuilder.toString().isEmpty())
                {

                }
                else
                {
                    result(stringBuilder.toString())
                }
            }
        }
    }

    fun result(text:String)
    {
        var engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result:Any = engine.eval(text)
            if(check == 0)
            {
                binding.displayspace.text = null
            }
            else
            {
                binding.displayspace.setText(result.toString())
            }
        }
        catch (e :ScriptException)
        {

        }
    }
}