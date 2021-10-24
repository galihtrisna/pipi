package com.stematel.pipi

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.bumptech.glide.Glide
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var pressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        hideSystemUI()

        val currentUser = auth.currentUser

        username.text = currentUser?.displayName
        val gambar = findViewById<ImageView>(R.id.gambar_profile)
        Glide.with(this).load(currentUser?.photoUrl).into(gambar)

        gambar.setOnClickListener {
            Intent(this@HomeActivity,ProfileActivity::class.java).also { intent ->
                startActivity(intent) }
        }

        btn_logout.setOnClickListener{
            auth.signOut()
            Intent(this@HomeActivity,LoginActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent) }}
        matematika.setOnClickListener {
            Intent(this@HomeActivity,MatematikaActivity::class.java).also { intent ->
                startActivity(intent) }
        }
        Bindo.setOnClickListener {
            Intent(this@HomeActivity,Indo_Activity::class.java).also { intent ->
                startActivity(intent) }
        }
        Bing.setOnClickListener {
            Intent(this@HomeActivity,Bing_Activity::class.java).also { intent ->
                startActivity(intent) }
        }
        IPA.setOnClickListener {
            Intent(this@HomeActivity,Ipa_Activity::class.java).also { intent ->
                startActivity(intent) }
        }
        IPS.setOnClickListener {
            Intent(this@HomeActivity,Ips_Activity::class.java).also { intent ->
                startActivity(intent) }
        }


        rekomen1.setOnClickListener {
            Intent(this@HomeActivity,VideoIps1Activity::class.java).also { intent ->
                startActivity(intent) }
        }
        rekomen2.setOnClickListener {
            Intent(this@HomeActivity,VideoIpa1Activity::class.java).also { intent ->
                startActivity(intent) }
        }
        rekomen3.setOnClickListener {
            Intent(this@HomeActivity,VideoBindo1Activity::class.java).also { intent ->
                startActivity(intent) }
        }

        val buttonNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        buttonNavigationView.selectedItemId = R.id.menu_home

        buttonNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_soal -> {
                    startActivity(
                        Intent(
                            applicationContext, GudangActivity::class.java
                        )
                    )
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_shop -> {
                    startActivity(
                        Intent(
                            applicationContext, BelanjaActivity::class.java
                        )
                    )
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_home -> return@OnNavigationItemSelectedListener true
            }
            false
        })

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
    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(baseContext, "Tekan lagi untuk kembali", Toast.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis()
    }
}
