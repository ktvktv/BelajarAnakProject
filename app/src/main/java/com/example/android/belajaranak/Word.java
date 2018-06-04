package com.example.android.belajaranak;

import java.io.Serializable;

/**
 * Created by User on 3/24/2018.
 */

public class Word implements Serializable{

    //Text that will be displayed.
    private String wordIndo;

    private String wordEnglish;

    private String sentenceIndo;

    private String sentenceEnglish;
    //Image that will be displayed.
    private int Image_ID;

    private int audioIndo;

    private int audioEnglish;



    public Word(String wordIndo, String wordEnglish, String sentenceIndo, String sentenceEnglish, int audioIndo, int audioEnglish, int Image_ID){
        this.wordIndo = wordIndo;
        this.wordEnglish = wordEnglish;
        this.sentenceIndo = sentenceIndo;
        this.sentenceEnglish = sentenceEnglish;
        this.audioIndo = audioIndo;
        this.audioEnglish = audioEnglish;
        this.Image_ID = Image_ID;
    }

    public String getWordIndo(){
        return wordIndo;
    }

    public String getWordEnglish() {return wordEnglish; }

    public String getSentenceIndo() {return sentenceIndo;}

    public String getSentenceEnglish() {return sentenceEnglish;}

    public int getAudioIndo() {return audioIndo;}

    public int getAudioEnglish() {return audioEnglish;}

    public int getImage_ID(){
        return Image_ID;
    }
}
