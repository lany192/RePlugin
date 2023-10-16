

package com.qihoo360.replugin.fresco.plugin;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;
public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://img1.doubanio.com/lpic/s3743777.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.image);
        Uri uri = Uri.parse(IMAGE_URL);
        simpleDraweeView.setImageURI(uri);
    }
}