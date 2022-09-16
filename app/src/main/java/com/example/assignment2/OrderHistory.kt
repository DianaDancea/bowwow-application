package com.example.assignment2

import java.util.*
import java.io.Serializable
import java.time.LocalDateTime

class OrderHistory (var date: Date, var size: String, var flavor: String, var cost: Double):Serializable{
     override fun toString( ): String {
        return "Date: $date \n Size: $size \n Flavor: $flavor \n Cost: $cost"
    }
}
