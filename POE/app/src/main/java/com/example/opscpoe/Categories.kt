package com.example.opscpoe

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.opscpoe.databinding.ActivityCategoriesBinding

@Suppress("DEPRECATION")
class Categories : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ******************************* CLASS VARIABLES *****************************************

        // Holds the category values passed over from the Main Menu activity
        var categories = arrayListOf<String>()

        // Holds the values passed over from the Task activity
        var tasks = arrayListOf<Task>()

        // Receives the categories arrayList values from the Categories intent (From IntentHelper)
        val receivedCategoriesList = intent.getStringArrayListExtra("CATEGORIES_LIST_EXTRA")

        // Receives the tasks arrayList values from the Task intent (From IntentHelper)
        var receivedTasksList = intent.getSerializableExtra("TASKS_LIST_EXTRA")

        // Receives the maxGoal string value from the Menu (From IntentHelper)
        var maxGoal = intent.getSerializableExtra("maxGoal") as String

        // Receives the minGoal string value from the Menu (From IntentHelper)
        var minGoal = intent.getSerializableExtra("minGoal") as String

        // *****************************************************************************************

        // Adding values from the main menu into the Category array and spinner
        if (receivedCategoriesList != null) {
            for (item in receivedCategoriesList) {
                categories.add(item)
            }

            // Updating the values shown in the spinner to display all the categories
            val adap = ArrayAdapter(this, R.layout.simple_spinner_item, categories)
            adap.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            with(binding.spinCategory)
            {
                adapter = adap
                setSelection(0,false)
                onItemSelectedListener = this@Categories
                prompt = "Select Category"
            }
        }

        // Adding values from the Task intent into the Tasks array
        if (receivedTasksList != null)
        {
            tasks = receivedTasksList as ArrayList<Task>
        }

        // Runs when the ADD CATEGORY button is clicked
        binding.btnAdd.setOnClickListener()
        {
            // Retrieving and storing the value entered in the text box
            var categoryName = binding.txtCategoryName.text.toString().trim()

            if(categoryName.isNotEmpty())
            {
                // Adding the text entered into the Categories array
                categories.add(categoryName)

                // Updating the values shown in the spinner to display the newly entered value
                val adap = ArrayAdapter(this, R.layout.simple_spinner_item, categories)
                adap.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                with(binding.spinCategory)
                {
                    adapter = adap
                    setSelection(0,false)
                    onItemSelectedListener = this@Categories
                    prompt = "Select Category"
                }
                // Clearing the text value
                binding.txtCategoryName.text = null
            }
            else
            {
                // Error message if the text box value is empty
                Toast.makeText(this, "Please enter a value before continuing", Toast.LENGTH_SHORT).show()
            }
        }

        // Runs when the SEARCH CATEGORY button is clicked
        binding.btnSearch.setOnClickListener()
        {
            val categoryChosen = binding.spinCategory.selectedItem
            var results = binding.lblResults

            if (categoryChosen != null)
            {
                if (tasks != null)
                {
                    // Displaying tasks dedicated to the chosen category
                    val stringBuilder = StringBuilder()

                    for (item in tasks)
                    {
                        if(item.TaskCategory.equals(categoryChosen))
                        {
                            // Appending the task name to the string builder
                            stringBuilder.append(item.TaskName)
                            // Adding a line break after each item
                            stringBuilder.append("\n")
                        }
                    }

                    // Saving all the results that matched the category into a single variable
                    val allContents = stringBuilder.toString()

                    if(allContents.isNotEmpty())
                    {
                        // Displaying the results in a TextView
                        results.text = allContents
                    }
                    else
                    {
                        // Error message if there are no tasks dedicated to the chosen category
                        Toast.makeText(this, "There are no tasks under this category", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    // Error message if there are no tasks created
                    Toast.makeText(this, "Please create a task before continuing", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                // Error message if no item is selected
                Toast.makeText(this, "Please select an item before continuing", Toast.LENGTH_SHORT).show()
            }
        }

        // Runs when the BACK BUTTON (ARROW) is clicked
        binding.backButton.setOnClickListener()
        {
            // Intent to take the user back to the Main Menu (From IntentHelper)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Menu::class.java)
        }
    }

    //**********************************************************************************************

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    //**********************************************************************************************

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}