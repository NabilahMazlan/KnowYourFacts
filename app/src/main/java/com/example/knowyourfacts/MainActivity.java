package com.example.knowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> arraylist;
    MyFragmentPagerAdapter adapter;
    ViewPager vp;
    Button btnLater;
    int reqeustCode = 12345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.viewPager);
        btnLater = findViewById(R.id.buttonLater);
        FragmentManager fm = getSupportFragmentManager();
        arraylist = new ArrayList<Fragment>();
        arraylist.add(new Fragment1());
        arraylist.add(new Fragment2());
        arraylist.add(new Fragment3());

        adapter = new MyFragmentPagerAdapter(fm, arraylist);
        vp.setAdapter(adapter);
        
        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MINUTE,5);
                
                Intent i = new Intent(MainActivity.this, ScheduledNotification.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, reqeustCode, i, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
                Toast.makeText(MainActivity.this, "Notification has been set to 5 minutes...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        int currentPage = vp.getCurrentItem();
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", currentPage);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        int currentPage = sharedPreferences.getInt("id", 0);
        vp.setCurrentItem(currentPage,false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_selection, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.previous){
            if(vp.getCurrentItem() > 0){
                int previousPage = vp.getCurrentItem() -1;
                vp.setCurrentItem(previousPage, true);
            }

        }else if(id == R.id.random){
            Random r = new Random();
            int page = r.nextInt(vp.getChildCount());
            vp.setCurrentItem(page, true);

        }else if(id == R.id.next){
            int max = vp.getChildCount();
            if(vp.getCurrentItem() < max - 1){
                int nextPage = vp.getCurrentItem() + 1;
                vp.setCurrentItem(nextPage, true);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
