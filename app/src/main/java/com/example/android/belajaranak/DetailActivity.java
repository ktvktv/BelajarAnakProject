package com.example.android.belajaranak;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

/**
 * Created by User on 3/24/2018.
 */

public class DetailActivity extends AppCompatActivity {

    private ImageView picture;

    private TextView word_indo;

    private TextView word_english;

    private TextView sentence_indo;

    private TextView sentence_english;

    private ImageButton word_indo_button;

    private ImageButton word_english_button;

    private View.OnClickListener mOnClickListener;

    private View.OnClickListener mEnglishOnClickListener;

    private MediaPlayer mediaPlayer;

    private AudioManager mAudioManager;

    private int audio, audioEnglish, pictureImage;

    private String wordIndonesia, wordEnglish, sentenceIndonesia, sentenceEnglish;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK|| i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                mediaPlayer.pause();

                mediaPlayer.seekTo(0);
            }
            else if(i == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
            else if(i == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        Intent intent = getIntent();

        picture = (ImageView) findViewById(R.id.image_detail);

        word_indo = (TextView) findViewById(R.id.word_indonesia);

        word_english = (TextView) findViewById(R.id.word_english);

        sentence_indo = (TextView) findViewById(R.id.sentence_indonesia);

        sentence_english = (TextView) findViewById(R.id.sentence_english);

        word_indo_button = (ImageButton) findViewById(R.id.word_indonesia_button);
        word_indo_button.setImageResource(R.drawable.audiobutton);

        word_english_button = (ImageButton) findViewById(R.id.word_english_button);
        word_english_button.setImageResource(R.drawable.audiobutton);

        Word word = (Word) intent.getSerializableExtra(getString(R.string.details));

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    mediaPlayer = MediaPlayer.create(DetailActivity.this,audio);

                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        };

        mEnglishOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    mediaPlayer = MediaPlayer.create(DetailActivity.this,audioEnglish);

                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        };

        word_indo_button.setOnClickListener(mOnClickListener);
        word_english_button.setOnClickListener(mEnglishOnClickListener);

        picture.setImageResource(word.getImage_ID());
        word_indo.setText(word.getWordIndo());
        word_english.setText(word.getWordEnglish());
        sentence_indo.setText(word.getSentenceIndo());
        sentence_english.setText(word.getSentenceEnglish());
        audio = word.getAudioIndo();
        audioEnglish = word.getAudioEnglish();
    }

    private void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();

            mediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
