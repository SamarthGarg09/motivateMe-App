package com.example.motivatemeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var message:TextView
    private lateinit var motivationalImages:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val updateButton:Button=findViewById(R.id.activity_main_btn_update)
        updateButton.setOnClickListener { updateMessage()}
        name=findViewById(R.id.activity_main_et_name)
        message=findViewById(R.id.activity_main_tv_message)
        motivationalImages=findViewById(R.id.activity_main_iv_comment)
    }
    private fun updateMessage(){
        val input=name.text
        val motivationalMessages=listOf("Keep working hard!","Believe on yourself!","Never give up!","Difficulty is growth!","Always keep your head up!")
        val index= (0..4).random()
        val currentMessage=motivationalMessages[index]
        val imageIndex=(0..8).random()
        val selectedID=when(imageIndex){
            0->R.drawable.image1
            1->R.drawable.image2
            2->R.drawable.image9
            3->R.drawable.image3
            4->R.drawable.image4
            5->R.drawable.image5
            6->R.drawable.image6
            7->R.drawable.image7
            else->R.drawable.image8
        }


        if(input.toString()==""){
            message.text="Please write your name!"
        }
        else{
            message.text="Hello $input $currentMessage"
            motivationalImages.setImageResource(selectedID)
        }
        name.setText("")
        hideKeyboard()
    }
    //hide the keyboard by call inputMethodManager
    private fun hideKeyboard(){
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken,0)
    }
}