package co.eschool.nersuvidha.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.eschool.nersuvidha.R
import co.eschool.nersuvidha.utils.setupActionBar
import kotlinx.android.synthetic.main._toolbar.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupActionBar(appToolbar, false)
        title = getString(R.string.ner_suvidha)
    }
}
