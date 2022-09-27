package com.example.simplecalculator

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.simplecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil. setContentView(this, R.layout.activity_main)

        // Numbers
        binding.num1.setOnClickListener {
            binding.workingTv.append(binding.num1.text)
        }
        binding.num2.setOnClickListener {
            binding.workingTv.append(binding.num2.text)
        }
        binding.num3.setOnClickListener {
            binding.workingTv.append(binding.num3.text)
        }
        binding.num4.setOnClickListener {
            binding.workingTv.append(binding.num4.text)
        }
        binding.num5.setOnClickListener {
            binding.workingTv.append(binding.num5.text)
        }
        binding.num6.setOnClickListener {
            binding.workingTv.append(binding.num6.text)
        }
        binding.num7.setOnClickListener {
            binding.workingTv.append(binding.num7.text)
        }
        binding.num8.setOnClickListener {
            binding.workingTv.append(binding.num8.text)
        }
        binding.num9.setOnClickListener {
            binding.workingTv.append(binding.num9.text)
        }
        binding.num0.setOnClickListener {
            binding.workingTv.append(binding.num0.text)
        }
        binding.numDot.setOnClickListener {
            binding.workingTv.append(binding.numDot.text)
        }

        // Actions
        binding.actionDivide.setOnClickListener {
            binding.workingTv.append(binding.actionDivide.text)
        }
        binding.actionMinus.setOnClickListener {
            binding.workingTv.append(binding.actionMinus.text)
        }
        binding.actionPlus.setOnClickListener {
            binding.workingTv.append(binding.actionPlus.text)
        }
        binding.actionMul.setOnClickListener {
            binding.workingTv.append(binding.actionMul.text)
        }
        binding.actionPercent.setOnClickListener {
            binding.workingTv.append(binding.actionPercent.text)
        }
        binding.actionClear.setOnClickListener {
            binding.workingTv.setText(null)
            binding.resultTv.setText(null)
        }
        binding.actionBack.setOnClickListener {
            removeLastText()
        }
        binding.actionEquals.setOnClickListener {
            performActions()
        }
    }

    fun performActions() {
        var result = ExpressionBuilder(binding.workingTv.text.toString()).build().evaluate()
        val longResult = result.toLong()
        Log.d(TAG, "performActions: "+result)
        binding.resultTv.visibility = View.VISIBLE
        if(result == longResult.toDouble()) {
            binding.resultTv.setText(longResult.toString())
        } else {
            binding.resultTv.setText(result.toString())
        }
    }

    fun removeLastText() {
        val str = binding.workingTv.text.toString()
        val result = str.dropLast(1)
        binding.workingTv.setText(result)
    }
}