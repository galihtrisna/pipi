package com.stematel.pipi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        hideSystemUI()

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val gambar = findViewById<ImageView>(R.id.gambar_profile)
        val nama = findViewById<TextView>(R.id.nama)
        val email = findViewById<TextView>(R.id.email)
        val nohp = findViewById<TextView>(R.id.nomerhp)
        val logout = findViewById<Button>(R.id.logout)
        nama.text = currentUser?.displayName
        val emailku = currentUser?.email
        email.text = "Email : ${emailku}"
        val hpku = currentUser?.phoneNumber
        if (hpku.isNullOrEmpty()){
            nohp.text = "No hp : "
        } else {
            nohp.text = "No hp : ${hpku}"
        }
        Glide.with(this).load(currentUser?.photoUrl).into(gambar)

        logout.setOnClickListener {
            auth.signOut()
            Intent(this@ProfileActivity,LoginActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent) }
        }
        val back = findViewById<ImageButton>(R.id.back)
        back.setOnClickListener {
            Intent(this@ProfileActivity,HomeActivity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it) }
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
    override fun onBackPressed() {
        Intent(this@ProfileActivity,HomeActivity::class.java).also { intent ->
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            startActivity(intent) }
    }
}