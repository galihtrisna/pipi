package com.stematel.pipi

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class DetailSoalActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val STORAGE_PERMISSION_CODE: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_soal)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val username = findViewById<TextView>(R.id.username)
        username.text = currentUser?.displayName
        val gambar = findViewById<ImageView>(R.id.gambar_profile)
        Glide.with(this).load(currentUser?.photoUrl).into(gambar)

        gambar.setOnClickListener {
            Intent(this@DetailSoalActivity,ProfileActivity::class.java).also { intent ->
                startActivity(intent) }
        }

        hideSystemUI()

        val kembali = findViewById<CardView>(R.id.back)
        kembali.setOnClickListener {
            Intent(this@DetailSoalActivity,HomeActivity::class.java).also { intent ->
                startActivity(intent) }
            overridePendingTransition(0, 0)
            finish()
        }

        val unduh_jwb = findViewById<Button>(R.id.unduh_jwb)
        val unduh_soal = findViewById<Button>(R.id.unduh_soal)

        unduh_jwb.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){

                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE) , STORAGE_PERMISSION_CODE)

                }
                else{
                    startDownloading1()
                }
            }
            else{
                startDownloading1()
            }
        }
        unduh_soal.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){

                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE) , STORAGE_PERMISSION_CODE)

                }
                else{
                    startDownloading()
                }
            }
            else{
                startDownloading()
            }
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
        Intent(this@DetailSoalActivity,HomeActivity::class.java).also { intent ->
            startActivity(intent) }
        overridePendingTransition(0, 0)
        finish()
    }
    private fun startDownloading1() {
        val url = "https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2Fgudangsoal%2FKJ%20semester%201%20mtk%20kls%206.pdf?alt=media&token=4d69ae57-498d-410f-9d2b-7b316c08c048"
        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${System.currentTimeMillis()}")

        val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
    }
    private fun startDownloading() {
        val url = "https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2Fgudangsoal%2FSoal%20UTS%20Matematika%20Kelas%206%20Semester%201.pdf?alt=media&token=914180e5-8999-47c0-81f8-28ede0784a65"
        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${System.currentTimeMillis()}")

        val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            STORAGE_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_DENIED){
                    startDownloading1()
                    startDownloading()
                }
                else{
                    Toast.makeText(this, "Permission Denided", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}