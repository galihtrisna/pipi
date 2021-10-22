package com.stematel.pipi

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_ips1.*

class VideoIps1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_ips1)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val onlinevideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2FIPS%2FKELAS%206%20__%20TEMA%205%20SUBTEMA%202%20__%20MUATAN%20IPS%20__%20KOMODITAS%20EKSPOR%20IMPOR%20INDONESIA.mp4?alt=media&token=1a03eb35-d65e-4164-92fe-66b86c40dbe5")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlinevideo)
        videoView.requestFocus()
        videoView.start()


    }

}