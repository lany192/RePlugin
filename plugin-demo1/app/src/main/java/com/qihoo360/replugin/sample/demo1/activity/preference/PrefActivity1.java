

package com.qihoo360.replugin.sample.demo1.activity.preference;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import com.qihoo360.replugin.sample.demo1.R;

/**
 * PreferenceActivity 示例1
 *
 * @author RePlugin Team
 */
public class PrefActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_2);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, new TestPreferenceFragment())
                .commit();
    }

    public static class TestPreferenceFragment extends PreferenceFragment {

        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_headers);
        }
    }
}