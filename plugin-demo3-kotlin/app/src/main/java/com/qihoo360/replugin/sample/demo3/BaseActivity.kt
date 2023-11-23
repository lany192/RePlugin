

package com.qihoo360.replugin.sample.demo3

import android.app.Activity
import android.os.Bundle

/**
 * @author RePlugin Team
 */
abstract class BaseActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simple)
    }

}
