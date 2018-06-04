package com.example.android.belajaranak;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by User on 3/24/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words){
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word word = getItem(position);

        TextView textView = (TextView) listView.findViewById(R.id.text_word);
        textView.setText(word.getWordIndo());

        ImageView imageView = (ImageView) listView.findViewById(R.id.image_word);
        imageView.setImageResource(word.getImage_ID());

        return listView;
    }
}
