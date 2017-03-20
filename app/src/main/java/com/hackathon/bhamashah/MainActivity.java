package com.hackathon.bhamashah;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hackathon.bhamashah.fragments.AwairnessFragment;
import com.hackathon.bhamashah.fragments.BhamashahPassbookFragment;
import com.hackathon.bhamashah.fragments.CustomLoanFragment;
import com.hackathon.bhamashah.fragments.GovernmentLoanFragment;
import com.hackathon.bhamashah.fragments.HomeBankingFragment;
import com.hackathon.bhamashah.fragments.HomeFragment;
import com.hackathon.bhamashah.fragments.OtherFragment;
import com.hackathon.bhamashah.fragments.SpecialMedicalServicesFragment;
import com.hackathon.bhamashah.utilities.AppUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
            AppUtils.addFragment(this,new BhamashahPassbookFragment());

        } else if (id == R.id.nav_bs_offers) {
            AppUtils.addFragment(this,new GovernmentLoanFragment());

        } else if (id == R.id.nav_bs_eligibility) {
            AppUtils.addFragment(this,new CustomLoanFragment());

        } else if (id == R.id.nav_ss_awiarness_general) {
            AppUtils.addFragment(this,new AwairnessFragment());

        }  else if (id == R.id.nav_ss_homeBanking) {
            AppUtils.addFragment(this,new HomeBankingFragment());

        } else if (id == R.id.nav_ss_career) {
            AppUtils.addFragment(this,new SpecialMedicalServicesFragment());
        } else if (id == R.id.nav_emergency_sos) {
            //call 100

        } else if (id == R.id.nav_emergency_medical) {
            //call 108 or 1052

        }else if (id == R.id.nav_logout) {
            //logout

        }else if (id == R.id.nav_share) {
            //share

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
