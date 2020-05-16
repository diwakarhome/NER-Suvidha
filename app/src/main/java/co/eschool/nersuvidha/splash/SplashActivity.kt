package co.eschool.nersuvidha.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import co.eschool.nersuvidha.R
import co.eschool.nersuvidha.config.BaseActivity
import co.eschool.nersuvidha.home.HomeActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            Intent(this@SplashActivity, HomeActivity::class.java).apply {
                startActivity(this)
            }
        }, 2_000)
    }
}
