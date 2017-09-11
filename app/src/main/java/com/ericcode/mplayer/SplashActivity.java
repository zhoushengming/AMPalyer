package com.ericcode.mplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SplashActivity extends AppCompatActivity {
    private final static String ASSETS_PATH = "splashImg";

    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        unbinder = ButterKnife.bind(this);

        try {
            String[] imgs = getAssets().list(ASSETS_PATH);
            int nextInt = new Random().nextInt(imgs.length);
            InputStream inputStream = getAssets().open(ASSETS_PATH + File.separatorChar + imgs[nextInt]);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ivSplash.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
