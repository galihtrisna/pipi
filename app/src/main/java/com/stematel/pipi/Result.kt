package com.stematel.pipi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        hideSystemUI()

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val userName=currentUser?.displayName
        var score= intent.getStringExtra(setDataSoalIpa.score)?.toInt()
        var totalQuestion= intent.getStringExtra("total size")?.toInt()
        val skor = score!!.toInt()
        val jumlahsoal = totalQuestion!!.toInt()
        val nilai = 100/jumlahsoal*skor

        congo.text="Selamat ${userName} !!"
        Score.text="${nilai}"
        button.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }

    }
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.navigationBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}
