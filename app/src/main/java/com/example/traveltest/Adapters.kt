package com.example.traveltest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Testadapter(val tests : ArrayList<Test>) : RecyclerView.Adapter<Testadapter.ViewHolder>() {
    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val txtTestNo = itemView.findViewById(R.id.txtTestNo) as TextView
        val txtTestDesc = itemView.findViewById(R.id.txtTestName) as TextView
        val txtTestName = itemView.findViewById(R.id.txtTestDesc) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Testadapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.testlist, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Testadapter.ViewHolder, position: Int) {
        val test : Test = tests[position]

        holder?.txtTestNo.text = test.TestNo.toString()
        holder?.txtTestName.text = test.TestName.toString()
        holder?.txtTestDesc.text = test.TestDesc.toString()
    }

    override fun getItemCount(): Int {
        return tests.size
    }
}