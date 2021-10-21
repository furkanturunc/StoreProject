package com.example.furkangiyim;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FragmentWoman extends Fragment {
    private RecyclerView kadınrv;
    private ArrayList<String> kategoriler;
    private ArrayList<StorageReference> imageList;
    private RVAdapter adapter;
    private View myView;
    private StorageReference mStorageRef, mStorageRef2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_woman_layout,container,false);
        kadınrv = myView.findViewById(R.id.kadınrv);
        kadınrv.setHasFixedSize(true);
        //kadınrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        kadınrv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        kategoriler = new ArrayList<>();
        kategoriler.add("Mont");
        kategoriler.add("Sweatshirt");
        kategoriler.add("Jean");
        kategoriler.add("Ceket");
        kategoriler.add("Bluz");
        kategoriler.add("Kazak");


        adapter = new RVAdapter(getContext(), kategoriler, "women");
        kadınrv.setAdapter(adapter);



        return myView;
    }
}

