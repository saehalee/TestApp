package com.example.traveltest

import android.os.StrictMode
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionClass {
    private val ip =  "192.168.0.31:1433"
    private val db = "TestApplication"
    private val username = "sa"
    private val password = "Init@2022"

    fun dbConn(): Connection?{
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString : String? = null
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"
            conn = DriverManager.getConnection(connString)
        } catch(e:ClassNotFoundException) {
            e.printStackTrace()
        } catch(e: SQLException) {
            e.printStackTrace()
        } catch(e:Exception) {
            e.printStackTrace()
        }
        return conn
    }
}