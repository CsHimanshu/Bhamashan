package com.hackathon.bhamashah;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.bhamashah.activities.LoginActivity;
import com.hackathon.bhamashah.activities.ProfileActivity;
import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.local.SharedPreferences;
import com.hackathon.bhamashah.fragments.AwairnessFragment;
import com.hackathon.bhamashah.fragments.BankEligibilityFragment;
import com.hackathon.bhamashah.fragments.BhamashahPassbookFragment;
import com.hackathon.bhamashah.fragments.CurrentOffersBankFragment;
import com.hackathon.bhamashah.fragments.HomeBankingFragment;
import com.hackathon.bhamashah.fragments.SpecialMedicalServicesFragment;
import com.hackathon.bhamashah.utilities.AppUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private ImageView headerImageViewProfile;
    private TextView headerTextviewTitle;
    private TextView headerTextviewSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        headerImageViewProfile = (ImageView) header.findViewById(R.id.header_imageView_profile);
        headerTextviewTitle = (TextView) header.findViewById(R.id.header_textview_title);
        headerTextviewSubtitle = (TextView) header.findViewById(R.id.header_textview_subtitle);
        headerImageViewProfile.setOnClickListener(this);
        headerTextviewTitle.setOnClickListener(this);
        headerTextviewSubtitle.setOnClickListener(this);
        if (AppData.getInstance().getUser().getHoFDetails() != null) {
            String name_eng = AppData.getInstance().getUser().getHoFDetails().getNAME_ENG();
            headerTextviewTitle.setText(name_eng);
            List<FamilyDetailsBean> family_details = AppData.getInstance().getUser().getFamily_Details();
            headerTextviewSubtitle.setText("Family members " + family_details.size());
            String strBase64 = "/9j/4AAQSkZJRgABAQEAZABkAAD/4RBmRXhpZgAATU0AKgAAAAgAA4dpAAQAAAABAAAIPpyeAAEAAAACAAAAAOocAAcAAAgMAAAAMgAAAAAc6gAAAAgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB6hwABwAACAwAAAhQAAAAABzqAAAACAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD/4QwOaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49J++7vycgaWQ9J1c1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCc/Pg0KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyI+PHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj48cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0idXVpZDpmYWY1YmRkNS1iYTNkLTExZGEtYWQzMS1kMzNkNzUxODJmMWIiIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIvPjxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSJ1dWlkOmZhZjViZGQ1LWJhM2QtMTFkYS1hZDMxLWQzM2Q3NTE4MmYxYiIgeG1sbnM6TWljcm9zb2Z0UGhvdG89Imh0dHA6Ly9ucy5taWNyb3NvZnQuY29tL3Bob3RvLzEuMC8iLz48cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0idXVpZDpmYWY1YmRkNS1iYTNkLTExZGEtYWQzMS1kMzNkNzUxODJmMWIiIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyI+PGRjOnN1YmplY3Q+PHJkZjpCYWcgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj48cmRmOmxpPjwvcmRmOmxpPjwvcmRmOkJhZz4NCgkJCTwvZGM6c3ViamVjdD48L3JkZjpEZXNjcmlwdGlvbj48cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0idXVpZDpmYWY1YmRkNS1iYTNkLTExZGEtYWQzMS1kMzNkNzUxODJmMWIiIHhtbG5zOk1pY3Jvc29mdFBob3RvPSJodHRwOi8vbnMubWljcm9zb2Z0LmNvbS9waG90by8xLjAvIj48TWljcm9zb2Z0UGhvdG86TGFzdEtleXdvcmRYTVA+PHJkZjpCYWcgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj48cmRmOmxpPjwvcmRmOmxpPjwvcmRmOkJhZz4NCgkJCTwvTWljcm9zb2Z0UGhvdG86TGFzdEtleXdvcmRYTVA+PC9yZGY6RGVzY3JpcHRpb24+PC9yZGY6UkRGPjwveDp4bXBtZXRhPg0KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg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";
            byte[] decodedString = Base64.decode(strBase64, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            headerImageViewProfile.setImageBitmap(decodedByte);

        }
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bhamashahPassbook) {
            AppUtils.addFragment(this, new BhamashahPassbookFragment());

        } else if (id == R.id.nav_bs_offers) {
            AppUtils.addFragment(this, new CurrentOffersBankFragment());

        } else if (id == R.id.nav_bs_eligibility) {
            AppUtils.addFragment(this, new BankEligibilityFragment());

        } else if (id == R.id.nav_ss_awiarness_general) {
            AppUtils.addFragment(this, new AwairnessFragment());

        } else if (id == R.id.nav_ss_homeBanking) {
            AppUtils.addFragment(this, new HomeBankingFragment());

        } else if (id == R.id.nav_ss_career) {
            AppUtils.addFragment(this, new SpecialMedicalServicesFragment());
        } else if (id == R.id.nav_emergency_sos) {
            //call 100
//            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1001"));
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//
//            }
//            startActivity(intent);

        } else if (id == R.id.nav_emergency_medical) {
            //call 108 or 1052

        }else if (id == R.id.nav_logout) {
            //logout
            AppUtils.logout(this);
            Intent i=new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
        }else if (id == R.id.nav_share) {
            //share
            AppUtils.shareLink(this,"Bhamashah application");


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(SharedPreferences.getBoolean(SharedPreferences.KEY_IsLOGIN,false,this)){
            Intent i=new Intent(this,ProfileActivity.class);
            startActivity(i);
        }

    }
}
