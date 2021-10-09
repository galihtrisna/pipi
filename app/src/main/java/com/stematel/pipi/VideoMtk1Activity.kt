package com.stematel.pipi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_mtk1.*

class VideoMtk1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_mtk1)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val onlinevideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/avc_5314777_final.mp4?alt=media&token=95af2b31-8949-46d6-92dc-a66552e20aa6")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlinevideo)
        videoView.requestFocus()
        videoView.start()


    }

}