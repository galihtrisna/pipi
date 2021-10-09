package com.stematel.pipi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class PilihKelasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_kelas)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        //daftar button kelas
        val kelas1 = findViewById<Button>(R.id.button)
        val kelas2 = findViewById<Button>(R.id.button7)
        val kelas3 = findViewById<Button>(R.id.button16)
        val kelas4 = findViewById<Button>(R.id.button6)
        val kelas5 = findViewById<Button>(R.id.button8)
        val kelas6 = findViewById<Button>(R.id.button15)
        val kelas7 = findViewById<Button>(R.id.button3)
        val kelas8 = findViewById<Button>(R.id.button9)
        val kelas9 = findViewById<Button>(R.id.button14)
        val kelas10ipa = findViewById<Button>(R.id.button4)
        val kelas11ipa = findViewById<Button>(R.id.button10)
        val kelas12ipa = findViewById<Button>(R.id.button13)
        val kelas10ips = findViewById<Button>(R.id.button5)
        val kelas11ips = findViewById<Button>(R.id.button11)
        val kelas12ips = findViewById<Button>(R.id.button12)

        //fungsi button kelas
        kelas6.setOnClickListener {
            Intent(this@PilihKelasActivity, HomeActivity::class.java).also {intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(intent)
            }
        }
        kelas1.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas2.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas3.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas4.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas5.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas7.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas8.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas9.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas10ipa.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas11ipa.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas12ipa.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas10ips.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas11ips.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }
        kelas12ips.setOnClickListener {
            Toast.makeText(this,"Belum Tersedia", Toast.LENGTH_SHORT).show()
        }

    }
}