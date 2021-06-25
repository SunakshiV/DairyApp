package com.dairy.dairyapp.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dairy.dairyapp.model.NewsModel;
import com.dairy.dairyapp.R;
import com.dairy.dairyapp.adapter.NewsAdapter;
import com.dairy.dairyapp.adapter.SliderPagerAdapter;
import com.dairy.dairyapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
      FragmentHomeBinding binding;
    ArrayList arrayList;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list;
    private TextView[] dots;
    int page_position = 0;
    public HomeFragment() {
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
                inflater, R.layout.fragment_home, container, false);
        View view = binding.getRoot();
        topList();
        pager();
        addBottomDots(0);
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                binding.vpSlider.setCurrentItem(page_position, true);
            }
        };
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);
        return view;
    }
    private void pager() {
        slider_image_list = new ArrayList<Integer>();
        slider_image_list.add(R.drawable.bannerimage);
        slider_image_list.add(R.drawable.bannerimage);
        slider_image_list.add(R.drawable.bannerimage);
        slider_image_list.add(R.drawable.bannerimage);
        sliderPagerAdapter = new SliderPagerAdapter(getActivity(), slider_image_list);
        binding.vpSlider.setAdapter(sliderPagerAdapter);

        binding.vpSlider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        binding.llDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            binding.llDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }
    private void topList() {
        arrayList = new ArrayList();
        arrayList.add(new NewsModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new NewsModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new NewsModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new NewsModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new NewsModel("Reference site about Lorem", R.drawable.star));
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false);
        binding.recyclerNews.setLayoutManager(manager);
        binding.recyclerNews.setAdapter(new NewsAdapter(getActivity(),arrayList));
    }
}