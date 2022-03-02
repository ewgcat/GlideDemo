package com.xinwis.glidedemo;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv= (ImageView) findViewById(R.id.iv);
        //写法一
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .priority(Priority.HIGH).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .transform(new GlideCircleTransform(this));

        //写法二
        RequestOptions options1 = centerCropTransform()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .priority(Priority.HIGH).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .transform(new GlideCircleTransform(this));


        Glide.with(this).load("http://61.144.88.36/image/2017/07/07/1707071637184053.png")
                //图片加载动画
                .transition(withCrossFade(R.anim.glide_image_fade_in, 1000))
                .apply(options).into(iv);




    }
}
