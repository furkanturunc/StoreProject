package com.example.furkangiyim;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentBaby extends Fragment {
    private RecyclerView rv;
    private ArrayList<String> kategoriler;
    private ArrayList<Bitmap> imageList;
    private RVAdapter adapter;
    private View myView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_baby_layout,container,false);
        rv = myView.findViewById(R.id.bebekrv);
        rv.setHasFixedSize(true);
        //rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        kategoriler = new ArrayList<>();
        kategoriler.add("Bebek Mont");
        kategoriler.add("Bebek Sweatshirt");
        kategoriler.add("Bebek Jean");
        kategoriler.add("Bebek Ceket");
        kategoriler.add("Bebek Bluz");
        kategoriler.add("Bebek Kazak");

        adapter = new RVAdapter(getContext(), kategoriler, null);
        rv.setAdapter(adapter);
        return myView;
    }
}


