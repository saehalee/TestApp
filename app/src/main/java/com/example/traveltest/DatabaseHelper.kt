package com.example.traveltest

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.recyclerview.widget.RecyclerView

class DatabaseHelper {
    lateinit var ctx : Context

    private val isConnected = false
    private lateinit var rv : RecyclerView
    private lateinit var query : String
    private lateinit var adapter : RecyclerView.Adapter<*>
    private var recordCount : Int = 0
    private var functionType : Int = 0
    private lateinit var records : ArrayList<Any>
    lateinit var connectionClass : ConnectionClass

    inner class SyncData : AsyncTask<String, String, String>() {
        private message = "No Connection or Windows FireWall, not enough permissions Error!"
        lateinit var prog : ProgressDialog

        override fun onPreExecute(){
            records.clear()
            recordCount = 0
            prog = ProgressDialog.show(ctx, "Reading Data...","Loading.. Please Wait", true)
        }

        override fun doInBackground(vararg param: String?) : String {
            var myConn = connectionClass?.dbConn()

            if(myConn == null) {
                isConnected = false
            } else {
                val statement = myConn!!.createStatement()
                val cursor = statement.executeQuery(query)

                if(cursor != null) {
                    while(cursor!!.next()) {
                        try {
                            records?.add(customer(cursor!!.getInt("CustomerNo"), cursor!!.get))
                        }
                    }
                }
            }
        }
    }
}