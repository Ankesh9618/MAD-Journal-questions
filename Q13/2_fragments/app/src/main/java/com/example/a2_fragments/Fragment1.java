package com.example.a2_fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button play, pause, resume, stop;
    private View view;
    private MediaPlayer mediaPlayer;
    private int lastPostition = 0 ;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);

        stop= view.findViewById(R.id.stop);
        play = view.findViewById(R.id.play);
        pause = view.findViewById(R.id.pause);
        resume = view.findViewById(R.id.resume);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.audio);
                    mediaPlayer.start();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    lastPostition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                }
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && !mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    lastPostition = 0;

                }
            }
        });
        return view;
    }


/*
    @Override
    public void onStart() {
        super.onStart();

        stop= view.findViewById(R.id.stop);
        play = view.findViewById(R.id.play);
        pause = view.findViewById(R.id.pause);
        resume = view.findViewById(R.id.resume);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.audio1);
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    lastPostition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                }
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && !mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    lastPostition = 0;

                }
            }
        });
    }*/
}