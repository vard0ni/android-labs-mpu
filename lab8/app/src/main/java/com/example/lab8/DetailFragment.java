package com.example.lab8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
    public void setSelectedItem(String selectedItem) {
        TextView desc = getView().findViewById(R.id.detailsText);
        ImageView photo = getView().findViewById(R.id.photo);
        if (selectedItem == "array") {
            desc.setText(R.string.array);
            photo.setImageResource(R.drawable.array);
        }
        if (selectedItem == "stack") {
            desc.setText(R.string.stack);
            photo.setImageResource(R.drawable.stack);
        }
        if (selectedItem == "queue") {
            desc.setText(R.string.queue);
            photo.setImageResource(R.drawable.queue);
        }
        if (selectedItem == "linkedlist") {
            desc.setText(R.string.linkedlist);
            photo.setImageResource(R.drawable.linkedlist);
        }
        if (selectedItem == "graph") {
            desc.setText(R.string.graph);
            photo.setImageResource(R.drawable.graph);
        }
        if (selectedItem == "tree") {
            desc.setText(R.string.tree);
            photo.setImageResource(R.drawable.tree);
        }
        if (selectedItem == "prefixtree") {
            desc.setText(R.string.prefixtree);
            photo.setImageResource(R.drawable.prefixtree);
        }
        if (selectedItem == "hashtable") {
            desc.setText(R.string.hashtable);
            photo.setImageResource(R.drawable.hashtable);
        }
    }
}