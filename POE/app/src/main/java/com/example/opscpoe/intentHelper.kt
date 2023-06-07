package com.example.opscpoe

import android.content.Context
import android.content.Intent
import java.io.Serializable

fun openRegisterIntent(context: Context, activityToOpen: Class<*>)
{
    val intent = Intent(context, activityToOpen)
    context.startActivity(intent)
}

fun openMenuIntent(context: Context, username: String, activityToOpen: Class<*>)
{
    val intent = Intent(context, activityToOpen)
    intent.putExtra("username", username)
    context.startActivity(intent)
}

fun openLoginIntent(context: Context, activityToOpen: Class<*>)
{
    val intent = Intent(context, activityToOpen)
    context.startActivity(intent)
}

fun openLoginFromRegisterIntent(context:Context, username: String, password: String, fullName: String, dob: String, celly:String, activityToOpen: Class<*>)
{
    val intent = Intent(context, activityToOpen)
    intent.putExtra("username", username)
    intent.putExtra("password", password)
    intent.putExtra("fullName", fullName)
    intent.putExtra("dob", dob)
    intent.putExtra("celly",celly)
    context.startActivity(intent)
}

fun openMainApplicationIntent(context: Context, tasks: ArrayList<Task>, categories: ArrayList<String>, maxGoal: String, minGoal: String, activityToOpen: Class<*>)
{
    val intent = Intent(context, activityToOpen)
    intent.putExtra("TASKS_LIST_EXTRA", tasks)
    intent.putExtra("CATEGORIES_LIST_EXTRA", categories)
    intent.putExtra("maxGoal", maxGoal)
    intent.putExtra("minGoal", minGoal)
    context.startActivity(intent)
}