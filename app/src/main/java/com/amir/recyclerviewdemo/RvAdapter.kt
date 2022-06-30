package com.amir.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//Unit means, the function has no return value. Just like void in java.
class RvAdapter(private val fruitList: List<Fruit>,private val clickListener:(Fruit)->Unit) : RecyclerView.Adapter<MViewHolder>() {

    //I am going to implement the onCreateViewHolder function.
// This is where we create the list item. To do that we need a template
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
/*
 recycler view library wants us to return a viewholder instance.We have defined a MyViewHolder instance(mViewHolder Class),
the MyViewHolder class we created is a sub class of ViewHolder class.
So MyViewHolder is a ViewHolder. Which has a constructor with a view as a parameter.
 */
        return MViewHolder(listItem)
    }

    //We use onBindViewHolder to display data on the list item.
    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.bind(fruitList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}

//We shoud add a view as a constructor parameter.
class MViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    /*
    Actually, we suppose to send these data from onBindViewHolder to the MyViewHolder and this setting values part should be done in the view holder class.
That is the recommended object oriented programming best practice.
     */
fun bind(fruit: Fruit,clickListener:(Fruit)->Unit){
        val mTv = view.findViewById<TextView>(R.id.tvName)
        mTv.text = fruit.name

        view.setOnClickListener {
           clickListener(fruit)

        }
}


}