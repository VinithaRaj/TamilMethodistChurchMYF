package com.vinitac.tacflee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class mainhome extends AppCompatActivity {
    private FirebaseFirestore db3 = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db3.collection("StudyMats");
    private DocumentReference documentReference3;
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);
        //ImageView c1;
        CardView c1;
        CardView c2;
        CardView c3;
        documentReference3 = db3.document("StudyMats/mainpage");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                documentReference3.get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()){
                                    String txtlink = documentSnapshot.getString("leadLink");
                                    Uri uri = Uri.parse(txtlink);
                                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                    startActivity(intent);

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
                 /*Uri uri = Uri.parse("https://tacmethodist.org/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);*/

                Snackbar.make(view, "Link to TAC Website", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        c1 = findViewById(R.id.studymat2);
        c1.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(mainhome.this,MainActivity.class);
                startActivity(intent);
            }
        });

        c2 = findViewById(R.id.minmat2);
        c2.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(mainhome.this,Ministries.class);
                startActivity(intent);
            }
        });

        c3 = findViewById(R.id.counlink2);
        c3.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(mainhome.this,Counselling.class);
                startActivity(intent);
            }
        });

    }
}