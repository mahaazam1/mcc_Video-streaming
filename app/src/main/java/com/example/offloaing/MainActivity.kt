package com.example.offloaing

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.offloaing.R
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var player: SimpleExoPlayer? = null
    var videoURl: String? = ""
    var playWhenReady = true
    var playBackPosition = 0
    var currentkindew = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoURl = intent.getStringExtra("video")
    }

    private fun initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this)
        video_view.player = player
        var uri = Uri.parse(videoURl)
        val dataSource: DataSource.Factory =
            DefaultDataSourceFactory(this, "exoplayer-codelab")
        var mediaSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri)

        player!!.playWhenReady = playWhenReady
        player!!.seekTo(currentkindew, playBackPosition.toLong())
        player!!.prepare(mediaSource, false, false)
    }

    private fun releaseVideo() {
        if (player != null) {
            playWhenReady = player!!.playWhenReady
            playBackPosition = player!!.currentPosition.toInt()
            currentkindew = player!!.currentWindowIndex
            player!!.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }

    override fun onResume() {
        super.onResume()
        if (player != null) {
            initVideo()
        }
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }

    override fun onStop() {
        super.onStop()
        releaseVideo()
    }





}