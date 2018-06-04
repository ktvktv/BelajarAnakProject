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

public class ColorFragment extends Fragment {

    public ColorFragment(){};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getString(R.string.Red),getString(R.string.RedE),getString(R.string.Sred),getString(R.string.SredE),R.raw.merah,R.raw.red,R.drawable.merah));
        words.add(new Word(getString(R.string.Blue),getString(R.string.BlueE),getString(R.string.Sblue),getString(R.string.SblueE),R.raw.biru,R.raw.blue,R.drawable.biru));
        words.add(new Word(getString(R.string.Green),getString(R.string.GreenE),getString(R.string.Sgreen),getString(R.string.SgreenE),R.raw.hijau,R.raw.green,R.drawable.hijau));
        words.add(new Word(getString(R.string.Yellow),getString(R.string.YellowE),getString(R.string.Syellow),getString(R.string.SyellowE),R.raw.kuning,R.raw.yellow,R.drawable.kuning));
        words.add(new Word(getString(R.string.White),getString(R.string.WhiteE),getString(R.string.Swhite),getString(R.string.SwhiteE),R.raw.putih,R.raw.white,R.drawable.putih));
        words.add(new Word(getString(R.string.Black),getString(R.string.BlackE),getString(R.string.Sblack),getString(R.string.SblackE),R.raw.hitam,R.raw.black,R.drawable.hitam));
        words.add(new Word(getString(R.string.Purple),getString(R.string.PurpleE),getString(R.string.Spurple),getString(R.string.SpurpleE),R.raw.ungu,R.raw.purple,R.drawable.ungu));
        words.add(new Word(getString(R.string.Orange),getString(R.string.OrangeE),getString(R.string.Sorange),getString(R.string.SorangeE),R.raw.jingga,R.raw.orange,R.drawable.jingga));

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
