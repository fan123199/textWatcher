package im.fdx.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import im.fdx.textwatcher.DigitFormatWatcher
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        et.addTextChangedListener(DigitFormatWatcher('_', 3))
    }
}
