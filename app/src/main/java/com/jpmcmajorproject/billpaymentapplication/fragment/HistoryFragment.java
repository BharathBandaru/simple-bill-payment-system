package com.jpmcmajorproject.billpaymentapplication.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpmcmajorproject.billpaymentapplication.R;

import static com.jpmcmajorproject.billpaymentapplication.fragment.HomeFragment.ARG_PAGE;

/**
 * Created by Bharath on 07/02/17.
 */

public class HistoryFragment extends Fragment {
    public HistoryFragment() {
        // Required empty public constructor
    }
    public static HistoryFragment newInstance(int pageNo) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.splash, container, false);
    }
}
