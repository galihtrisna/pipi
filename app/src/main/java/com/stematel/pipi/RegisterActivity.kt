package com.stematel.pipi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        auth = FirebaseAuth.getInstance()

        btn_lanjut_daftar.setOnClickListener{
            val email = et_email_daftar.text.toString().trim()
            val password = et_password_daftar.text.toString().trim()

            if (email.isEmpty()){
                et_email_daftar.error = "Email harus diisi"
                et_email_daftar.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                et_email_daftar.error = "Email tidak valid"
                et_email_daftar.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 8){
                et_password_daftar.error = "Password harus lebih dari 8 karakter"
                et_password_daftar.requestFocus()
                return@setOnClickListener
            }

            registerUser(email,password)
        }

        btn_ke_masuk.setOnClickListener {
            Intent(this@RegisterActivity, LoginActivity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)
            }}
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this@RegisterActivity, PilihKelasActivity::class.java).also {intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        startActivity(intent)
                    }
                }else{
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
            }

    }