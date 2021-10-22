package com.stematel.pipi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_mtk1.*

class VideoBing1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_mtk1)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val onlinevideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2FBing%2FBAHASA%20INGGRIS%20KELAS%206%20--%20SOME%20ACTIVITIES%20ON%20HOLIDAY_3.mp4?alt=media&token=deef40c9-02af-457e-b41c-71b172801e4b")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlinevideo)
        videoView.requestFocus()
        videoView.start()


    }

}