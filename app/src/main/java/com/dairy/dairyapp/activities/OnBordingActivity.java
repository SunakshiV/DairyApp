package com.dairy.dairyapp.activities;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.dairy.dairyapp.R;
import com.dairy.dairyapp.adapter.ViewPagerAdapter;
import com.dairy.dairyapp.databinding.ActivityOnBordingBinding;
import com.dairy.dairyapp.fragment.ForgotPassFragment;
import com.dairy.dairyapp.fragment.SignInFragment;
import com.dairy.dairyapp.fragment.SignUpFragment;

public class OnBordingActivity extends BaseActivity {
    ActivityOnBordingBinding binding;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_bording);
        fullScreen();
        init();
    }

    private void init() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.add(new SignUpFragment(), "Sign Up");
        viewPagerAdapter.add(new SignInFragment(), "Sign In");
        viewPagerAdapter.add(new ForgotPassFragment(), "Forgot Password");
        binding.viewpager.setAdapter(viewPagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewpager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}