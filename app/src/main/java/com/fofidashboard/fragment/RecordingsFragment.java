package com.fofidashboard.fragment;

/**
 * Created by prabhavathi on 3/11/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fofidashboard.R;

public class RecordingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recordings_fragment, container, false);
    }
}