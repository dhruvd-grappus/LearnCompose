package com.example.kotlinkontrol


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController


enum class Routes() {
    Main,
    Random
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp()
        }
    }
    @Composable
    fun MainApp(){
        val navController = rememberNavController()
        return NavHost(
            navController = rememberNavController(),
            startDestination = Routes.Main.name
        ){
            composable(Routes.Main.name){
                GreetingPage()
            }
            composable(Routes.Random.name){
                RandomPage()
            }
        }

    }
}

