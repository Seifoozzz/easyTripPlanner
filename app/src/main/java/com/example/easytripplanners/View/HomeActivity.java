package com.example.easytripplanners.View;

import android.os.Bundle;

import com.example.easytripplanners.R;
import com.example.easytripplanners.View.ui.home.PastFragment;
import com.example.easytripplanners.View.ui.home.UpComingFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easytripplanners.View.ui.home.SectionsPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SectionsPagerAdapter sectionsPagerAdapter =
                new SectionsPagerAdapter(
                        this,
                        getSupportFragmentManager(),
                        new Fragment[]{
                            new PastFragment(),
                            new UpComingFragment(),
                        }
                    );
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        );
    }
}