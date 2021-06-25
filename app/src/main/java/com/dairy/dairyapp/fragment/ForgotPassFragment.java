package com.dairy.dairyapp.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dairy.dairyapp.R;
import com.dairy.dairyapp.databinding.FragmentForgotPassBinding;


public class ForgotPassFragment extends Fragment {
        FragmentForgotPassBinding binding;
   public ForgotPassFragment() {
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
                    inflater, R.layout.fragment_forgot_pass, container, false);
            View view = binding.getRoot();
            init();
            return view;

    }
    private void init() {
        binding.nextBtn.setOnClickListener(v->{
            Toast.makeText(getContext(), "Email Sent", Toast.LENGTH_SHORT).show();
          /*  startActivity(new Intent(getActivity(), HomeActivity.class));*/
        });
    }
}