package com.example.video_player;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button play,pause,resume,stop;
    VideoView video;
    MediaController mediaController;
    int lastPosition = 0;
    Uri videouri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        resume = (Button) findViewById(R.id.resume);
        stop = (Button) findViewById(R.id.stop);

        video = (VideoView) findViewById(R.id.videoView);



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaControllerPlayback();
                if(!video.isPlaying()){
                    video.seekTo(lastPosition);
                    video.start();

                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(video.isPlaying()){
                    lastPosition = video.getCurrentPosition();
                    video.pause();
                }
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!video.isPlaying() && lastPosition>0){
                    video.seekTo(lastPosition);
                    video.start();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(video.isPlaying()){
                    video.stopPlayback();
                }
                lastPosition=0;

            }
        });

    }

    void setMediaControllerPlayback(){
        videouri =Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test_video);
        video.setVideoURI(videouri);
        mediaController =new MediaController(this);
        mediaController.setAnchorView(video);
    }
}