package com.stematel.pipi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_mtk1.*

class VideoBindo1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_mtk1)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val onlinevideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2FBindo%2FPengertian%20dan%20Unsur-unsur%20Puisi%20Materi%20Pembelajaran%20Kelas%20VIII%20Bahasa%20Indonesia.mp4?alt=media&token=7ce258e7-f506-4ac3-8a57-edec26b4a19a")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlinevideo)
        videoView.requestFocus()
        videoView.start()


    }

}