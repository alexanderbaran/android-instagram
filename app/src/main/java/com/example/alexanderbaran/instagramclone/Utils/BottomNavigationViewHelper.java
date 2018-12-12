package com.example.alexanderbaran.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.alexanderbaran.instagramclone.Home.HomeActivity;
import com.example.alexanderbaran.instagramclone.Likes.LikesActivity;
import com.example.alexanderbaran.instagramclone.Profile.ProfileActivity;
import com.example.alexanderbaran.instagramclone.R;
import com.example.alexanderbaran.instagramclone.Search.SearchActivity;
import com.example.alexanderbaran.instagramclone.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        // https://github.com/ittianyu/BottomNavigationViewEx
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    // Context needs to be final or else can't reference it in the method onNavigationItemSelected.
    public static void enableNavigation(final Context context, BottomNavigationViewEx bottomNavigationViewEx) {
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class);
                        /* Normally you don't need to reference from context when you start an activity, but since we are in an another object class,
                        it needs to know what context you are gonna be referencing it from. */
                        // https://stackoverflow.com/questions/6972295/switching-activities-without-animation
//                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_search:
                        Intent intent2 = new Intent(context, SearchActivity.class);
//                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_circle:
                        Intent intent3 = new Intent(context, ShareActivity.class);
//                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_alert:
                        Intent intent4 = new Intent(context, LikesActivity.class);
//                        intent4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent4);
                        break;
                    case R.id.ic_profile:
                        Intent intent5 = new Intent(context, ProfileActivity.class);
//                        intent5.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(intent5);
                        break;
                }
                return false;
            }
        });
    }
}
