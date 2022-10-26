package com.marta.navigationdrawer;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvMinuman;
    private ArrayList<Minuman> list = new ArrayList<>();

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvMinuman = view.findViewById(R.id.rv_Minuman);
        rvMinuman.setHasFixedSize(true);

        list.addAll(getListMinuman());
        showRecyclerList();

    }

    public ArrayList<Minuman> getListMinuman() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Minuman> listMinuman = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Minuman Minuman = new Minuman();
            Minuman.setName(dataName[i]);
            Minuman.setDescription(dataDescription[i]);
            Minuman.setPhoto(dataPhoto.getResourceId(i, -1));
            listMinuman.add(Minuman);
        }
        return listMinuman;
    }

    private void showRecyclerList() {
        rvMinuman.setLayoutManager(new LinearLayoutManager(getContext()));
        ListMinumanAdapter listMinumanAdapter = new ListMinumanAdapter(list);
        rvMinuman.setAdapter(listMinumanAdapter);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}