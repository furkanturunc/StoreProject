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

public class FragmetChild extends Fragment {
    private RecyclerView rv;
    private ArrayList<String> kategoriler;
    private ArrayList<Bitmap> imageList;
    private RVAdapter adapter;
    private View myView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_child_layout,container,false);
        rv = myView.findViewById(R.id.cocukrv);
        rv.setHasFixedSize(true);
        //rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        kategoriler = new ArrayList<>();
        kategoriler.add("Çocuk Mont");
        kategoriler.add("Çocuk Sweatshirt");
        kategoriler.add("Çocuk Jean");
        kategoriler.add("Çocuk Ceket");
        kategoriler.add("Çocuk Bluz");
        kategoriler.add("Çocuk Kazak");

        adapter = new RVAdapter(getContext(), kategoriler, "children");
        rv.setAdapter(adapter);
        return myView;
    }
}



