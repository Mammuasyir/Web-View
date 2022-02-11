package com.example.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.webview.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.lottieAnim.setAnimation("AndroidWave.json")
        binding.lottieAnim.playAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
//            val i = Intent(this, MainActivity::class.java)
//            startActivity(i)
//            finish()

        val i : Intent?
        val sessionManager = SessionManager(this@SplashScreenActivity)
        if (sessionManager.isiLogin()){
            i = Intent(this@SplashScreenActivity, MainActivity::class.java)
        }else{
            i = Intent(this@SplashScreenActivity, LoginActivity::class.java)
        }
            startActivity(i)
            finish()
        }, 3000)
    }
}