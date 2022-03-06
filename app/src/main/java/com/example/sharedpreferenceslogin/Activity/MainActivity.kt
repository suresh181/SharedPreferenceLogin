package com.example.sharedpreferenceslogin.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedpreferenceslogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var sharedPreference: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var strName: String
    private lateinit var strPassword: String
    private lateinit var strCheckBox: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("username","Anupam")
        editor.putLong("l",100L)
        editor.commit()


        checkSharedPreference()

        binding.btnLogin.setOnClickListener{
            Log.d("Welcome","Second Act clicked")
            if (binding.checkBox.isChecked) {

                editor.putString("Selected", "True")
                editor.apply()
                strName = binding.etName.text.toString()
                editor.putString("email", strName)
                editor.commit()
                strPassword =binding.etPassword.text.toString()
                editor.putString("password", strPassword)
                editor.commit()
            }
            else {
                editor.putString("Selected", "False")
                editor.commit()
                editor.putString("email", "")
                editor.commit()
                editor.putString("password", "")
                editor.commit()
            }

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }

    private fun checkSharedPreference() {
        strCheckBox = sharedPreference.getString("Selected", "False").toString()
        strName = sharedPreference.getString("email", "").toString()
        strPassword = sharedPreference.getString("password", "").toString()
        binding.etName.setText(strName)
        binding.etPassword.setText(strPassword)
        binding.checkBox.isChecked = strCheckBox == "True"
    }
}