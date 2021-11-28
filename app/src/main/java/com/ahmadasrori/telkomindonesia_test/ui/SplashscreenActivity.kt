package com.ahmadasrori.telkomindonesia_test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.ahmadasrori.telkomindonesia_test.R
import com.ahmadasrori.telkomindonesia_test.databinding.ActivitySplashscreenBinding
import com.ahmadasrori.telkomindonesia_test.util.Constant.DELAY

class SplashscreenActivity : AppCompatActivity() {
    private val binding: ActivitySplashscreenBinding by lazy {
        ActivitySplashscreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val animSlide = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.slide
        )
        binding.ivLogo.animation = animSlide
        val splashTread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(DELAY.toLong())
                } catch (e: InterruptedException) {
                } finally {
                    val i = Intent(this@SplashscreenActivity, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }
        }
        splashTread.start()
    }
}