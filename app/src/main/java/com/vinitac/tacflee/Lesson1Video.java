package com.vinitac.tacflee;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Lesson1Video extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button playbutton;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("StudyMats");
    private DocumentReference documentReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_video);
        /*VideoView videoView = findViewById(R.id.les1vid);

        String videopath = "https://www.youtube.com/watch?v=kp_Msx1sPs8";
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(Uri.parse(videopath));
        videoView.requestFocus();
        videoView.start();*/
        playbutton = findViewById(R.id.playbutton);
        youTubePlayerView = findViewById(R.id.ytview);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("3LiubyYpEUk");
                if (MainActivity.les1parent == "Preface"){
                    documentReference = db.document("StudyMats/prefacedoc");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){
                                        String txt = documentSnapshot.getString("descVideo");
                                        //txt = txt.replace("\\n", "\n");
                                        youTubePlayer.loadVideo(txt);

                                    }
                                    else{
                                        //Toast.makeText("Helo");
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                }
                else if (MainActivity.les1parent == "Lesson 1"){
                    documentReference = db.document("StudyMats/lesson1");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){
                                        String txt = documentSnapshot.getString("descVideo");
                                        //txt = txt.replace("\\n", "\n");
                                        youTubePlayer.loadVideo(txt);

                                    }
                                    else{
                                        //Toast.makeText("Helo");
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                }
                else if (MainActivity.les1parent == "Lesson 2"){
                    documentReference = db.document("StudyMats/lesson2");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){
                                        String txt = documentSnapshot.getString("descVideo");
                                        //txt = txt.replace("\\n", "\n");
                                        youTubePlayer.loadVideo(txt);

                                    }
                                    else{
                                        //Toast.makeText("Helo");
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                }
                else if (MainActivity.les1parent == "Lesson 3"){
                    documentReference = db.document("StudyMats/lesson3");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){
                                        String txt = documentSnapshot.getString("descVideo");
                                        //txt = txt.replace("\\n", "\n");
                                        youTubePlayer.loadVideo(txt);

                                    }
                                    else{
                                        //Toast.makeText("Helo");
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                }
                else if (MainActivity.les1parent == "Lesson 4"){
                    documentReference = db.document("StudyMats/lesson4");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){
                                        String txt = documentSnapshot.getString("descVideo");
                                        //txt = txt.replace("\\n", "\n");
                                        youTubePlayer.loadVideo(txt);

                                    }
                                    else{
                                        //Toast.makeText("Helo");
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                }
                else if (MainActivity.les1parent == "Finale"){
                    documentReference = db.document("StudyMats/lesson5");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){
                                        String txt = documentSnapshot.getString("descVideo");
                                        //txt = txt.replace("\\n", "\n");
                                        youTubePlayer.loadVideo(txt);

                                    }
                                    else{
                                        //Toast.makeText("Helo");
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                }
            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(PlayerConfig.APIKEY,onInitializedListener);
            }
        });

        /*MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/
    }
}