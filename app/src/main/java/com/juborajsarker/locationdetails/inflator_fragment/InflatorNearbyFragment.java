package com.juborajsarker.locationdetails.inflator_fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juborajsarker.locationdetails.R;
import com.juborajsarker.locationdetails.fragment.OtherLocationFragment;
import com.juborajsarker.locationdetails.fragment.YourLocationFragment;


public class InflatorNearbyFragment extends Fragment {

    View view;


    public InflatorNearbyFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inflator_nearby, container, false);

        ViewPager vp_pages= (ViewPager) view.findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new FragmentAdapter(getActivity().getSupportFragmentManager());
        vp_pages.setAdapter(pagerAdapter);

        TabLayout tbl_pages= (TabLayout) view.findViewById(R.id.tbl_pages);
        tbl_pages.setupWithViewPager(vp_pages);



        return view;
    }


    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new YourLocationFragment();
                case 1:
                    return new OtherLocationFragment();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                //
                //Your tab titles
                //
                case 0:return "Your Location";
                case 1:return "Other Location";
                default:return null;
            }

        }
    }

}
