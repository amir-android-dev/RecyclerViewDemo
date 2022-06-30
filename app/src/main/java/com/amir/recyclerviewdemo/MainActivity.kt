package com.amir.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val fruitList = listOf<Fruit>(
        Fruit("mango", "Joe"),
        Fruit("Banana", "Benn"),
        Fruit("Lemon", "Frank"),
        Fruit("Orange", "Sam"),
        Fruit("Watermelon", "Fa"),
        Fruit("Apple","Resi"),
        Fruit("Guava","Girl"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv_demo)
        rv.setBackgroundColor(Color.MAGENTA)

        //layoutManagers: how to display data
        rv.layoutManager = LinearLayoutManager(this)
        //setting our Adapter class, as the adapter of the RecyclerView
        rv.adapter = RvAdapter(fruitList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this@MainActivity,"Select ${fruit.supplier}", Toast.LENGTH_SHORT).show()
    }
}