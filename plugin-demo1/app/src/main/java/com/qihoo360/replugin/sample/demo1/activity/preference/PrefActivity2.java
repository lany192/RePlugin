

package com.qihoo360.replugin.sample.demo1.activity.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.qihoo360.replugin.sample.demo1.R;

/**
 * PreferenceActivity 示例2
 *
 * @author RePlugin Team
 */
public class PrefActivity2 extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_headers);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}