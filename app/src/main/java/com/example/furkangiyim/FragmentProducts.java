package com.example.furkangiyim;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class FragmentProducts extends Fragment  {
    private View myFragment;
    private TabLayout tablayout;
    private ArrayList<String> fragmentBaslıkListesi;
    private ViewPager2 viewPager2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_products_layout,container,false);

        fragmentBaslıkListesi = new ArrayList<String>();

        fragmentBaslıkListesi.add("Kadın");
        fragmentBaslıkListesi.add("Erkek");
        fragmentBaslıkListesi.add("Bebek");
        fragmentBaslıkListesi.add("Çocuk");
        fragmentBaslıkListesi.add("Genç");
        fragmentBaslıkListesi.add("Ayakkabı");
        fragmentBaslıkListesi.add("Aksesuar");


        viewPager2 = myFragment.findViewById(R.id.viewpager2);
        tablayout = myFragment.findViewById(R.id.tablayout);
        viewPager2.setAdapter(new MyViewPagerAdapter(getActivity()));
        new TabLayoutMediator(tablayout,viewPager2,
                (tab,position)->tab.setText(fragmentBaslıkListesi.get(position))).attach();

        
        return myFragment;

    }


    private class MyViewPagerAdapter extends FragmentStateAdapter {

        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        private final Fragment[] mFragments = new Fragment[] {new FragmentWoman(), new FragmentMan(), new FragmentBaby(), new FragmetChild(), new FragmentYoung(), new FragmentShoe(), new FragmentAccessory() };

        @Override
        public int getItemCount() {
            return mFragments.length;//Number of fragments displayed
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragments[position];
        }
    }

}
