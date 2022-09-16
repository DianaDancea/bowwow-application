package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_orders.*

class OrdersActivity : AppCompatActivity() {
    var orderHistory = ArrayList<OrderHistory>();
    var orderHistoryString = ArrayList<String>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)


        // changes title in the blue bar
        supportActionBar!!.title = "Order History"

        val orderIntent = intent;

        orderHistory = orderIntent.getSerializableExtra("orderHistory") as ArrayList<OrderHistory>;

        for( order in orderHistory ){

            orderHistoryString.add(order.toString());
        }

        var adapter = ArrayAdapter<String>(this@OrdersActivity, android.R.layout.simple_list_item_1, orderHistoryString )

        orders_listView.adapter = adapter;


    }
}