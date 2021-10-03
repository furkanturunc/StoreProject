package com.example.furkangiyim;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewNesneTutucu> {
    private Context context;
    private List<String> kategoriler;
    private String file;
    private Fragment fragment;

    public RVAdapter(Context context, List<String> kategoriler, String s) {
        this.context = context;
        this.kategoriler = kategoriler;
        file = s;
    }

    public class CardViewNesneTutucu extends RecyclerView.ViewHolder {

        public TextView textView;
        public CardView kategori_cardview;
        public ImageButton imageButton;


        public CardViewNesneTutucu (View view) {
            super(view);
            textView = view.findViewById(R.id.textView5);
            kategori_cardview = view.findViewById(R.id.kategori_cardview);
            imageButton = view.findViewById(R.id.imageButton);
        }
    }

    @NonNull
    @Override
    public CardViewNesneTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_design,parent, false);

        return new CardViewNesneTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewNesneTutucu holder, int position) {

        StorageReference imageRef = FirebaseStorage.getInstance().getReference(file).child(position + 1 + ".jpg");

        try {
            File localfile = File.createTempFile("tshirt", ".jpg");
            imageRef.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                    holder.imageButton.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }




        String kategori = kategoriler.get(position);
        holder.textView.setText(kategori);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Seçtiğiniz Kategori: " + kategori, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return kategoriler.size();
    }

}
