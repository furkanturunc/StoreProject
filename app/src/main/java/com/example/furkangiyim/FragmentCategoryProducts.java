package com.example.furkangiyim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class FragmentCategoryProducts extends Fragment {

    private View myView;
    private RVAdapter adapter;
    private RecyclerView rv;
    String fileName;
    int category;

    public FragmentCategoryProducts(String fileName, int category) {
        this.fileName = fileName;
        this.category = category;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_man_layout,container,false);
        rv = myView.findViewById(R.id.erkekrv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapter = new RVAdapter(getContext(), null, fileName+"/"+category);
        rv.setAdapter(adapter);
        return myView;
    }
}
