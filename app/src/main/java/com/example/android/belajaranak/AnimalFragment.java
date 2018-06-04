package com.example.android.belajaranak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by User on 3/24/2018.
 */

public class AnimalFragment extends android.support.v4.app.Fragment {

    public AnimalFragment(){};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        //View that will be displayed.
        words.add(new Word(getString(R.string.Dog),getString(R.string.DogE),getString(R.string.Sdog),getString(R.string.SdogE),R.raw.anjing,R.raw.dog,R.drawable.anjing));
        words.add(new Word(getString(R.string.Cat),getString(R.string.CatE),getString(R.string.Scat),getString(R.string.ScatE),R.raw.kucing,R.raw.cat,R.drawable.kucing));
        words.add(new Word(getString(R.string.Fish),getString(R.string.FishE),getString(R.string.Sfish),getString(R.string.SfishE),R.raw.ikan,R.raw.fish,R.drawable.ikan));
        words.add(new Word(getString(R.string.Bird),getString(R.string.BirdE),getString(R.string.Sbird),getString(R.string.SbirdE),R.raw.burung,R.raw.bird,R.drawable.burung));
        words.add(new Word(getString(R.string.Worm),getString(R.string.WormE),getString(R.string.Sworm),getString(R.string.SwormE),R.raw.cacing,R.raw.worm,R.drawable.cacing));
        words.add(new Word(getString(R.string.Chicken),getString(R.string.ChickenE),getString(R.string.Schicken),getString(R.string.SchickenE),R.raw.ayam,R.raw.chicken,R.drawable.ayam));
        words.add(new Word(getString(R.string.Duck),getString(R.string.DuckE),getString(R.string.Sduck),getString(R.string.SduckE),R.raw.bebek,R.raw.duck,R.drawable.bebek));
        words.add(new Word(getString(R.string.Bear),getString(R.string.BearE),getString(R.string.Sbear),getString(R.string.SbearE),R.raw.beruang,R.raw.bear,R.drawable.beruang));

        WordAdapter wordAdapter = new WordAdapter(getContext(), words);

        GridView gridView = (GridView) rootView.findViewById(R.id.word_list);

        gridView.setAdapter(wordAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                intent = new Intent(getContext(), DetailActivity.class);
                Word word = (Word) adapterView.getItemAtPosition(position);
                intent.putExtra(getString(R.string.details),word);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
