package com.example.alexanderbaran.instagramclone.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "SectionsStatePagerAdapt";

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> mFragments = new HashMap<>();
    private final HashMap<String, Integer> mFragmentNumbers = new HashMap<>();
    private final HashMap<Integer, String> mFragmentNames = new HashMap<>();

    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String fragmentName) {
        mFragmentList.add(fragment);
        Integer fragmentNumber = mFragmentList.size()-1;
        mFragments.put(fragment, fragmentNumber);
        mFragmentNumbers.put(fragmentName, fragmentNumber);
        mFragmentNames.put(fragmentNumber, fragmentName);
    }

    /**
     * Returns the fragment number with the name @param.
     * @param fragmentName
     * @return
     */
    public Integer getFragmentNumber(String fragmentName) {
        // Checking HasMap for if something exists.
        if (mFragmentNumbers.containsKey(fragmentName)) {
            return mFragmentNumbers.get(fragmentName);
        } else {
            return null;
        }
    }

    /**
     * Returns the fragment number with the fragment @param.
     * @param fragment
     * @return
     */
    public Integer getFragmentNumber(Fragment fragment) {
        // Checking HasMap for if something exists.
        if (mFragments.containsKey(fragment)) {
            return mFragments.get(fragment);
        } else {
            return null;
        }
    }

    /**
     * Returns the fragment name with the fragment @param.
     * @param fragmentNumber
     * @return
     */
    public String getFragmentName(Integer fragmentNumber) {
        // Checking HasMap for if something exists.
        if (mFragmentNames.containsKey(fragmentNumber)) {
            return mFragmentNames.get(fragmentNumber);
        } else {
            return null;
        }
    }
}
