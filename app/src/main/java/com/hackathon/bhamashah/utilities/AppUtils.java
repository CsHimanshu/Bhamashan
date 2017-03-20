package com.hackathon.bhamashah.utilities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.base.BaseFragment;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class AppUtils {

    public static void addFragment(Activity activity, BaseFragment baseFragment) {
        // Create fragment and give it an argument specifying the article it should show

        Bundle args = new Bundle();
        //        args.putInt(baseFragment.ARG_POSITION, position);
        //        newFragment.setArguments(args);
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, baseFragment);
        //        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }


    public static void loadImage(ImageView imageView, String url, Drawable placeHolder, Drawable error) {

        if (placeHolder == null) {
//             Get the default PlaceHolde for the application
//            placeHolder=
        }

        if (TextUtils.isEmpty(url)) {
//            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(),R.drawable.placeholder));
//            imageView.setImageDrawable(imageView.getContext().getDrawable(R.drawable.placeholder));
            return;
        }

        if(!url.contains("http")){
            int resId = getResourseId(imageView.getContext(),url);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(),resId));
            return;
        }

        //Use Glide to load the images from the url. .diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(imageView.getContext()).load(url)
                .thumbnail(0.5f)
                .crossFade()
                .into(imageView);

    }


    public static void loadImage(ImageView imageView, String url) {
        loadImage(imageView,url,null,null);
    }


    public static int getResourseId(Context context, String pVariableName){
        try {
            return context.getResources().getIdentifier(pVariableName, "drawable", context.getPackageName());
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }

    public static void updateUI(Activity activity, Runnable runnable) {
        activity.runOnUiThread(runnable);
    }
}
