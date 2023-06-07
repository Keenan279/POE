package com.example.opscpoe

import android.R
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import com.example.opscpoe.databinding.ActivityAddTaskBinding
import android.widget.*;
import androidx.activity.result.contract.ActivityResultContracts

@Suppress("DEPRECATION")
class AddTask : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spnTaskCategory!!.setOnItemSelectedListener()

        // ******************************* CLASS VARIABLES *****************************************

        // Holds the values passed over from the Category activity
        var listCategories = arrayListOf<String>()

        // Holds the values passed over from the Task activity
        var listTasks = arrayListOf<Task>()

        // Receives the categories arrayList values from the Categories intent (From IntentHelper)
        val receivedCategoriesList = intent.getStringArrayListExtra("CATEGORIES_LIST_EXTRA")

        // Receives the tasks arrayList values from the Task intent (From IntentHelper)
        var receivedTaskList = intent.getSerializableExtra("TASKS_LIST_EXTRA") as ArrayList<Task>

        // Receives the maxGoal string value from the Menu (From IntentHelper)
        var maxGoal = intent.getSerializableExtra("maxGoal") as String

        // Receives the minGoal string value from the Menu (From IntentHelper)
        var minGoal = intent.getSerializableExtra("minGoal") as String

        // *****************************************************************************************

        // Adding values from the Task intent into the Tasks array
        if (receivedTaskList != null)
        {
            listTasks = receivedTaskList
        }

        // Adding values from the Categories intent into the Categories array
        if (receivedCategoriesList!=null)
        {
            listCategories = receivedCategoriesList
        }

        // Task variables to store the entered task information
        var newTask : Task

        // Adding all the categories made into the spinner, available for selection
        val aa = ArrayAdapter(this, R.layout.simple_spinner_item, listCategories)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(binding.spnTaskCategory)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@AddTask
            prompt = "Select your category"
        }

        // Storing a photo for each task, which can be taken by the user
        val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val bitmap = result.data!!.extras?.get("data") as Bitmap?
                bitmap?.let {
                    BitmapHolder.addBitmap(it)
                    binding.imageView.setImageBitmap(it)
                }
            }
        }

        // Runs when the ADD PICTURE BUTTON is clicked
        binding.btnTakePicture.setOnClickListener()
        {
            // Capturing and storing an image for the task
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            getResult.launch(intent)
        }

        // Runs when the ADD TASK BUTTON is clicked
        binding.btnAddTask.setOnClickListener()
        {
            // Variables to hold the text entered by the user
            var name = binding.txtTaskName.text.toString().trim()
            var description = binding.txtTaskDescription.text.toString().trim()
            var date = binding.txtTaskDate.text.toString().trim()
            var startTime = binding.txtTaskStartTime.text.toString().trim()
            var endTime = binding.txtTaskEndTime.text.toString().trim()
            var category = binding.spnTaskCategory.selectedItem.toString()

            if (name.isNotEmpty() && description.isNotEmpty() && date.isNotEmpty() && startTime.isNotEmpty() &&
                endTime.isNotEmpty() && category != null)
            {
                // Adding the values to the task arrayList
                newTask = Task(name, description, date, startTime, endTime, category)
                listTasks.add(newTask)

                // Confirmation message
                Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show()

                // Clearing the text values
                binding.txtTaskName.text = null
                binding.txtTaskDescription.text = null
                binding.txtTaskDate.text = null
                binding.txtTaskStartTime.text = null
                binding.txtTaskEndTime.text = null
                binding.imageView.setImageBitmap(null)
            }
            else
            {
                // Error message if any text box has no value
                Toast.makeText(this, "Please fill in all the details before continuing", Toast.LENGTH_SHORT).show()
            }
        }

        // Runs when the BACK BUTTON is clicked
        binding.imgBackButton.setOnClickListener()
        {
            // Intent to take the user back to the DisplayTasks activity (From IntentHelper)
            openMainApplicationIntent(this,listTasks, listCategories, maxGoal, minGoal, DisplayTasks::class.java)
        }
    }

    //**********************************************************************************************

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}

    //**********************************************************************************************

    override fun onNothingSelected(p0: AdapterView<*>?) {}
}

//**************************************************************************************************

private fun Spinner.setOnItemSelectedListener() {}