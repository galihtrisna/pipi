package com.stematel.pipi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @Suppress("DEPRECATION")
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        auth = FirebaseAuth.getInstance()

        btn_lanjut.setOnClickListener{
            val email = et_email.text.toString().trim()
            val password = et_password.text.toString().trim()

            if (email.isEmpty()){
                et_email.error = "Emai harus di isi"
                et_email.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                et_email.error = "Email tidak valid"
                et_email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 8){
                et_password.error = "Password harus lebih dari 8 karakter"
                et_password.requestFocus()
                return@setOnClickListener
            }

            logininUser(email,password)

        }

        btn_ke_daftar.setOnClickListener {
            Intent(this@LoginActivity,RegisterActivity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)
            }}

        lupa_password.setOnClickListener{
            Intent(this@LoginActivity,LupaPasswordActivity::class.java).also {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(it)
            }
        }

        //full Animasi intro --->

        Handler().postDelayed({
            val item = findViewById<ImageView>(R.id.bg_login_header)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.ttb,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.masuk_akun)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<ImageView>(R.id.bg_login_footer)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.tta,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<EditText>(R.id.et_email)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.ttc,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<EditText>(R.id.et_password)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.ttc,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.halo)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.halo2)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.halo3)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.teks1)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.halo2)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.lanjut)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.btn_ke_daftar)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.lupa_password)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<ImageButton>(R.id.btn_lanjut)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.ttc,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<ImageView>(R.id.imageView)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<ImageView>(R.id.imageView2)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<ImageView>(R.id.imageView4)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<TextView>(R.id.teks3)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fade_in_anima,
            ))
        }, 0)

        Handler().postDelayed({
            val item = findViewById<ImageView>(R.id.btn_google)
            item.startAnimation(AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.ttc,
            ))
        }, 0)



        //<----- end

    }


    private fun logininUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this@LoginActivity,PilihKelasActivity::class.java).also { intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        startActivity(intent)
                    }
                }else{
                    Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT  ).show()
                }
            }

    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser !=null){
            Intent(this@LoginActivity,HomeActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(intent)
            }
        }
    }
}