package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    var aboutString = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)



        // changes the title on the blue bar
        supportActionBar!!.title = "About"

        var aboutIntent = intent;

        // "about" is the secret word we pass in from out Main Activity
        aboutString = aboutIntent.getStringExtra("about") as String;


        about_textView.text = aboutString;
    }

}