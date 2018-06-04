package com.example.android.belajaranak;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tab = (TabLayout) findViewById(R.id.tabs);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(categoryAdapter);

        tab.setupWithViewPager(viewPager);
    }
}
