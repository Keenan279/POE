package com.example.opscpoe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.opscpoe.databinding.ActivityDisplayTasksBinding

@Suppress("DEPRECATION")
class DisplayTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_tasks)
        val binding = ActivityDisplayTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ******************************* CLASS VARIABLES *****************************************

        // Holds the values passed over from the Category activity
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

        // Creating an arrayList of text boxes to display the information from the Tasks arrayList
        var listTextBoxes = arrayListOf<TextView>()
        var txtTask1 = findViewById<TextView>(R.id.txtTask1)
        var txtTask2 = findViewById<TextView>(R.id.txtTask2)
        var txtTask3 = findViewById<TextView>(R.id.txtTask3)
        var txtTask4 = findViewById<TextView>(R.id.txtTask4)
        var txtTask5 = findViewById<TextView>(R.id.txtTask5)
        var txtTask6 = findViewById<TextView>(R.id.txtTask6)
        var txtTask7 = findViewById<TextView>(R.id.txtTask7)
        var txtTask8 = findViewById<TextView>(R.id.txtTask8)
        var txtTask9 = findViewById<TextView>(R.id.txtTask9)
        var txtTask10 = findViewById<TextView>(R.id.txtTask10)

        // Adding each text box to the text box arrayList
        listTextBoxes.add(txtTask1)
        listTextBoxes.add(txtTask2)
        listTextBoxes.add(txtTask3)
        listTextBoxes.add(txtTask4)
        listTextBoxes.add(txtTask5)
        listTextBoxes.add(txtTask6)
        listTextBoxes.add(txtTask7)
        listTextBoxes.add(txtTask8)
        listTextBoxes.add(txtTask9)
        listTextBoxes.add(txtTask10)

        // Adding values from the Categories intent into the Categories array
        if (receivedCategoriesList!=null)
        {
            categories = receivedCategoriesList as ArrayList<String>
        }

        // Adding values from the Task intent into the Tasks array
        if (receivedTasksList != null)
        {
            tasks = receivedTasksList as ArrayList<Task>
        }

        // Adding all the Task arrayList information to one text box each
        var i = 0
        while (i<tasks.size)
        {
            listTextBoxes[i].text=tasks[i].TaskName
            i++
        }

        // Binds the images to the bitmap held in BitmapHolder
        binding.imgTask1.setImageBitmap(BitmapHolder.getBitmap(0))
        binding.imgTask2.setImageBitmap(BitmapHolder.getBitmap(1))
        binding.imgTask3.setImageBitmap(BitmapHolder.getBitmap(2))
        binding.imgTask4.setImageBitmap(BitmapHolder.getBitmap(3))
        binding.imgTask5.setImageBitmap(BitmapHolder.getBitmap(4))
        binding.imgTask6.setImageBitmap(BitmapHolder.getBitmap(5))
        binding.imgTask7.setImageBitmap(BitmapHolder.getBitmap(6))
        binding.imgTask8.setImageBitmap(BitmapHolder.getBitmap(7))
        binding.imgTask9.setImageBitmap(BitmapHolder.getBitmap(8))
        binding.imgTask10.setImageBitmap(BitmapHolder.getBitmap(9))

        // Runs when the PLUS IMAGE is clicked
        binding.imgAddTasks.setOnClickListener()
        {
            // Intent to take the user to the AddTask activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, AddTask::class.java)
        }

        // Runs when the ADD TASK LABEL is clicked
        binding.lblAddTask.setOnClickListener()
        {
            // Intent to take the user to the AddTask activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, AddTask::class.java)
        }

        // Runs when the BACK BUTTON is clicked
        binding.backButton.setOnClickListener()
        {
            // Intent to take the user to the Menu activity (From IntentHelperClass)
            openMainApplicationIntent(this, tasks, categories, maxGoal, minGoal, Menu::class.java)
        }

        // Runs when the TASK ONE IMAGE is clicked
        binding.imgTask1.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size)
            {
                if (tasks[i].TaskName.equals(binding.txtTask1.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date: " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK ONE LABEL is clicked
        binding.txtTask1.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask1.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK TWO IMAGE is clicked
        binding.imgTask2.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask2.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK TWO LABEL is clicked
        binding.txtTask2.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask2.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK THREE IMAGE is clicked
        binding.imgTask3.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask3.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK THREE LABEL is clicked
        binding.txtTask3.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask3.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK FOUR IMAGE is clicked
        binding.imgTask4.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask4.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK FOUR LABEL is clicked
        binding.txtTask4.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask4.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK FIVE IMAGE is clicked
        binding.imgTask5.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask5.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK FIVE LABEL is clicked
        binding.txtTask5.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask5.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK SIX IMAGE is clicked
        binding.imgTask6.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask6.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK SIX LABEL is clicked
        binding.txtTask6.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask6.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK SEVEN IMAGE is clicked
        binding.imgTask7.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask7.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK SEVEN LABEL is clicked
        binding.txtTask7.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask7.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK EIGHT IMAGE is clicked
        binding.imgTask8.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask8.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }

        }

        // Runs when the TASK EIGHT LABEL is clicked
        binding.txtTask8.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask8.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }

        }

        // Runs when the TASK NINE IMAGE is clicked
        binding.imgTask9.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask9.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }

        }

        // Runs when the TASK NINE LABEL is clicked
        binding.txtTask9.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask9.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }

        }

        // Runs when the TASK TEN IMAGE is clicked
        binding.imgTask10.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask10.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }

        }

        // Runs when the TASK TEN LABEL is clicked
        binding.txtTask10.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask10.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK ONE LINEAR LAYOUT is clicked
        binding.lnrTask1.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask1.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK TWO LINEAR LAYOUT is clicked
        binding.lnrTask2.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask2.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK THREE LINEAR LAYOUT is clicked
        binding.lnrTask3.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask3.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK FOUR LINEAR LAYOUT is clicked
        binding.lnrTask4.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask4.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK FIVE LINEAR LAYOUT is clicked
        binding.lnrTask5.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask5.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK SIX LINEAR LAYOUT is clicked
        binding.lnrTask6.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask6.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK SEVEN LINEAR LAYOUT is clicked
        binding.lnrTask7.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask7.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK EIGHT LINEAR LAYOUT is clicked
        binding.lnrTask8.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask8.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK NINE LINEAR LAYOUT is clicked
        binding.lnrTask9.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask9.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }

        // Runs when the TASK TEN LINEAR LAYOUT is clicked
        binding.lnrTask10.setOnClickListener()
        {
            // Displays the details saved for this task
            var i = 0
            while (i<tasks.size) {
                if (tasks[i].TaskName.equals(binding.txtTask10.text)) {
                    val stringBuilder = StringBuilder()
                    stringBuilder.append("Task name   : " + tasks[i].TaskName)
                    stringBuilder.append("\n")

                    stringBuilder.append("Description : " + tasks[i].TaskDescription)
                    stringBuilder.append("\n")

                    stringBuilder.append("Category    : " + tasks[i].TaskCategory)
                    stringBuilder.append("\n")

                    stringBuilder.append("Date        : " + tasks[i].TaskDate)
                    stringBuilder.append("\n")

                    stringBuilder.append("Start Time  : " + tasks[i].TaskStartTime)
                    stringBuilder.append("\n")

                    stringBuilder.append("End Time    : " + tasks[i].TaskEndTime)

                    val allContents = stringBuilder.toString()
                    binding.txtTaskClicked.text = allContents
                    break
                }
                i++
            }
        }
    }
}