package com.hackathon.bhamashah.utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.base.BaseFragment;
import com.hackathon.bhamashah.base.MyApplication;
import com.hackathon.bhamashah.data.local.SharedPreferences;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class AppUtils {
    private static ProgressDialog progressDialog =null;

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

    public static void showLoader(Context context){
        hideLoader();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void hideLoader(){
        if (progressDialog!=null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }



    public static void showDialogWithTwoButtons(Context context, String title, String message, String positiveButtonText, String negativeButtonText, final DialogInterface.OnClickListener positiveClickListener, final DialogInterface.OnClickListener negativeClickListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if(title!=null){
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setPositiveButton(positiveButtonText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        if(positiveClickListener!=null){
                            positiveClickListener.onClick(dialog,which);
                        }
                    }
                });

        if (negativeButtonText!=null) {
            builder.setNegativeButton(negativeButtonText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // negative button logic
                            if (negativeClickListener != null) {
                                negativeClickListener.onClick(dialog, which);
                            }
                        }
                    });
        }
        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
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


    public static void addAdatperToRecyclerView(RecyclerView.Adapter adapter,RecyclerView recyclerView) {
//        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MyApplication.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public static void logout(Context context) {
        SharedPreferences.clearAll(context);
    }

    public static void shareLink(Context context, String link) {
        if (context != null && link != null && !link.isEmpty()) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
            sharingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(Intent.createChooser(sharingIntent, ""));
        }
    }
}
