package com.shivajee.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.google.android.material.R.id.layout
import com.shivajee.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Shivajee")
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.done).setOnClickListener {
//        editName(it)
//        }
        binding.done.setOnClickListener { editName(it) }


    }

    private fun editName(view: View) {
        val editText = findViewById<EditText>(R.id.NickNameEdit)
        val nickNameTextView = findViewById<TextView>(R.id.NickNameText)
        binding.apply {
            NickNameText.text = binding.NickNameEdit.text
            invalidateAll()
            myName?.nickName = NickNameEdit.text.toString()
            NickNameEdit.visibility = View.GONE
            done.visibility = View.GONE
            NickNameText.visibility = View.VISIBLE
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}