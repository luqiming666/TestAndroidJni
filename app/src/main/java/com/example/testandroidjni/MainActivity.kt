package com.example.testandroidjni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testandroidjni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.helloText.text = stringFromJNI()

        binding.btnCalculate.setOnClickListener {
            val len =  testLength("AAC Shanghai")
            val result = addTwoNumbers(len, 66)
            binding.info1.text = "The string length is $len, which plus 66 equals $result"
        }
    }

    /**
     * A native method that is implemented by the 'testandroidjni' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun addTwoNumbers(num1: Int, num2: Int): Int
    external fun testLength(text: String): Int

    companion object {
        // Used to load the 'testandroidjni' library on application startup.
        init {
            System.loadLibrary("testandroidjni")
        }
    }
}