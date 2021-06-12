package com.example.offloaing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        video1.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            i.putExtra("video","https://cdn.videvo.net/videvo_files/video/free/2019-03/small_watermarked/181015_07a_Hollywood_UHD_004_preview.webm")
            startActivity(i)
        }
        video2.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            i.putExtra("video","https://cdn.videvo.net/videvo_files/video/premium/video0306/small_watermarked/601-2_601-6821_preview.webm")
            startActivity(i)
        }
        video3.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
             i.putExtra("video","https://cdn.videvo.net/videvo_files/video/premium/video0034/small_watermarked/635_635-0035_preview.webm")
            startActivity(i)
        }
        video4.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            i.putExtra("video","https://cdn.videvo.net/videvo_files/video/free/2016-08/small_watermarked/160410_25_Los_Angeles_Skyline_19_1080p_preview.webm")
            startActivity(i)
        }
    }
}