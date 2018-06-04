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

public class FamilyFragment extends Fragment {

    public FamilyFragment(){};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        //View that will be displayed.
        words.add(new Word(getString(R.string.Father),getString(R.string.FatherE),getString(R.string.Sfather),getString(R.string.SfatherE),R.raw.ayah,R.raw.father,R.drawable.father));
        words.add(new Word(getString(R.string.Mother),getString(R.string.MotherE),getString(R.string.Smother),getString(R.string.SmotherE),R.raw.ibu,R.raw.mother,R.drawable.mother));
        words.add(new Word(getString(R.string.Brother),getString(R.string.BrotherE),getString(R.string.Sbrother),getString(R.string.SbrotherE),R.raw.saudaralakilaki,R.raw.brother,R.drawable.brother));
        words.add(new Word(getString(R.string.Sister),getString(R.string.SisterE),getString(R.string.Ssister),getString(R.string.SsisterE),R.raw.saudaraperempuan,R.raw.sister,R.drawable.sister));
        words.add(new Word(getString(R.string.Grandfather),getString(R.string.GrandfatherE),getString(R.string.Sgrandfather),getString(R.string.SgrandfatherE),R.raw.kakek,R.raw.grandfather,R.drawable.grandfather));
        words.add(new Word(getString(R.string.Grandmother),getString(R.string.GrandmotherE),getString(R.string.Sgrandmother),getString(R.string.SgrandmotherE),R.raw.nenek,R.raw.grandmother,R.drawable.grandmother));
        words.add(new Word(getString(R.string.Uncle),getString(R.string.UncleE),getString(R.string.Suncle),getString(R.string.SuncleE),R.raw.paman,R.raw.uncle,R.drawable.uncle));
        words.add(new Word(getString(R.string.Aunty),getString(R.string.AuntyE),getString(R.string.Saunty),getString(R.string.SauntyE),R.raw.tante,R.raw.aunty,R.drawable.aunty));

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
