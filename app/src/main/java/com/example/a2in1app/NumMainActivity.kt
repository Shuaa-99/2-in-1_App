package com.example.a2in1app
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_num_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class NumMainActivity : AppCompatActivity() {
    val myMessage = ArrayList<String>()
    var count = 4
    val randomNum = Random.nextInt(10)

    private lateinit var button_click: Button
    private lateinit var txt_Enter: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Numbers Game"
        actionBar.setDisplayHomeAsUpEnabled(true)
        txt_Enter = findViewById(R.id.numGuessed)
        button_click = findViewById(R.id.bttn_click)

        button_click.setOnClickListener {
            if (txt_Enter.text.toString().toInt() == randomNum && count > 1 ){
                myMessage.add("Your guess ${txt_Enter.text.toString()} is correct ")
                myMessage.add("Your win :)")
                myMessage.add("GAME OVER")
                val myRV = findViewById<RecyclerView>(R.id.rvGuesses)
                myRV.adapter = RecyclerViewAdapter(myMessage)
                myRV.layoutManager = LinearLayoutManager(this)
                txt_Enter.text = null
                bttn_click.isEnabled = false
                txt_Enter.isEnabled = false
            }
            else if (txt_Enter.text.toString().toInt() != randomNum && count > 1){
                count -=1
                myMessage.add("Your guess ${txt_Enter.text.toString()} is wrong :( try again")
                myMessage.add("Remember you have $count attempts left ")
                val myRV = findViewById<RecyclerView>(R.id.rvGuesses)
                myRV.adapter = RecyclerViewAdapter(myMessage)
                myRV.layoutManager = LinearLayoutManager(this)
                txt_Enter.text = null
            }
            else{
                myMessage.add("Attempts are OVER, you lost :( " )
                myMessage.add("GAME OVER")
                val myRV = findViewById<RecyclerView>(R.id.rvGuesses)
                myRV.adapter = RecyclerViewAdapter(myMessage)
                myRV.layoutManager = LinearLayoutManager(this)
                bttn_click.isEnabled = false
                txt_Enter.isEnabled = false
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.PhraseGame -> {
                val intent = Intent(this,PhraseMainActivity::class.java)
                startActivity(intent)
            }
            R.id.menu -> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}