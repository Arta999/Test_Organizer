package ru.arta999.lessons_tgy_18_second_part

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FourthFragment : Fragment() {

//    private lateinit var activityBrowser: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {



/*        activityBrowser = findViewById(R.id.activity_browser)
        activityBrowser.setOnClickListener {
            val Link = Uri.parse("https://www.gismeteo.ru/weather-nadym-11966/")
            val openBrowserIntent = Intent(Intent.ACTION_VIEW, Link)
            val chooser = Intent.createChooser(openBrowserIntent, "Browser")
            startActivity(chooser)
        } */



        val view= inflater.inflate(R.layout.fragment_fourth, container, false)

        return view
    }

}