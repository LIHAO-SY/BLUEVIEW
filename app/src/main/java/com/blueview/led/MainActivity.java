package com.blueview.led;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Adapter;

import com.blueview.led.R;
import com.blueview.led.ui.control.ControlFragment;
import com.blueview.led.ui.home.HomeFragment;
import com.blueview.led.ui.map.MapFragment;
import com.blueview.led.ui.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MenuItem menuItem;
    private List<Fragment> fragmentList=new ArrayList<>();
    private BottomNavigationView bottomNavigationView;
    private FragmentPagerAdapter fragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.nav_view);
        viewPager=findViewById(R.id.ViewPager);
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ControlFragment());
        fragmentList.add(new MapFragment());
        fragmentList.add(new UserFragment());
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };

        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuItem = item;
                int i = item.getItemId();
                if (i == R.id.navigation_home) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (i == R.id.navigation_control) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (i == R.id.navigation_map) {
                    viewPager.setCurrentItem(2);
                    return true;
                } else if (i == R.id.navigation_user) {
                    viewPager.setCurrentItem(3);
                    return true;
                }
                return false;
            }
        });
    }

}