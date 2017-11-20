package com.fofidashboard.activity;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.fofidashboard.R;
import com.fofidashboard.adapter.PagerAdapter;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by prabhavathi on 2/11/17.
 */

public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
ImageView homeheading;
TextView homeheading1;
    ProgressDialog progressDialog;
    private int progressInt = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_home);
        progressDialog=ProgressDialog.show(this,"PLease wait..","Long operation",true);
      //  populateTab();

        /*runOnUiThread(new Runnable() {*/

          final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

       TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        homeheading1 =(TextView)findViewById(R.id.homeheading1);
        homeheading=(ImageView)findViewById(R.id.homeheading);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home));
        tabLayout.addTab(tabLayout.newTab().setText("Tv"));
        tabLayout.addTab(tabLayout.newTab().setText("Vod"));
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
        tabLayout.addTab(tabLayout.newTab().setText("Music"));
        tabLayout.addTab(tabLayout.newTab().setText("Games"));
        tabLayout.addTab(tabLayout.newTab().setText("News"));
        tabLayout.addTab(tabLayout.newTab().setText("Apps"));
        tabLayout.addTab(tabLayout.newTab().setText("Education"));
        tabLayout.addTab(tabLayout.newTab().setText("Recordings"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
                viewPager.setOffscreenPageLimit(9);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

      tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


              /*  int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);*/

if(tab.getPosition()==0){
    homeheading.setVisibility(View.VISIBLE);
    homeheading1.setVisibility(View.INVISIBLE);
}else if(tab.getPosition()==1){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Tv");
}else if(tab.getPosition()==2){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Vod");
}else if(tab.getPosition()==3){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Favourites");
}else if(tab.getPosition()==4){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Music");
}else if(tab.getPosition()==5){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Games");
}else if(tab.getPosition()==6){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("News");
}else if(tab.getPosition()==7){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Apps");
}else if(tab.getPosition()==8){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Education");
}
else if(tab.getPosition()==9){

    homeheading.setVisibility(View.INVISIBLE);
    homeheading1.setVisibility(View.VISIBLE);
    homeheading1.setText("Recordings");
}
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                /*int tabIconColor = ContextCompat.getColor(context, R.color.tabUnselectedIconColor);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);*/

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
                progressDialog.dismiss();

//UI thread
           }

        },13000);


    }
    private void populateTab(){
        progressDialog=ProgressDialog.show(this,"PLease wait..","Long operation",true);
        new Thread(){
            @Override
            public void run() {
             //   super.run();
              // setTab();

                try {

                    // code runs in a thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setTab();
                            progressDialog.dismiss();
                        }
                    });
                } catch (final Exception ex) {
                    Log.i("---","Exception in thread");
                }
            }
        }.start();
    }

 protected void  setTab(){
     try {
         Thread.sleep(5000);
         TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
         homeheading1 =(TextView)findViewById(R.id.homeheading1);
         homeheading=(ImageView)findViewById(R.id.homeheading);
         tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home));
         tabLayout.addTab(tabLayout.newTab().setText("Tv"));
         tabLayout.addTab(tabLayout.newTab().setText("Vod"));
         tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
         tabLayout.addTab(tabLayout.newTab().setText("Music"));
         tabLayout.addTab(tabLayout.newTab().setText("Games"));
         tabLayout.addTab(tabLayout.newTab().setText("News"));
         tabLayout.addTab(tabLayout.newTab().setText("Apps"));
         tabLayout.addTab(tabLayout.newTab().setText("Education"));
         tabLayout.addTab(tabLayout.newTab().setText("Recordings"));

         tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

         final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
         final PagerAdapter adapter = new PagerAdapter
                 (getSupportFragmentManager(), tabLayout.getTabCount());
         viewPager.setAdapter(adapter);
         viewPager.setOffscreenPageLimit(9);
         viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

         tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {

                 if(tab.getPosition()==0){
                     homeheading.setVisibility(View.VISIBLE);
                     homeheading1.setVisibility(View.INVISIBLE);
                 }else if(tab.getPosition()==1){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Tv");
                 }else if(tab.getPosition()==2){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Vod");
                 }else if(tab.getPosition()==3){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Favourites");
                 }else if(tab.getPosition()==4){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Music");
                 }else if(tab.getPosition()==5){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Games");
                 }else if(tab.getPosition()==6){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("News");
                 }else if(tab.getPosition()==7){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Apps");
                 }else if(tab.getPosition()==8){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Education");
                 }
                 else if(tab.getPosition()==9){

                     homeheading.setVisibility(View.INVISIBLE);
                     homeheading1.setVisibility(View.VISIBLE);
                     homeheading1.setText("Recordings");
                 }
                 viewPager.setCurrentItem(tab.getPosition());
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });


     } catch (InterruptedException e) {
         System.out.print("Settting tab is fail");
     }
 }

   /* private void updateProgress() {
        progressInt += 1;
        if (progressInt > 100) {
            mHandler.removeCallbacks(runnable);
        } else {
            progressBar.setProgress(progressInt);
        }
    }*/

}
