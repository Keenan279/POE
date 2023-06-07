package com.example.opscpoe

import android.graphics.Bitmap
import java.io.Serializable
import java.util.Date

public class User
{
    var username: String
    var password: String
    var fullName: String
    var dob: String
    var celly:String

    // Class constructor
    constructor(usernameIn: String, passwordIn: String, fullNameIn: String, dobIn: String, CellyIn:String){
        this.username = usernameIn;
        this.password = passwordIn;
        this.fullName = fullNameIn;
        this.dob = dobIn;
        this.celly = CellyIn;
    }
}