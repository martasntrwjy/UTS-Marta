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
    private RecyclerView rvHeroes;
    private ArrayList<Minuman> list = new ArrayList<>();

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvHeroes = view.findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecyclerList();

    }

    public ArrayList<Minuman> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Minuman> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Minuman Minuman = new Minuman();
            Minuman.setName(dataName[i]);
            Minuman.setDescription(dataDescription[i]);
            Minuman.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(Minuman);
        }
        return listHero;
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(getContext()));
        ListMinumanAdapter listHeroAdapter = new ListMinumanAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}