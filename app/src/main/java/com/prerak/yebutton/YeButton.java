package com.prerak.yebutton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class YeButton extends AppCompatActivity {

    //Array of all sounds
    MediaPlayer[] mySounds;

    // Individual sounds stored at YeButton/app/src/main/res/raw/
    MediaPlayer mySound;
    MediaPlayer famousSound;
    MediaPlayer answerssway;
    MediaPlayer beenlikethat;
    MediaPlayer bush;
    MediaPlayer gaga;
    MediaPlayer inmycode;
    MediaPlayer justtoldyou;
    MediaPlayer rockstar;
    MediaPlayer youngmetro;
    MediaPlayer whatsgood;
    MediaPlayer wavybaby;
    MediaPlayer wavydude;
    MediaPlayer hityebutton;
    MediaPlayer currentlyPlaying;

    // Total number of sounds. Created in onCreate, but also used in playMyMusic()
    int numSounds;

    // Random used to determine next sound to play
    Random myRandom = new Random();


    /**
     * Pauses currently playing song... not actually sure what happens if nothing is playing
     */
    protected void onPause() {
        super.onPause();
        currentlyPlaying.pause();
        //currentlyPlaying.release();

    }

    /**
     * This is run as soon as the 'activity'/main screen is opened (so immediately)
     * Initializes all the sounds with the files located at YeButton/app/src/main/res/raw/
     * Stores all songs in MediaPlayer[] mySounds
     *
     * @param savedInstanceState idk, android mumbo jumbo
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ye_button);

//        Button yeButton = (Button) findViewById(R.id.yeButton);
//        yeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //playSound();
//            }
//        });

        // Initialize songs
        mySound = MediaPlayer.create(this, R.raw.stronger);
        famousSound = MediaPlayer.create(this, R.raw.famous);
        answerssway = MediaPlayer.create(this, R.raw.answerssway);
        beenlikethat = MediaPlayer.create(this, R.raw.beenlikethat);
        bush = MediaPlayer.create(this, R.raw.bush);
        gaga = MediaPlayer.create(this, R.raw.gaga);
        inmycode = MediaPlayer.create(this, R.raw.inmycode);
        justtoldyou = MediaPlayer.create(this, R.raw.justtoldyou);
        rockstar = MediaPlayer.create(this, R.raw.rockstar);
        youngmetro = MediaPlayer.create(this, R.raw.youngmetro);
        whatsgood = MediaPlayer.create(this, R.raw.whatsgood);
        wavybaby = MediaPlayer.create(this, R.raw.wavybaby);
        wavydude = MediaPlayer.create(this, R.raw.wavydude);
        hityebutton = MediaPlayer.create(this, R.raw.hityebutton);


        // Store all sounds in MediaPlayer[] mySounds
        mySounds = new MediaPlayer[]{mySound, famousSound, answerssway, beenlikethat, bush, gaga,
                inmycode, justtoldyou, rockstar, youngmetro, whatsgood, wavybaby, wavydude,
                hityebutton};
        numSounds = mySounds.length;
        System.out.println("mySound initialized");

    }

    /**
     * Called by the 'YE' button. Plays track
     * @param view android mumbo jumbo
     */
    public void playMyMusic(View view) {
        // Internal testing
        System.out.print("playMyMusic called");

        // If sound is currently playing, want to stop playing it first, THEN play a new sound.
        // Else, it will play multiple sounds simultaneously
        if (currentlyPlaying != null) {
            onPause();
        }

        // Select the next song to play from the mySounds[] array and store in currentlyPlaying
        int nowPlayingTrackNum = myRandom.nextInt(numSounds);
        currentlyPlaying = mySounds[nowPlayingTrackNum];

        // Need to make sure the sound is starting from 0 seconds, otherwise, if it was playing
        // before it will resume at that point in the song
        currentlyPlaying.seekTo(0);
        currentlyPlaying.start();

        // Internal testing
        System.out.println(numSounds);
    }

    /**
     * Called by the 'PAUSE' button
     * 'Pauses' current song, but actually stops it and resets the track time to 0 seconds
     * @param view android mumbo jumbo
     */
    public void onPause(View view) {
        // Calls my own onPause() method which is more useful since I know how to call it from other
        // methods I write
        onPause();
    }
}
