package com.example.shortz.helloworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageViewActivity extends AppCompatActivity {
    private final static Logger LOGGER = Logger.getLogger(ImageViewActivity.class.getName());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        Uri uri = Uri.parse( intent.getStringExtra( MediaStore.EXTRA_OUTPUT ) );
        try {
            Bitmap b = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            imageView.setImageBitmap(b);
        } catch ( final IOException e ) {
            LOGGER.log(Level.INFO, "Error while transforming to bitmap.", e );
        }

        String longitude = intent.getStringExtra( "LONG" );
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(longitude);

        String latitude = intent.getStringExtra( "LONG" );
        TextView latitudeView = new TextView(this);
        latitudeView.setTextSize(40);
        latitudeView.setText(latitude);



    }
}
