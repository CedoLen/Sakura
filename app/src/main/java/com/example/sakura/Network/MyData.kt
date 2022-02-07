package com.example.sakura.Network

import android.text.BoringLayout

data class login(val id:String,val email:String, val nickName:String, val avatar:String, val token:String)
data class feelings(val success:Boolean, val data:List<Data>)
data class quotes(val success:Boolean, val data:List<Data_description>)

data class Data_description(val id:Int, val title:String, val image:String, val description:String)
data class Data(val id:Int, val title:String, val image:String, val position:Int)