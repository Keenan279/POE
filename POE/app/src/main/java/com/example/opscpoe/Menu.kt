package com.example.opscpoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Toast
import com.example.opscpoe.databinding.ActivityMenuBinding

@Suppress("DEPRECATION")
class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ******************************* CLASS VARIABLES *****************************************

        // Holds the values passed over from the Category activity
        var categories = arrayListOf<String>()

        // Holds the values passed over from the Task activity
        var tasks = arrayListOf<Task>()

        // Strings to hold the min and max goal values
        var maxGoal : String = ""
        var minGoal : String = ""

        // Receives the categories arrayList values from the Categories intent (From IntentHelper)
        val receivedCategoriesList = intent.getStringArrayListExtra("CATEGORIES_LIST_EXTRA")

        // Receives the tasks arrayList values from the Task intent (From IntentHelper)
        var receivedTasksList = arrayListOf<Task>()

        // Receives the maxGoal string value from the Menu (From IntentHelper)
        var receivedMaxGoal = intent.getSerializableExtra("maxGoal")

        // Receives the minGoal string value from the Menu (From IntentHelper)
        var receivedMinGoal = intent.getSerializableExtra("minGoal")

        // *****************************************************************************************

        // Obtaining the task arrayList values from the Task intent
        if (intent.getSerializableExtra("TASKS_LIST_EXTRA")!=null)
        {
            receivedTasksList = intent.getSerializableExtra("TASKS_LIST_EXTRA") as ArrayList<Task>
        }

        // Adding values from the Category intent into the Categories array
        if (receivedCategoriesList != null) {
            for (item in receivedCategoriesList) {
                categories.add(item)
            }
        }

        // Adding values from the Task intent into the Tasks array
        if (receivedTasksList != null) {
            for (item in receivedTasksList) {
                tasks.add(item)
            }
        }

        // Checks if the maxGoal and minGoal values are set
        if (receivedMaxGoal != null && receivedMinGoal != null)
        {
            maxGoal = receivedMaxGoal as String
            minGoal = receivedMinGoal as String
            binding.lblMaximum.text = "Maximum Hours To Work: " + maxGoal
            binding.lblMinimum.text = "Minimum Hours To Work: " + minGoal
        }

        // Runs when the CATEGORIES BUTTON is clicked
        binding.btnCategory.setOnClickListener()
        {
            // Intent to take the user to the Category activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Categories::class.java)
        }

        // Runs when the CATEGORIES IMAGE is clicked
        binding.imgCategory.setOnClickListener()
        {
            // Intent to take the user to the Category activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Categories::class.java)
        }

        // Runs when the TASKS BUTTON is clicked
        binding.btnTasks.setOnClickListener()
        {
            // Intent to take the user to the DisplayTasks activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, DisplayTasks::class.java)
        }

        // Runs when the TASKS IMAGE is clicked
        binding.imgTasks.setOnClickListener()
        {
            // Intent to take the user to the DisplayTasks activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, DisplayTasks::class.java)
        }

        // Runs when the CALENDER BUTTON is clicked
        binding.btnCalender.setOnClickListener()
        {
            // Intent to take the user to the Calender activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Calendar::class.java)
        }

        // Runs when the CALENDER IMAGE is clicked
        binding.imgCalender.setOnClickListener()
        {
            // Intent to take the user to the Calender activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Calendar::class.java)
        }

        // Runs when the SUBMIT GOALS BUTTON is clicked
        binding.btnSubmitGoal.setOnClickListener()
        {
            // Retrieving the values from the text boxes
            var maximumGoal = binding.txtMaximumGoal.text.toString().trim()
            var minimumGoal = binding.txtMinimumGoal.text.toString().trim()

            if(maximumGoal.isNotEmpty() && minimumGoal.isNotEmpty())
            {
                // Saving the values for the user
                maxGoal = maximumGoal
                minGoal = minimumGoal

                binding.lblMaximum.text = "Maximum Hours To Work: " + maxGoal
                binding.lblMinimum.text = "Minimum Hours To Work: " + minGoal

                // Clearing the text boxes values
                binding.txtMaximumGoal.text = null
                binding.txtMinimumGoal.text = null
                Toast.makeText(this, "Your Daily Goals Have Been Set! Good luck", Toast.LENGTH_SHORT).show()
            }
            else
            {
                // Error message if any text box has no value
                Toast.makeText(this, "Please fill in all the details before continuing", Toast.LENGTH_SHORT).show()
            }
        }

        // Runs when the LOGOUT BUTTON is clicked
        binding.btnLogOut.setOnClickListener()
        {
            // Intent to take the user to the MainActivity (Login Page) (From IntentHelper)
            openLoginIntent(this, MainActivity::class.java)
            Toast.makeText(this, "Log Out Successful", Toast.LENGTH_SHORT).show()
        }
    }
}