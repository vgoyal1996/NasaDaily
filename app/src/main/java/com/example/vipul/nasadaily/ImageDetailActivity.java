package com.example.vipul.nasadaily;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class ImageDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView date;
    private TextView byLine;
    private TextView description;
    private ImageView image;
    public static final String IMAGE_NID = "nid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    /* adapt the image to the size of the display */
        /*Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(),R.drawable.background),size.x,size.y,true);*/

    /* fill the background ImageView with the resized image */
        /*ImageView iv_background = (ImageView) findViewById(R.id.bimage);
        iv_background.setImageBitmap(bmp);*/

        title = (TextView)findViewById(R.id.title);
        date = (TextView)findViewById(R.id.promodate);
        byLine = (TextView)findViewById(R.id.byline);
        description = (TextView)findViewById(R.id.description);
        image = (ImageView) findViewById(R.id.image);
        String id = (String) getIntent().getExtras().get(IMAGE_NID);
        ImageOfTheDayResponse u = MainActivity.getUbernodeAtNid(id);
        title.setText(u.getUbernode().getTitle());
        date.setText("Date:"+u.getUbernode().getPromoDateTime());
        byLine.setText("By:"+u.getUbernode().getName());
        description.setText(u.getUbernode().getImageFeatureCaption());
        //Picasso.with(getApplicationContext()).load("https://www.nasa.gov/sites/default/files/thumbnails/image/"+u.getImages().get(0).getFilename()).fit().centerCrop().into(image);
        URL newurl = null;
        /*try {
            newurl = new URL("https://www.nasa.gov/sites/default/files/thumbnails/image/"+u.getImages().get(0).getFilename());
            Bitmap mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
            image.setImageBitmap(mIcon_val);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Picasso.with(this).load("https://www.nasa.gov/sites/default/files/thumbnails/image/"+u.getImages().get(0).getFilename()).into(image);
        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.bar);
        ImageLoader.getInstance().displayImage("https://www.nasa.gov/sites/default/files/thumbnails/image/"+u.getImages().get(0).getFilename(), image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }


}
