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
import com.dairy.dairyapp.databinding.FragmentSignUpBinding;


public class SignUpFragment extends Fragment {
    FragmentSignUpBinding binding;
    public SignUpFragment() {
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
                inflater, R.layout.fragment_sign_up, container, false);
        View view = binding.getRoot();
        init();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }

    private void init() {
       binding.nextBtn.setOnClickListener(v->{
         startActivity(new Intent(getActivity(), HomeActivity.class));
       });
    }
}