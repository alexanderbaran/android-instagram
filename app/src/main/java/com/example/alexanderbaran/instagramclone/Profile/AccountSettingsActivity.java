package com.example.alexanderbaran.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.alexanderbaran.instagramclone.R;
import com.example.alexanderbaran.instagramclone.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";

    private Context mContext;

    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: started");
        mViewPager = findViewById(R.id.container); // Autocomplete does not work here because it is being included in the xml file.
        mRelativeLayout = findViewById(R.id.relLayout1);

        setupSettingsList();
        setupFragments();

        // Setup the backarrow for navigating back to "ProfileActivity".
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to 'ProfileActivity");
                finish(); // Since this is an activity we can just do finish and it will bring us back to the other activityA.
            }
        });
    }

    private void setupFragments() {
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment)); // Fragment 0
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment)); // Fragment 1
    }

    private void setViewPager(int fragmentNumber) {
        // https://stackoverflow.com/questions/11556607/android-difference-between-invisible-and-gone
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: Navigating to fragment #: " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList() {
        Log.d(TAG, "setupSettingsList: initializing 'Account Settings' list.");
        ListView listView = findViewById(R.id.lvAccountSettings);

        ArrayList<String> options  = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment)); // Fragment 0
        options.add(getString(R.string.sign_out_fragment)); // Fragment 1

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: Navigating to fragment #: " + position);
                setViewPager(position);
            }
        });
    }
}
