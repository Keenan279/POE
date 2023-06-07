package com.example.opscpoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.opscpoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ******************************* CLASS VARIABLES *****************************************

    // ArrayList to store the username entered in Register activity
    private var usernames = arrayListOf<String>()

    // Arraylist to store the password entered in Register activity
    private var passwords = arrayListOf<String>()

    // Arraylist to store the full name entered in Register activity
    private var fullNames = arrayListOf<String>()

    // Arraylist to store the date of birth entered in Register activity
    private var dobs = arrayListOf<String>()

    // Arraylist to store the cellphone number entered in Register activity
    private var cellNumbers = arrayListOf<String>()

    // *****************************************************************************************

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Gathering the information entered from the Register activity
        var username=intent.getStringExtra("username")
        var password=intent.getStringExtra("password")
        var fullName=intent.getStringExtra("fullName")
        var dob=intent.getStringExtra("dob")

        // Adding the user information captured into their corresponding arrayList
        usernames.add(username.toString())
        passwords.add(password.toString())
        fullNames.add(fullName.toString())
        dobs.add(dob.toString())

        // Runs when the REGISTER BUTTON is clicked
        binding.btnGoToRegister.setOnClickListener()
        {
            // Intent to take the user to the Register activity (From IntentHelper)
            openRegisterIntent(this, Register::class.java)
        }

        // Runs when the LOGIN BUTTON is clicked
        binding.btnLogin.setOnClickListener()
        {
            // Storing the input from the user into variables
            var userNameHere = binding.txtUsername.getText().toString().trim()
            var passwordHere = binding.txtPasswordLogin.getText().toString().trim()

            if(userNameHere.isNotEmpty() && passwordHere.isNotEmpty())
            {
                // Variables for loop checking
                var count=0
                var i=0
                var flag = false

                // Gathering the amount of users stored in the arrayList
                for(username in usernames)
                {
                    count++
                }

                // Checking if the information entered matches the users details
                while(i<count){
                    if (userNameHere.equals(usernames.get(i)) && passwordHere.equals(passwords.get(i)))
                    {
                        flag = true
                        break;
                    }
                    i++
                }

                if(!flag)
                {
                    // Error message if no user was found
                    Toast.makeText(this, "The username or password is incorrect", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    // Intent to take the user to the main menu (From IntentHelper)
                    openMenuIntent(this,userNameHere, Menu::class.java)
                }
            }
            else
            {
                // Error message if no values were entered in the text boxes
                Toast.makeText(this, "Please fill in all details before continuing", Toast.LENGTH_SHORT).show()
            }
        }
    }
}