package ru.arta999.lessons_tgy_18_second_part

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView
    lateinit var activityBrowser: Button
    private val REQUEST_TAKE_PHOTO = 1
    private lateinit var imageView: ImageView
    lateinit var activityImage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)
        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.fragment_1 -> {
                    fragment = FirstFragment()                }
                R.id.fragment_2 -> {
                    fragment = SecondFragment()                }
                R.id.fragment_3 -> {
                    fragment = ThirdFragment()                }
                R.id.fragment_4 -> {
                    fragment = FourthFragment()                }
                R.id.fragment_5 -> {
                    fragment = FifthFragment()                }
           }
            replaceFragment(fragment!!)
            true
        }
        activityBrowser = findViewById(R.id.activity_browser)
        activityBrowser.setOnClickListener {
            val Link = Uri.parse("https://www.gismeteo.ru/weather-nadym-11966/")
            val openBrowserIntent = Intent(Intent.ACTION_VIEW, Link)
            val chooser = Intent.createChooser(openBrowserIntent, "Browser")
            startActivity(chooser)        }




        activityImage = findViewById(R.id.activity_image)
        activityImage.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try { startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
                // Фотка сделана, извлекаем миниатюру картинки
                val thumbnailBitmap = data?.extras?.get("data") as Bitmap
                imageView.setImageBitmap(thumbnailBitmap)
            }



        }

        }
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()    }



}

