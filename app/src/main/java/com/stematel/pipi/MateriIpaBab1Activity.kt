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
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView

class MateriIpaBab1Activity : AppCompatActivity() {

    private val STORAGE_PERMISSION_CODE: Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_ipa_bab1)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val play1 = findViewById<ImageButton>(R.id.play_1)
        val back = findViewById<ImageButton>(R.id.back)
        val rangkuman = findViewById<CardView>(R.id.button_rangkuman)
        val kuis = findViewById<CardView>(R.id.button_kuis_akhir)

        play1.setOnClickListener {
            Intent(this@MateriIpaBab1Activity,VideoIpa1Activity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)}
        }
        back.setOnClickListener {
            Intent(this@MateriIpaBab1Activity,Ipa_Activity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)}
        }

        kuis.setOnClickListener {
            Intent(this@MateriIpaBab1Activity, KuisIpaActivity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)
            }
        }
        rangkuman.setOnClickListener {
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
    private fun startDownloading() {
        val url = "https://firebasestorage.googleapis.com/v0/b/pipi-2021.appspot.com/o/kelas6%2FIPA%2FMagnet.jpg?alt=media&token=a6bca978-d424-4574-894c-140cfe41f728"
        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        request.setTitle("Rangkuman IPA Bab 1.jpg")
        request.setDescription("File sedang diunduh...")

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
                    startDownloading()
                }
                else{
                    Toast.makeText(this, "Permission Denided", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    override fun onBackPressed() {
        Intent(this@MateriIpaBab1Activity,Ipa_Activity::class.java).also {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            startActivity(it)}
    }
}