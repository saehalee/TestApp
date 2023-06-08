package com.example.traveltest

import android.app.ActivityManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.traveltest.ui.theme.TravelTestTheme
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
             navController = navHostFragment.navController
    }

    private fun connectToDatabase():Connection?{
        var connection:Connection? = null

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            val url = "jdbc:jtds:sqlserver://192.168.0.31:1433/TestApplication;user=sa;password=Init@2022"
            connection = DriverManager.getConnection(url)

//            if(connection == null){
//                if(showMessa)
//            }
        } catch(e:ClassNotFoundException) {
            e.printStackTrace()
        } catch(e:SQLException) {
            e.printStackTrace()
        } catch(e:Exception) {
            e.printStackTrace()
        }
        return connection
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TravelTestTheme {
//        Greeting("Android")
//    }
//}