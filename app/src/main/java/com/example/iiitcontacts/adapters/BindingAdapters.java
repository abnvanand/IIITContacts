package com.example.iiitcontacts.adapters;

import android.widget.ImageView;

import com.example.iiitcontacts.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;


public class BindingAdapters {
    private static DisplayImageOptions displayThumbnailOptions = new DisplayImageOptions.Builder()
            .showImageOnFail(R.drawable.ic_launcher_foreground)
            .showImageForEmptyUri(R.drawable.ic_launcher_foreground)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(new RoundedBitmapDisplayer(1000))
            .build();

    private static DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
            .showImageOnFail(R.drawable.ic_launcher_foreground)
            .showImageForEmptyUri(R.drawable.ic_launcher_foreground)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();


    @BindingAdapter({"app:avatar"})
    public static void bindAvatar(@NonNull ImageView imageView, @NonNull String imageUrl) {
        ImageLoader.getInstance().displayImage(imageUrl,
                imageView, displayThumbnailOptions);
    }

    @BindingAdapter({"app:imagefromurl"})
    public static void bindImagefromurl(@NonNull ImageView imageView, @NonNull String imageUrl) {
        ImageLoader.getInstance().displayImage(imageUrl,
                imageView, displayImageOptions);
    }
}
