package com.prerak.yebutton;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class YeButton extends AppCompatActivity {

    MediaPlayer[] mySounds;
    MediaPlayer mySound;
    MediaPlayer famousSound;
    MediaPlayer answerssway;
    MediaPlayer beenlikethat;
    MediaPlayer bush;
    MediaPlayer gaga;
    MediaPlayer inmycode;
    MediaPlayer justtoldyou;
    MediaPlayer rockstar;
    //MediaPlayer youngmetro;
    //MediaPlayer whatsgood;
    //MediaPlayer wavybaby;
    //MediaPlayer wavydude;
    //MediaPlayer hityebutton;
    int numSounds;

    Random myRandom = new Random();
    MediaPlayer currentlyPlaying;


    protected void onPause() {
        super.onPause();
        currentlyPlaying.pause();
        //currentlyPlaying.release();

    }

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

        mySound = MediaPlayer.create(this, R.raw.stronger);
        famousSound = MediaPlayer.create(this, R.raw.famous);
        answerssway = MediaPlayer.create(this, R.raw.answerssway);
        beenlikethat = MediaPlayer.create(this, R.raw.beenlikethat);
        bush = MediaPlayer.create(this, R.raw.bush);
        gaga = MediaPlayer.create(this, R.raw.gaga);
        inmycode = MediaPlayer.create(this, R.raw.inmycode);
        justtoldyou = MediaPlayer.create(this, R.raw.justtoldyou);
        rockstar = MediaPlayer.create(this, R.raw.rockstar);

//        youngmetro = MediaPlayer.create(this, R.raw.youngmetro);
//        whatsgood = MediaPlayer.create(this, R.raw.whatsgood);
//        wavybaby = MediaPlayer.create(this, R.raw.wavybaby);
//        wavydude = MediaPlayer.create(this, R.raw.wavydude);
//        hityebutton = MediaPlayer.create(this, R.raw.hityebutton);


        mySounds = new MediaPlayer[]{mySound, famousSound, answerssway, beenlikethat, bush, gaga,
            inmycode, justtoldyou, rockstar};//, youngmetro, whatsgood, wavybaby, wavydude,
            //hityebutton};
        numSounds = mySounds.length;
        System.out.println("mySound initialized");

    }


//    public void playMusic(View view) {
//        mySound.start();
//    }

    public void playMyMusic(View view) {
        System.out.print("playMyMusic called");
//        currentlyPlaying = (MediaPlayer) mySounds[0];
//        currentlyPlaying.start();
        if (currentlyPlaying != null) {
            //currentlyPlaying.seekTo(0);
            onPause();
            //System.out.println("currentlyPlaying not null");
        }
        int nowPlayingTrackNum = myRandom.nextInt(numSounds);
        currentlyPlaying = mySounds[nowPlayingTrackNum];
        currentlyPlaying.seekTo(0);
        currentlyPlaying.start();
        System.out.println(numSounds);
    }

    public void onPause(View view) {
        onPause();
    }
}
