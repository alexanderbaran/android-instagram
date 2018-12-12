package com.example.alexanderbaran.instagramclone.Home;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexanderbaran.instagramclone.R;

public class MessagesFragment extends Fragment {

    private static final String TAG = "MessagesFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // We don't need super because we are going to declare the view ourselves.
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        return view;
    }
}
