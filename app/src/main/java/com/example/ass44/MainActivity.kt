package com.example.ass44

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*




class MainActivity : AppCompatActivity() {
    lateinit var etfName: EditText
    lateinit var etlName: EditText
    lateinit var etAge: EditText
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etfName = findViewById(R.id.fname)
        etlName = findViewById(R.id.lname)
        etAge = findViewById(R.id.age)
        btnSend = findViewById(R.id.btnSend)

        val languages = resources.getStringArray(R.array.Gender)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter

            btnSend.setOnClickListener {

                val bundle = Bundle()
                bundle.putString("fname", etfName.text.toString())
                bundle.putString("lname", etlName.text.toString())
                bundle.putString("age", etAge.text.toString())
                //bundle.putString("gender", etGender.text.toString())
                bundle.putString("gender", spinner.selectedItem.toString())
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}

