package com.example.wallpaper


import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var wallpaperImageView: ImageView
    private lateinit var changeWallpaperButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallpaperImageView = findViewById(R.id.wallpaperImageView)
        changeWallpaperButton = findViewById(R.id.changeWallpaperButton)

        changeWallpaperButton.setOnClickListener {
            loadRandomWallpaper()
        }
    }

    private fun loadRandomWallpaper() {
        // In this example, assume you have a list of wallpaper images stored in the "drawable" directory
        val wallpaperIds = arrayOf(
            R.drawable.wallpaper1,
            R.drawable.wallpaper2,
            R.drawable.wallpaper3,
            R.drawable.wallpaper5,
            R.drawable.wallpaper6,
            R.drawable.wallpaper7,
            R.drawable.wallpaper8,
            R.drawable.wallpaper9,
            R.drawable.wallpaper10,
           



        )

        val randomWallpaperId = wallpaperIds.random()

        // Load the wallpaper image into the ImageView
        wallpaperImageView.setImageResource(randomWallpaperId)

        // Set the wallpaper image as the device wallpaper
        CoroutineScope(Dispatchers.Main).launch {
            val wallpaperManager = WallpaperManager.getInstance(applicationContext)
            withContext(Dispatchers.IO) {
                val bitmap = BitmapFactory.decodeResource(resources, randomWallpaperId)
                wallpaperManager.setBitmap(bitmap)
            }
        }
    }
}



