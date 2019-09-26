package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //create binding object
    private lateinit var binding: ActivityMainBinding

    //lateinit var editText: EditText
    //lateinit var nicknameTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //the binding object connects the layout with the activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
        //}

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        //editText = findViewById(R.id.nickname_edit)
        //nicknameTextView = findViewById(R.id.nickname_text)
    }

    private fun addNickname(view: View) {

        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        //nicknameTextView.text = editText.text
        //editText.visibility = View.GONE
        //view.visibility = View.GONE
        //nicknameTextView.visibility = View.VISIBLE

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
