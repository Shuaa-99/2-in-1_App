package com.example.a2in1app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    lateinit var button2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this,NumMainActivity::class.java)
            startActivity(intent)
        }
        button2=findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this,PhraseMainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.NumGame -> {
                val intent = Intent(this,NumMainActivity::class.java)
                startActivity(intent)
            }
            R.id.PhraseGame -> {
                val intent = Intent(this,PhraseMainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
