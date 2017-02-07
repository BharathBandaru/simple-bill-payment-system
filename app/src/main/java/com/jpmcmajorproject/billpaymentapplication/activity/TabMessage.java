package com.jpmcmajorproject.billpaymentapplication.activity;


import com.jpmcmajorproject.billpaymentapplication.R;
import com.jpmcmajorproject.billpaymentapplication.fragment.HomeFragment;
import com.roughike.bottombar.BottomBar;

/**
 * Created by iiro on 7.6.2016.
 */
public class TabMessage {
    public static String get(int menuItemId, boolean isReselection) {
        String message = "Content for ";
        switch (menuItemId) {
            case R.id.tab_recents:
                new HomeFragment();
                break;
            case R.id.tab_favorites:
                new HomeFragment();
                break;
            case R.id.tab_nearby:
                new HomeFragment();
                break;

        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }
}
