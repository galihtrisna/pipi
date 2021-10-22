package com.stematel.pipi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_mtk1.*

class VideoIpa1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_mtk1)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val onlinevideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2FIPA%2FIPA%20Kelas%206%20--%20MENGENAL%20TENTANG%20MAGNET.mp4?alt=media&token=96365f54-e0e5-4731-9847-a6b4ac411d83")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlinevideo)
        videoView.requestFocus()
        videoView.start()


    }

}