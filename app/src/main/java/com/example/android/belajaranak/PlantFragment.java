package com.example.android.belajaranak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by User on 3/24/2018.
 */

public class PlantFragment extends Fragment {

    public PlantFragment(){};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        //View that will be displayed.

        words.add(new Word(getString(R.string.Cactus),getString(R.string.CactusE),getString(R.string.Scactus),getString(R.string.ScactusE),R.raw.kaktus,R.raw.cactus,R.drawable.cactus));
        words.add(new Word(getString(R.string.Bamboo),getString(R.string.BambooE),getString(R.string.Sbamboo),getString(R.string.SbambooE),R.raw.bambu,R.raw.bamboo,R.drawable.bamboo));
        words.add(new Word(getString(R.string.Sunflower),getString(R.string.SunflowerE),getString(R.string.Ssunflower),getString(R.string.SsunflowerE),R.raw.bungamatahari,R.raw.sunflower,R.drawable.sunflower));
        words.add(new Word(getString(R.string.Corn),getString(R.string.CornE),getString(R.string.Scorn),getString(R.string.ScornE),R.raw.jagung,R.raw.corn,R.drawable.corn));
        words.add(new Word(getString(R.string.Broccoli),getString(R.string.BroccoliE),getString(R.string.Sbroccoli),getString(R.string.SbroccoliE),R.raw.brokoli,R.raw.brocolli,R.drawable.brocoli));
        words.add(new Word(getString(R.string.Mushroom),getString(R.string.MushroomE),getString(R.string.Smushroom),getString(R.string.SmushroomE),R.raw.jamur,R.raw.mushroom,R.drawable.mushroom));
        words.add(new Word(getString(R.string.Rose),getString(R.string.RoseE),getString(R.string.Srose),getString(R.string.SroseE),R.raw.mawar,R.raw.rose,R.drawable.rose));
        words.add(new Word(getString(R.string.PalmTree),getString(R.string.PalmTreeE),getString(R.string.SpalmTree),getString(R.string.SpalmTreeE),R.raw.pohonpalem,R.raw.palmtree,R.drawable.palmtree));


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
