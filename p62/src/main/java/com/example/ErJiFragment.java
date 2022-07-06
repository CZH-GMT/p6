package com.example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p62.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErJiFragment extends Fragment {

    public ErJiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_er_ji, container, false);



        return inflate;
    }
}
