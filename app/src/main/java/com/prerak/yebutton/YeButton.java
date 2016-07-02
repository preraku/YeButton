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
    MediaPlayer immaletyou;
    MediaPlayer president;

    // Total number of sounds. Created in onCreate, but also used in playMyMusic()
    int numSounds;

    // Stores last played track. 0 just for the start
    int lastPlayed = 0;

    // Random used to determine next sound to play
    Random myRandom = new Random();

    // Debugging array
    int[] didNotPlay;


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
        immaletyou = MediaPlayer.create(this, R.raw.immaletyou);
        president = MediaPlayer.create(this, R.raw.president);

        // Store all sounds in MediaPlayer[] mySounds
        mySounds = new MediaPlayer[]{answerssway, beenlikethat, bush, gaga,
                inmycode, justtoldyou, rockstar, youngmetro, whatsgood, wavybaby, wavydude,
                hityebutton};
        numSounds = mySounds.length;
        didNotPlay = new int[numSounds];
        System.out.println("mySound initialized");

    }

    /**
     * Called by the 'YE' button. Plays track
     * @param view android mumbo jumbo
     */
    public void playMyMusic(View view) {
        // Internal testing
        //System.out.print("playMyMusic called");

        // If sound is currently playing, want to stop playing it first, THEN play a new sound.
        // Else, it will play multiple sounds simultaneously
        if (currentlyPlaying != null) {
            onPause();
        }

        // Select the next song to play from the mySounds[] array and store in currentlyPlaying
        int nowPlayingTrackNum = myRandom.nextInt(numSounds);
        // Don't play the same sound twice in a row
        while (nowPlayingTrackNum == lastPlayed) {
            nowPlayingTrackNum = myRandom.nextInt(numSounds);
            System.out.println("Prevented repeat");
        }
        lastPlayed = nowPlayingTrackNum;
        currentlyPlaying = mySounds[nowPlayingTrackNum];

        // Need to make sure the sound is starting from 0 seconds, otherwise, if it was playing
        // before it will resume at that point in the song
        currentlyPlaying.seekTo(0);
        currentlyPlaying.start();

        // Internal testing
        System.out.println(lastPlayed);
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

    // Debugging code. To use, uncomment the below and the commented portions of
    // activity_ye_button.xml
//    public void addNoPlay(View view) {
//        didNotPlay[lastPlayed]++;
//    }
//
//    public void debugToConsole(View view) {
//        for (int i = 0; i < numSounds; i++) {
//            System.out.println("Sound " + (i + 1) + ": " + didNotPlay[i]);
//        }
//    }
}
