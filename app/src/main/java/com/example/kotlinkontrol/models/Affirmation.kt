package com.example.kotlinkontrol.models
import android.content.Context
data class Affirmation(val rId:Int) {


    fun text(context:Context):String{
        return  context.getString(rId)   }
}