package com.example.myapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class favoriteFragment extends Fragment {

    private RecyclerView rvHero;
    private ArrayList<ModelHero> listHero = new ArrayList<>();

    public favoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tampil =  inflater.inflate(R.layout.fragment_favorite, container, false);

        rvHero = tampil.findViewById(R.id.rvHero);
        rvHero.setHasFixedSize(true);
        listHero.addAll(DataHero.getListHero());

        show();

        return tampil;
    }

    private void show() {
        rvHero.setLayoutManager(new LinearLayoutManager(getActivity()));
        HeroAdapter heroAdapter = new HeroAdapter(getActivity());
        heroAdapter.setModelHeroes(listHero);
        rvHero.setAdapter(heroAdapter);
    }

}
