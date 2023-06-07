package com.example.opscpoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.opscpoe.databinding.ActivityCalendarBinding

@Suppress("DEPRECATION")
class Calendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ******************************* CLASS VARIABLES *****************************************

        // Holds the values passed over from the Task activity
        var tasks = arrayListOf<Task>()

        // Holds the values passed over from the Category activity
        var categories = arrayListOf<String>()

        // Receives the tasks arrayList values from the Task intent (From IntentHelper)
        var receivedTasksList = intent.getSerializableExtra("TASKS_LIST_EXTRA")

        // Receives the categories arrayList values from the Categories intent (From IntentHelper)
        val receivedCategoriesList = intent.getStringArrayListExtra("CATEGORIES_LIST_EXTRA")

        // Receives the maxGoal string value from the Menu (From IntentHelper)
        var maxGoal = intent.getSerializableExtra("maxGoal") as String

        // Receives the minGoal string value from the Menu (From IntentHelper)
        var minGoal = intent.getSerializableExtra("minGoal") as String

        // *****************************************************************************************

        // Creating an arrayList of text views to store the task information (For the single calender)
        var singleCalenderTasks = arrayListOf<TextView>()
        var txtTask1 = findViewById<TextView>(R.id.txtTask1)
        var txtTask2 = findViewById<TextView>(R.id.txtTask2)
        var txtTask3 = findViewById<TextView>(R.id.txtTask3)
        var txtTask4 = findViewById<TextView>(R.id.txtTask4)
        var txtTask5 = findViewById<TextView>(R.id.txtTask5)

        // Adding the text views to the arrayList
        singleCalenderTasks.add(txtTask1)
        singleCalenderTasks.add(txtTask2)
        singleCalenderTasks.add(txtTask3)
        singleCalenderTasks.add(txtTask4)
        singleCalenderTasks.add(txtTask5)

        // Creating an arrayList of text views to store the task information (For the two calenders)
        var doubleCalenderTasks = arrayListOf<TextView>()
        var txtTask6 = findViewById<TextView>(R.id.txtTask6)
        var txtTask7 = findViewById<TextView>(R.id.txtTask7)
        var txtTask8 = findViewById<TextView>(R.id.txtTask8)
        var txtTask9 = findViewById<TextView>(R.id.txtTask9)
        var txtTask10 = findViewById<TextView>(R.id.txtTask10)

        // Adding the text views to the arrayList
        doubleCalenderTasks.add(txtTask6)
        doubleCalenderTasks.add(txtTask7)
        doubleCalenderTasks.add(txtTask8)
        doubleCalenderTasks.add(txtTask9)
        doubleCalenderTasks.add(txtTask10)

        // Setting default values for the two calenders
        var calenderDateOne = "01/01/2023"
        var calenderDateTwo = "01/01/2023"

        // Adding values from the Category intent into the Categories array
        if (receivedCategoriesList != null) {
            for (item in receivedCategoriesList) {
                categories.add(item)
            }
        }

        // Adding values from the Task intent into the Tasks array
        if(receivedTasksList != null)
        {
            tasks = receivedTasksList as ArrayList<Task>
        }

        // Runs when the date is changed on the SINGLE CALENDER
        binding.singleCalender.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Clearing the text boxes
            txtTask1.text = ""
            txtTask2.text = ""
            txtTask3.text = ""
            txtTask4.text = ""
            txtTask5.text = ""

            // Setting the variables from the calender to be used for formatting
            var stringDay = "01"
            var stringMonth = "01"
            var stringYear: String
            var fullDate = "01/01/2023"

            if (dayOfMonth < 10)
            {
                stringDay = "0" + dayOfMonth.toString()
            }
            else if (dayOfMonth >= 10)
            {
                stringDay = dayOfMonth.toString()
            }
            if (month < 10)
            {
                stringMonth = "0" + (month + 1).toString()
            } else if (month >= 10)
            {
                stringMonth = (month + 1).toString()
            }
            stringYear = year.toString()

            // Formatting the date
            fullDate = "$stringDay/$stringMonth/$stringYear"

            // Setting a counter for the loop
            var i = 0

            while (i < tasks.size) {
                if (tasks[i].TaskDate.equals(fullDate)) {
                    if (txtTask1.text.isEmpty())
                    {
                        singleCalenderTasks[0].text = (tasks[i].TaskName)
                    }
                    else if (txtTask2.text.isEmpty())
                    {
                        singleCalenderTasks[1].text = (tasks[i].TaskName)
                    }
                    else if (txtTask3.text.isEmpty())
                    {
                        singleCalenderTasks[2].text = (tasks[i].TaskName)
                    }
                    else if (txtTask4.text.isEmpty())
                    {
                        singleCalenderTasks[3].text = (tasks[i].TaskName)
                    }
                    else if (txtTask5.text.isEmpty())
                    {
                        singleCalenderTasks[4].text = (tasks[i].TaskName)
                    }
                }
                i++
            }
        }

        // Runs when the date is changed on the FIRST DOUBLE CALENDER
        binding.doubleCalenderOne.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Setting the variables from the calender to be used for formatting
            var stringDay = "01"
            var stringMonth = "01"
            var stringYear: String

            if (dayOfMonth < 10)
            {
                stringDay = "0" + dayOfMonth.toString()
            }
            else if (dayOfMonth >= 10)
            {
                stringDay = dayOfMonth.toString()
            }
            if (month < 10) {
                stringMonth = "0" + (month + 1).toString()
            }
            else if (month >= 10)
            {
                stringMonth = (month + 1).toString()
            }
            stringYear = year.toString()

            // Formatting the date
            calenderDateOne = "$stringDay/$stringMonth/$stringYear"
        }

        // Runs when the date is changed on the SECOND DOUBLE CALENDER
        binding.doubleCalenderTwo.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Setting the variables from the calender to be used for formatting
            var stringDay = "01"
            var stringMonth = "01"
            var stringYear: String

            if (dayOfMonth < 10)
            {
                stringDay = "0" + dayOfMonth.toString()
            }
            else if (dayOfMonth >= 10)
            {
                stringDay = dayOfMonth.toString()
            }
            if (month < 10)
            {
                stringMonth = "0" + (month + 1).toString()
            }
            else if (month >= 10)
            {
                stringMonth = (month + 1).toString()
            }
            stringYear = year.toString()

            // Formatting the date
            calenderDateTwo = "$stringDay/$stringMonth/$stringYear"
        }

        // Runs when the SEARCH BUTTON is clicked
        binding.btnTwoCalendersSearch.setOnClickListener()
        {
            if (calenderDateOne != calenderDateTwo) {
                var i = 0
                while (i < tasks.size) {
                    val task = tasks[i]
                    if (task.TaskDate > calenderDateOne && task.TaskDate < calenderDateTwo) {
                        if (i < 5 && txtTask6.text.isEmpty()) {
                            doubleCalenderTasks[i].text = task.TaskName
                        }
                        if (i < 6 && txtTask7.text.isEmpty()) {
                            doubleCalenderTasks[i].text = task.TaskName
                        }
                        if (i < 7 && txtTask8.text.isEmpty()) {
                            doubleCalenderTasks[i].text = task.TaskName
                        }
                        if (i < 8 && txtTask9.text.isEmpty()) {
                            doubleCalenderTasks[i].text = task.TaskName
                        }
                        if (i < 9 && txtTask10.text.isEmpty()) {
                            doubleCalenderTasks[i].text = task.TaskName
                        }
                    }
                    i++
                }
            }
            else
            {
                // Error message if the two dates selected are the same
                Toast.makeText(this, "Please select two different dates", Toast.LENGTH_SHORT).show()
            }
        }

        binding.imgBackButton.setOnClickListener()
        {
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Menu::class.java)
        }
    }
}