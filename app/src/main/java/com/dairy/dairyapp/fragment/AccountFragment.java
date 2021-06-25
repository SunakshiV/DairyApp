package com.dairy.dairyapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dairy.dairyapp.R;
import com.dairy.dairyapp.adapter.NewsAdapter;
import com.dairy.dairyapp.databinding.FragmentAccountBinding;
import com.dairy.dairyapp.databinding.ItemAccountBinding;
import com.dairy.dairyapp.databinding.ItemNewsBinding;
import com.dairy.dairyapp.model.AccountModel;

import java.util.ArrayList;

public class AccountFragment extends Fragment {
    ArrayList arrayList;
    FragmentAccountBinding binding;
    public AccountFragment() {
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
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_account, container, false);
        View view = binding.getRoot();
        init();

        return view;
    }

    private void init() {
        arrayList = new ArrayList();
        arrayList.add(new AccountModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new AccountModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new AccountModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new AccountModel("Reference site about Lorem", R.drawable.star));
        arrayList.add(new AccountModel("Reference site about Lorem", R.drawable.star));
        GridLayoutManager manager = new GridLayoutManager(getContext(),
                1, GridLayoutManager.VERTICAL, false);
        binding.recyclerAccount.setLayoutManager(manager);
        binding.recyclerAccount.setAdapter(new AccountAdapter(getActivity(),arrayList));
    }

     class AccountAdapter extends  RecyclerView.Adapter<AccountAdapter.ViewHolder> {

        Context context;
        ArrayList dataList;
    public AccountAdapter(FragmentActivity dataModelList, ArrayList ctx) {
            this.context = dataModelList;
            dataList = ctx;
        }

        @Override
        public AccountAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
            ItemAccountBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.getContext()),
                    R.layout.item_account, parent, false);

            return new AccountAdapter.ViewHolder(binding);
        }

         @Override
         public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

         }




        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ItemAccountBinding itemRowBinding;

            public ViewHolder(ItemAccountBinding itemRowBinding) {
                super(itemRowBinding.getRoot());
                this.itemRowBinding = itemRowBinding;
            }

        }
    }
}