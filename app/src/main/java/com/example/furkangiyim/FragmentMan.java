package com.example.furkangiyim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class FragmentMan extends Fragment {
    private RecyclerView erkekrv;
    private ArrayList<String> kategoriler;
    private RVAdapter adapter;
    private View myView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_man_layout,container,false);
        erkekrv = myView.findViewById(R.id.erkekrv);
        erkekrv.setHasFixedSize(true);
        //rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        erkekrv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        kategoriler = new ArrayList<>();
        kategoriler.add("Erkek Mont");
        kategoriler.add("Erkek Sweatshirt");
        kategoriler.add("Erkek Jean");
        kategoriler.add("Erkek Ceket");
        kategoriler.add("Erkek Bluz");
        kategoriler.add("Erkek Kazak");

        adapter = new RVAdapter(getContext(), kategoriler, "men");
        erkekrv.setAdapter(adapter);
        return myView;
    }
}
