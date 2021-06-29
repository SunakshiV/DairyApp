package com.dairy.dairyapp.fragment.setting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dairy.dairyapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditPassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditPassFragment extends Fragment {



    public EditPassFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_pass, container, false);
    }
}