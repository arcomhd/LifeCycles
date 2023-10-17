package com.example.lifecycles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LOG_TAG","------------");
        Log.d("LOG_TAG","onCreate");
        TabLayout tabLayout=findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPager viewPager=findViewById(R.id.pager);
        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menu1){
            Toast.makeText(this, "Menu 1",
                    Toast.LENGTH_SHORT).show();
        }else if(id==R.id.menu2){
            Intent intent=new Intent(this,
                    SecondActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LOG_TAG","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOG_TAG","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LOG_TAG","onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LOG_TAG","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG_TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LOG_TAG","onDestroy");
    }
}