package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //access items from string file
        val languages = resources.getStringArray(R.array.Languages)

        //create spinner
        val spinner = Spinner(this)
        spinner.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)
        //add spinner in linear layout
        linearLayout?.addView(spinner)
        if(spinner!=null)
        {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item)+""+
                        ""+languages[position],Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //write code to perform action
                var txt = findViewById<TextView>(R.id.txtView)
                    txt.setText(" here is ")
                }
                }
        }
    }
}