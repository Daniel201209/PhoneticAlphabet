package com.phoneticalphabet.utlis;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.phoneticalphabet.R;
import com.phoneticalphabet.view.GlideRoundTransform;

/**
 * 图片显示
 */
public class ImageUtils {

    public static void setImageView(Activity activity, String url, ImageView imageView, int horn) {
        //通过RequestOptions扩展功能
        RequestOptions options = new RequestOptions()
                .override(400, 400)
                .transform(new GlideRoundTransform(activity, horn))
                .placeholder(R.mipmap.ic_launcher)                //加载成功之前占位图
                .error(R.mipmap.ic_launcher)                    //加载错误之后的错误图
                .diskCacheStrategy(DiskCacheStrategy.ALL);        //缓存所有版本的图像

        Glide.with(activity)
                .load(url)
                .apply(options)
                .into(imageView);
    }


    public static void setImageView(Context context, String url, ImageView imageView, int horn) {
        RequestOptions options = null;
        //通过RequestOptions扩展功能
        if( horn == 0){
            options = new RequestOptions()
                    .override(400, 400)
                    .placeholder(R.mipmap.ic_launcher)                //加载成功之前占位图
                    .error(R.mipmap.ic_launcher)                    //加载错误之后的错误图
                    .diskCacheStrategy(DiskCacheStrategy.ALL);        //缓存所有版本的图像
        }else {
            options = new RequestOptions()
                    .override(400, 400)
                    .transform(new GlideRoundTransform(context, horn))
                    .placeholder(R.mipmap.ic_launcher)                //加载成功之前占位图
                    .error(R.mipmap.ic_launcher)                    //加载错误之后的错误图
                    .diskCacheStrategy(DiskCacheStrategy.ALL);        //缓存所有版本的图像
        }

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

}
