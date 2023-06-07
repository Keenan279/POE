package com.example.opscpoe

import android.graphics.Bitmap
import java.io.Serializable

class Task :  Serializable{

    // ******************************* CLASS VARIABLES *****************************************

    // String variable to store the tasks name
    var TaskName : String

    // String variable to store the tasks description
    var TaskDescription : String

    // String variable to store the tasks date
    var TaskDate : String

    // String variable to store the tasks starting time
    var TaskStartTime : String

    // String variable to store the tasks ending time
    var TaskEndTime : String

    // String variable to store the tasks category that it belongs to
    var TaskCategory : String

    // Bitmap variable to store the tasks photo
    lateinit var bitmap: Bitmap

    // *****************************************************************************************

    // Class constructor
    constructor(TaskNameIN: String, TaskDescriptionIN : String, TaskDateIN: String, TaskStartTimeIN: String, TaskEndTimeIN : String, TaskCategoryIN: String)
    {
        TaskName = TaskNameIN;
        TaskDescription=TaskDescriptionIN;
        TaskDate=TaskDateIN;
        TaskStartTime=TaskStartTimeIN;
        TaskEndTime=TaskEndTimeIN;
        TaskCategory=TaskCategoryIN;
    }
}