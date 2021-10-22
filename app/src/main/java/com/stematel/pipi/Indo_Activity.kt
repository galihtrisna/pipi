package com.stematel.pipi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class Indo_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bindo_bab)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val bab_1_mtk = findViewById<CardView>(R.id.mtk_bab_1)

        val back = findViewById<ImageButton>(R.id.back)

        back.setOnClickListener {
            Intent(this@Indo_Activity,HomeActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(intent)}
        }

        bab_1_mtk.setOnClickListener {
            Intent(this@Indo_Activity,MateriIndoBab1Activity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it) }
        }

    }
    override fun onBackPressed() {
        Intent(this@Indo_Activity,HomeActivity::class.java).also { intent ->
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            startActivity(intent)}
    }
}