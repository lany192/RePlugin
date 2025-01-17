

package com.qihoo360.replugin.sample.demo3.activity.theme

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView

/**
 * @author RePlugin Team
 */
class ThemeBlackNoTitleBarActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this)
        root.setPadding(30, 30, 30, 30)
        val lp = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        root.layoutParams = lp

        setContentView(root)

        // textView
        val textView = TextView(this)
        textView.gravity = Gravity.CENTER
        textView.textSize = 30f
        textView.text = "Theme3: BlackNoTitleBar"
        val lp2 = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        textView.layoutParams = lp2
        root.addView(textView)
    }

}
