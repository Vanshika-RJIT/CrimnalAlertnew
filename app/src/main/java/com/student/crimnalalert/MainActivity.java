package com.student.crimnalalert;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.student.crimnalalert.Fragment.Navbar_CRIMINALRATE;
import com.student.crimnalalert.Fragment.Navbar_FEEDBACK;
import com.student.crimnalalert.Fragment.Navbar_FIR;
import com.student.crimnalalert.Fragment.Navbar_NCR;
import com.student.crimnalalert.Fragment.Navbar_SETTINGPRIVACY;
import com.student.crimnalalert.Fragment.Navbar_TERMSCONDTION;
import com.student.crimnalalert.Fragment.Navbar_ZEROFIR;
import com.student.crimnalalert.Fragment.layout_GUIDE;
import com.student.crimnalalert.Fragment.layout_HOME;
import com.student.crimnalalert.Fragment.layout_PREMIUM;
import com.student.crimnalalert.Fragment.layout_PROFILE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener , NavigationView.OnNavigationItemSelectedListener {

//    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;
    private  DrawerLayout drawer;
    private ImageView hambericon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottom_navbar_id);
        navigationView=findViewById(R.id.nav_view);
        hambericon=findViewById(R.id.hamberid);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(this);



        //tootlbar set
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


         drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //open navigation-bar on cliking hambericon
        hambericon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
       // change togglebar icon
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburger);

        //by-default home fragment open without cliking
        setfragment(new layout_HOME());

//        NavigationView navigationView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bottomaction_home_id :
                setfragment(new layout_HOME());
                break;
            case R.id.bottomaction_premimum_id:
                setfragment(new layout_PREMIUM());
                break;
            case R.id.bottomaction_guide_id:
                setfragment(new layout_GUIDE());
                break;
            case R.id.bottomaction_profile_id:
                setfragment(new layout_PROFILE());
                break;

                // navigation view items
            case R.id.nav_fir_id:
                setfragment(new Navbar_FIR());
                Toast.makeText(MainActivity.this,"Fir",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;
            case R.id.nav_ncr_id:
                setfragment(new Navbar_NCR());
                Toast.makeText(MainActivity.this,"NCR",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;
            case R.id.nav_zerofir_id:
                setfragment(new Navbar_ZEROFIR());
                Toast.makeText(MainActivity.this,"ZERO-NCR",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;
            case R.id.nav_criminalrate_id:
                setfragment(new Navbar_CRIMINALRATE());
                Toast.makeText(MainActivity.this,"CRIMINAL-RATE",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;
            case R.id.nav_feedback_id:
                setfragment(new Navbar_FEEDBACK());
                Toast.makeText(MainActivity.this,"FEEDBACK",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;
            case R.id.nav_termAndCondition_id:
                setfragment(new Navbar_TERMSCONDTION());
                Toast.makeText(MainActivity.this,"TERMSANDCONDITION",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;
            case R.id.nav_settingAndPrivacy_id:
                setfragment(new Navbar_SETTINGPRIVACY());
                Toast.makeText(MainActivity.this,"SETTINGANDPRIVACY",Toast.LENGTH_SHORT).show();
                drawer.closeDrawers();
                break;

        }
        return true;
    }

    private void setfragment(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.mainpageid,fragment);
        ft.commit();
    }
//    private void setfragmentfull(Fragment fragment) {
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.replace(R.id.fullmainid,fragment);
//        ft.commit();
//    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
        a.setMessage("Are You Sure Want to Exit");

        a.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"oops you close the app",Toast.LENGTH_SHORT).show();
            }
        });
        a.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        a.setNeutralButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in,33);

            }
        });
        a.show();
        super.onBackPressed();
////        if(drawer.isDrawerOpen(drawer)){
////            drawer.closeDrawer(GravityCompat.END);
////        }
////        else{
////
////        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_notification:
                Toast.makeText(MainActivity.this,"Notification",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_setting:
                Toast.makeText(MainActivity.this,"Setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_read_later:
                Toast.makeText(MainActivity.this,"Read Later",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share_this_app:
                Toast.makeText(MainActivity.this,"Share this app",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:
                Toast.makeText(MainActivity.this,"Logout",Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }


    //    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

}