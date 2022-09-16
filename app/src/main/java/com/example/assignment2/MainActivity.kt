package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var sizes = arrayListOf<String>()
    var flavors = arrayListOf<String>()

    var result: String = " "
    var price = 0.00
    var size = 0.00
    var toppings = 0.00
    var fudge = 0.15

    var orderHistory = ArrayList<OrderHistory>();


    fun updateUI() {
        price = size + toppings + fudge
        result = String.format("%.2f", price)

        price_textView.text = "$$result"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //These lines hook up my buttons
        theWorks_button.setOnClickListener {

            size_spinner.setSelection(2);
            seekBar.progress = 3
            size = 4.99
            toppings = 1.5
            peanuts_checkBox.isChecked = true
            almonds_checkBox.isChecked = true
            strawberries_checkBox.isChecked = true
            brownies_checkBox.isChecked = true
            marshmallows_checkBox.isChecked = true
            gummyBears_checkBox.isChecked = true
            oreos_checkBox.isChecked = true
            emeniem_checkBox.isChecked = true
            println( "Size" + size )
            println( "Toppings" +toppings )
            println( "Fudge" + fudge )
            updateUI()
            Toast.makeText(this@MainActivity, "You have chosen The Works Sundae! Yay! ", Toast.LENGTH_SHORT).show()

        }


        reset_button.setOnClickListener {

            flavors_spinner.setSelection(0);
            size_spinner.setSelection(0);
            seekBar.progress = 1
            size = 2.99
            toppings = 0.00

            peanuts_checkBox.isChecked = false
            almonds_checkBox.isChecked = false
            strawberries_checkBox.isChecked = false
            brownies_checkBox.isChecked = false
            marshmallows_checkBox.isChecked = false
            gummyBears_checkBox.isChecked = false
            oreos_checkBox.isChecked = false
            emeniem_checkBox.isChecked = false

            updateUI();

            Toast.makeText(this@MainActivity, "The order has been reset.", Toast.LENGTH_SHORT).show()


        }

        // ORDER BUTTON
        order_button.setOnClickListener {

            var currentOrder = OrderHistory(Date(), size_spinner.selectedItem.toString(), flavors_spinner.selectedItem.toString(), price)
            orderHistory.add( currentOrder )

            flavors_spinner.setSelection(0);
            size_spinner.setSelection(0);
            seekBar.progress = 1
            size = 2.99
            toppings = 0.00

            peanuts_checkBox.isChecked = false
            almonds_checkBox.isChecked = false
            strawberries_checkBox.isChecked = false
            brownies_checkBox.isChecked = false
            marshmallows_checkBox.isChecked = false
            gummyBears_checkBox.isChecked = false
            oreos_checkBox.isChecked = false
            emeniem_checkBox.isChecked = false

            updateUI()
            Toast.makeText(this@MainActivity, "Your sundae is on the way. Enjoy! ", Toast.LENGTH_SHORT).show()


        }

        //This switch case is for the additional toppings

        peanuts_checkBox.setOnClickListener() {
            if (peanuts_checkBox.isChecked) {
                toppings += 0.15
            } else {
                toppings -= 0.15
            }
            updateUI()
        }
        almonds_checkBox.setOnClickListener() {
            if (almonds_checkBox.isChecked) {
                toppings += 0.15
            } else {
                toppings -= 0.15

            }
            updateUI()
        }

        strawberries_checkBox.setOnClickListener() {
            if (strawberries_checkBox.isChecked) {
                toppings += 0.20
            } else {
                toppings -= 0.20

            }
            updateUI()
        }

        brownies_checkBox.setOnClickListener() {
            if (brownies_checkBox.isChecked) {
                toppings += 0.20
            } else {
                toppings -= 0.20

            }
            updateUI()
        }

        marshmallows_checkBox.setOnClickListener() {
            if (marshmallows_checkBox.isChecked) {
                toppings += 0.15
            } else {
                toppings -= 0.15

            }
            updateUI()
        }

        gummyBears_checkBox.setOnClickListener() {
            if (gummyBears_checkBox.isChecked) {
                toppings += 0.20
            } else {
                toppings -= 0.20

            }
            updateUI()
        }

        oreos_checkBox.setOnClickListener() {
            if (oreos_checkBox.isChecked) {
                toppings += 0.20
            } else {
                toppings -= 0.20

            }
            updateUI()
        }

        emeniem_checkBox.setOnClickListener() {
            if (emeniem_checkBox.isChecked) {
                toppings += 0.25
            } else {
                toppings -= 0.25

            }
            updateUI()
        }

        //These lines set the code for the adapter of the size_spinner
        sizes = arrayListOf("Small", "Medium", "Large")
        var sizesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sizes)
        size_spinner.adapter = sizesAdapter
        size_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "Size Set ", Toast.LENGTH_SHORT).show()

                //This if statement is for the size

                if (size_spinner.selectedItemPosition == 0) {
                    //this means the size is small
                    size = 2.99
                } else if (size_spinner.selectedItemPosition == 1) {
                    //this means the size is medium
                    size = 3.99
                } else if (size_spinner.selectedItemPosition == 2) {
                    //this means the size is large
                    size = 4.99
                } else {
                    size = 0.00
                }

                updateUI()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        //These lines set the code for the adapter of the flavors_spinner
        flavors = arrayListOf("Vanilla", "Chocolate", "Strawberry")
        var flavorsAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, flavors)
        flavors_spinner.adapter = flavorsAdapter

        flavors_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "Flavor Set ", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        //This part of the code takes care of the seekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(
                    this@MainActivity,
                    "Hot Fudge changed to: $progress oz",
                    Toast.LENGTH_SHORT
                ).show()
                oz_textView.text = "$progress oz"

                //This if statement is for the Hot Fudge
                if (seekBar?.progress == 1) {
                    //This means there is 1 oz of fudge
                    fudge = 0.15
                } else if (seekBar?.progress == 2) {
                    //This means there is 2 oz of fudge
                    fudge = 0.25
                } else if (seekBar?.progress == 3) {
                    //This means there is 3 oz of fudge
                    fudge = 0.30
                } else {
                    fudge = 0.0
                }

                updateUI()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }


    //This function is activated whenever the a checkbox is checked - letting the user know they chose a topping
    fun handleCheckBox(view: View) {
        val checkBoxID: Int = view.id
        val checkBox: CheckBox = view as CheckBox

        when (checkBoxID) {
            R.id.peanuts_checkBox -> {
                Toast.makeText(this@MainActivity, "Peanuts Checked", Toast.LENGTH_SHORT).show()
            }
            R.id.almonds_checkBox -> {
                Toast.makeText(this@MainActivity, "Almonds Checked", Toast.LENGTH_SHORT).show()
            }
            R.id.strawberries_checkBox -> {
                Toast.makeText(this@MainActivity, "Strawberries Checked", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.brownies_checkBox -> {
                Toast.makeText(this@MainActivity, "Brownies Checked", Toast.LENGTH_SHORT).show()
            }
            R.id.marshmallows_checkBox -> {
                Toast.makeText(this@MainActivity, "Marshmallows Checked", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.gummyBears_checkBox -> {
                Toast.makeText(this@MainActivity, "Gummy Bears Checked", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.oreos_checkBox -> {
                Toast.makeText(this@MainActivity, "Oreos Checked", Toast.LENGTH_SHORT).show()
            }

            R.id.emeniem_checkBox -> {
                Toast.makeText(this@MainActivity, "M&Ms Checked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // give us the 3 little dots on our screen for the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // show the menu we created with about and order
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        return true;
    }


    // when we click one of the menu options to do something this becomes activated
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val orderIntent = Intent(this@MainActivity, OrdersActivity::class.java)
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)

        // if user clicks orders, go to the orders page
        if (item.itemId == R.id.menu_orders_id) {


            // "about" is the secret word so we can see the orderHistory
            orderIntent.putExtra("orderHistory", orderHistory);

            // blast off ... to order page
            startActivity(orderIntent)

            // if user clicks about, go to the about page
        } else if (item.itemId == R.id.menu_about_id) {

           var string = "ABOUT";

            // "about" is the secret word so we can see the string
            aboutIntent.putExtra("about", string);

            // blast off ... to about page
            startActivity(aboutIntent)

        }


        return true;
    }

}


