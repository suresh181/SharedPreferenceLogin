package com.example.sharedpreferenceslogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferenceslogin.Adapter.MyGridAdapter
import com.example.sharedpreferenceslogin.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    val title = arrayOf(
        "MS Dhoni",
        "Suresh Raina",
        "Moeen Ali",
        "Ravindra Jadeja",
        "Dwayne Bravo",
        "C Hari Nishaanth",
        "Sam Curran",
        "Robin Uthappa",
        "Ruturaj Gaikwad",
        "Ambati Rayudu",
        "Narayan Jagadeesan"
    )

    val imageId = arrayOf(
        R.drawable.msdhoni, R.drawable.suresh, R.drawable.alic, R.drawable.jadc,
        R.drawable.cbravo, R.drawable.hari, R.drawable.samc, R.drawable.uthappa, R.drawable.rutuc,
        R.drawable.ambati, R.drawable.narayanac
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val gridAdapter = MyGridAdapter(this,title,imageId)
        binding.grid.adapter = gridAdapter

    }
}