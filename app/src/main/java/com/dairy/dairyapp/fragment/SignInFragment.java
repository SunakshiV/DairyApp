package com.dairy.dairyapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dairy.dairyapp.R;
import com.dairy.dairyapp.activities.HomeActivity;
import com.dairy.dairyapp.databinding.FragmentSignInBinding;

public class SignInFragment extends Fragment {
    FragmentSignInBinding binding;
    public SignInFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_sign_in, container, false);
        View view = binding.getRoot();
        init();
        return view;

    }
    private void init() {
        binding.nextBtn.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), HomeActivity.class));
        });
    }
}