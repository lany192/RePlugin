

package com.qihoo360.replugin.fresco.host;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 宿主中使用fresco
 *
 * @author RePlugin Team
 */
public class HostFrescoActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://img1.doubanio.com/view/photo/large/public/p2504463708.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_fresco);

        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image);
        draweeView.setImageURI(Uri.parse(IMAGE_URL));
    }
}