package com.example.dafidzeko.belajartablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dafidzeko.belajartablayout.adapter.FilmPagerAdapter;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        //method set adapter
        ambilAdapter(viewPager);
        
        
        setTabLayout(tabLayout, viewPager);


    }


    private void ambilAdapter(ViewPager pager) {
        FilmPagerAdapter filmPagerAdapter = new FilmPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        pager.setAdapter(filmPagerAdapter);
    }

    private void setTabLayout(TabLayout slideTab, final ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

}
