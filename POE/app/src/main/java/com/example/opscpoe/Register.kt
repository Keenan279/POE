package com.example.opscpoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.opscpoe.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Runs when the REGISTER BUTTON is clicked
        binding.btnRegister.setOnClickListener()
        {
            // Saving all the users details for when they log in
            val username = binding.txtUsername.text.toString().trim();
            val fullName = binding.txtFullname.text.toString().trim();
            val password = binding.txtPassword.text.toString().trim();
            val confirmPassword = binding.txtConfirmPassword.text.toString().trim();
            val dob = binding.txtDOB.text.toString().trim();
            val cellNumber = binding.txtCellNumber.text.toString().trim();

            if(username.isNotEmpty() && fullName.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() &&
               dob.isNotEmpty() && cellNumber.isNotEmpty())
            {
                if(password != confirmPassword)
                {
                    // Error message if the passwords do not match
                    Toast.makeText(this, "The two passwords do not match", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    // Intent to take the user to the Login activity (From IntentHelperClass)
                    openLoginFromRegisterIntent(this, username, password, fullName, dob, cellNumber ,MainActivity::class.java);
                }
            }
            else
            {
                // Error message if the text boxes are empty
                Toast.makeText(this, "Please fill in all the values before continuing", Toast.LENGTH_SHORT).show()
            }
        }

        // Runs when the CLEAR BUTTON is clicked
        binding.btnClear.setOnClickListener()
        {
            // Clearing all the text box values
            binding.txtUsername.text = null
            binding.txtFullname.text = null
            binding.txtPassword.text = null
            binding.txtConfirmPassword.text = null
            binding.txtDOB.text = null
            binding.txtCellNumber.text = null
        }


        binding.imgBackButton.setOnClickListener(){
        openLoginIntent(this, MainActivity::class.java)

        }
    }
}