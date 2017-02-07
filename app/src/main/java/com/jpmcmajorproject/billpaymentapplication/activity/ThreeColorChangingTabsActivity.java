package com.jpmcmajorproject.billpaymentapplication.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.jpmcmajorproject.billpaymentapplication.CustomViewPager;
import com.jpmcmajorproject.billpaymentapplication.R;
import com.jpmcmajorproject.billpaymentapplication.fragment.HistoryFragment;
import com.jpmcmajorproject.billpaymentapplication.fragment.HomeFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iiro on 7.6.2016.
 */
public class ThreeColorChangingTabsActivity extends AppCompatActivity {
    private TextView messageView;
    ViewPagerAdapter adapter;
    BottomBar bottomBar;
    private List<Fragment> fragmentList;
    CustomViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_color);
         viewPager = (CustomViewPager) findViewById(R.id.view_pager);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        setupViewPager();
        bottomBar.setDefaultTab(R.id.tab_home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Toast.makeText(ThreeColorChangingTabsActivity.this, ""+tabId, Toast.LENGTH_SHORT).show();

                switch (tabId) {
                    case R.id.tab_history:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.tab_home:
                        viewPager.setCurrentItem(1);

                        break;
                    case R.id.tab_settings:
                        break;
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void setupViewPager() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new HomeFragment());
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomBar.selectTabAtPosition(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




//        if(tabid == 0)

//            adapter.addFrag(new HomeFragment());
//        else if(tabid == 1)
//            adapter.addFrag(new HistoryFragment());

        //adapter.addFrag(new TwoFragment(), "DAY");
        //adapter.addFrag(new ThreeFragment(), "DAY");
//        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return HomeFragment.newInstance(1);

                case 1:
                    return HistoryFragment.newInstance(2);

                case 2:
                    return HomeFragment.newInstance(3);

            }
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}