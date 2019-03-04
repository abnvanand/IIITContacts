package com.example.iiitcontacts.adapters;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.ImageView;

import com.example.iiitcontacts.R;
import com.example.iiitcontacts.pojo.Contact;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;


public class BindingAdapters {
    private static DisplayImageOptions displayImageOptionsPhoto = new DisplayImageOptions.Builder()
            .showImageOnFail(R.drawable.ic_launcher_foreground)
            .showImageForEmptyUri(R.drawable.ic_launcher_foreground)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(new RoundedBitmapDisplayer(128))
            .build();



    @BindingAdapter({"app:avatar"})
    public static void bindAvatar(@NonNull ImageView imageView, @NonNull String imageUrl) {
        ImageLoader.getInstance().displayImage(imageUrl,
                imageView, displayImageOptionsPhoto);
    }
}
