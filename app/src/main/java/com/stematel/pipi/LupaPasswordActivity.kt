package com.stematel.pipi

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_lupa_password.*

class LupaPasswordActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_password)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        btn_lanjut_lupa.setOnClickListener{
            val email = et_email_lupa.text.toString().trim()

            if (email.isEmpty()){
                et_email_lupa.error = "Emai harus di isi"
                et_email_lupa.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                et_email_lupa.error = "Email tidak valid"
                et_email_lupa.requestFocus()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this,"Cek Email untuk reset password",Toast.LENGTH_SHORT).show()
                    Intent(this@LupaPasswordActivity, LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT  ).show()
                }
            }
        }
        btn_ke_masuk.setOnClickListener {
            Intent(this@LupaPasswordActivity,LoginActivity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)}
        }

    }
}