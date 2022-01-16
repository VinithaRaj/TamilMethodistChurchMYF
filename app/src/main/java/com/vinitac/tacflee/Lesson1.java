package com.vinitac.tacflee;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Lesson1 extends AppCompatActivity {
    boolean lang=true;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("StudyMats");
    private DocumentReference documentReference;
    private StorageReference mStorageRef;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        toolBarLayout.setCollapsedTitleTextAppearance(R.style.ttext);
        toolBarLayout.setExpandedTitleTextAppearance(R.style.ttext2);
        final TextView t2 = findViewById(R.id.temptEng);
        final TextView tAuth = findViewById(R.id.temptAuthor);
        final TextView tTitle = findViewById(R.id.temptTitle);
        final TextView tQuest = findViewById(R.id.temptQuestions);
        final ImageView image = findViewById(R.id.temptLessonImage);
        final TextView qt = findViewById(R.id.temptQuestTitle);
        final TextView tAns = findViewById(R.id.temptAnswers);
        final TextView tAnsTitle = findViewById(R.id.temptAnsTitle);
        //final TextView title2 = findViewById(R.id.l1title);

        //t2.setText(R.string.large_text);
        Log.i("order","This is in lesson1 and happens first");
        if (MainActivity.les1parent == "Preface"){
            mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://tacflee-d705c.appspot.com/art3.jpg");
            documentReference = db.document("StudyMats/prefacedoc");
            //t2.setText(R.string.prefaceeng);
            toolBarLayout.setTitle("Preface");
        }
        else if (MainActivity.les1parent == "Lesson 1"){
            mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://tacflee-d705c.appspot.com/art4.jpg");
            documentReference = db.document("StudyMats/lesson1");
            toolBarLayout.setTitle("Lesson 1");
        }
        else if (MainActivity.les1parent == "Lesson 2"){
            mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://tacflee-d705c.appspot.com/art2.jpg");
            documentReference = db.document("StudyMats/lesson2");
            toolBarLayout.setTitle("Lesson 2");
        }
        else if (MainActivity.les1parent == "Lesson 3"){
            mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://tacflee-d705c.appspot.com/art5.jpg");
            documentReference = db.document("StudyMats/lesson3");
            toolBarLayout.setTitle("Lesson 3");
        }
        else if (MainActivity.les1parent == "Lesson 4"){
            mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://tacflee-d705c.appspot.com/art6.jpg");
            documentReference = db.document("StudyMats/lesson4");
            toolBarLayout.setTitle("Lesson 4");
        }
        else if (MainActivity.les1parent == "Finale"){
            mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://tacflee-d705c.appspot.com/art2.jpg");
            documentReference = db.document("StudyMats/lesson5");
            toolBarLayout.setTitle("The Challenge");
        }
        final long ONE_MEGABYTE = 1024 * 1024;
        mStorageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                image.setImageBitmap(bm);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
        if (MainActivity.les1parent == "Preface"){
            documentReference.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){
                                if (MainActivity.les1guide=="Introduction") {
                                    String txt = documentSnapshot.getString("desc");
                                    txt = txt.replace("\\n", "\n");
                                    t2.setText(txt);
                                    //Author
                                    String txtAuthor = documentSnapshot.getString("author");
                                    txtAuthor = txtAuthor.replace("\\n", "\n");
                                    tAuth.setText(txtAuthor);
                                }
                                else if (MainActivity.les1guide=="Guidelines") {
                                    String txt = documentSnapshot.getString("descGuide");
                                    txt = txt.replace("\\n", "\n");
                                    t2.setText(txt);
                                    //Title

                                    String txtTitle = documentSnapshot.getString("descGuideTitle");
                                    txtTitle = txtTitle.replace("\\n", "\n");
                                    tTitle.setText(txtTitle);
                                    //Questions
                                    String txtguide = documentSnapshot.getString("descGuideTitle2");
                                    txtguide = txtguide.replace("\\n", "\n");
                                    qt.setText(txtguide);
                                    String txtQuest = documentSnapshot.getString("descGuide2");
                                    txtQuest = txtQuest.replace("\\n", "\n");
                                    tQuest.setText(txtQuest);
                                }
                                else if (MainActivity.les1guide=="Credits"){
                                    String txt = documentSnapshot.getString("credits");
                                    txt = txt.replace("\\n", "\n");
                                    t2.setText(txt);
                                    String txtTitle = documentSnapshot.getString("creditsTitle");
                                    txtTitle = txtTitle.replace("\\n", "\n");
                                    tTitle.setText(txtTitle);
                                }

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
        else {
            documentReference.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String txt = documentSnapshot.getString("descNew");
                                txt = txt.replace("\\n", "\n");
                                t2.setText(txt);

                                //Author
                                String txtAuthor = documentSnapshot.getString("author");
                                txtAuthor = txtAuthor.replace("\\n", "\n");
                                tAuth.setText(txtAuthor);
                                if (MainActivity.les1parent=="Preface"){
                                    Log.i("pref","hello");
                                }
                                else {
                                    //Title
                                    String txtTitle = documentSnapshot.getString("title");
                                    txtTitle = txtTitle.replace("\\n", "\n");
                                    tTitle.setText(txtTitle);
                                    //Questions
                                    qt.setText("Questions");
                                    String txtQuest = documentSnapshot.getString("quest");
                                    txtQuest = txtQuest.replace("\\n", "\n");
                                    tQuest.setText(txtQuest);
                                    if (MainActivity.les1guide == "Leader's Guide") {
                                        tAnsTitle.setText("Answers");
                                        String ans = documentSnapshot.getString("answers");
                                        ans = ans.replace("\\n", "\n");
                                        tAns.setText(ans);
                                    }
                                }

                            } else {
                                //Toast.makeText("Helo");
                                Log.i("FAILEDDD", "hereeeeeee");
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
        }
        //final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Button fab =(Button) findViewById(R.id.tamiltranslate);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView changeT = findViewById(R.id.temptEng);
                if (lang && MainActivity.les1parent=="Lesson 1") {
                    documentReference = db.document("StudyMats/lesson1");
                    //fab.setImageResource(R.drawable.eng_removebg_preview);
                    //fab.setText("English");

                }
                else if (!lang && (MainActivity.les1parent=="Lesson 1")){
                    documentReference = db.document("StudyMats/lesson1");
                    //fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);
                }
                if (lang && MainActivity.les1parent=="Lesson 3") {
                    documentReference = db.document("StudyMats/lesson3");
                    //fab.setImageResource(R.drawable.eng_removebg_preview);
                }
                else if (!lang && (MainActivity.les1parent=="Lesson 3")){
                    documentReference = db.document("StudyMats/lesson3");
                    //fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);
                }
                if (lang && MainActivity.les1parent=="Lesson 2") {
                    documentReference = db.document("StudyMats/lesson2");
                    //fab.setImageResource(R.drawable.eng_removebg_preview);
                }
                else if (!lang && (MainActivity.les1parent=="Lesson 2")){
                    documentReference = db.document("StudyMats/lesson2");
                    //fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);
                }
                if (lang && MainActivity.les1parent=="Preface") {
                    documentReference = db.document("StudyMats/prefacedoc");
                    //fab.setImageResource(R.drawable.eng_removebg_preview);
                }
                else if (!lang && (MainActivity.les1parent=="Preface")){
                    documentReference = db.document("StudyMats/prefacedoc");
                    //fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);
                }
                if (lang && MainActivity.les1parent=="Finale") {
                    documentReference = db.document("StudyMats/lesson5");
                    //fab.setImageResource(R.drawable.eng_removebg_preview);
                }
                else if (!lang && (MainActivity.les1parent=="Finale")){
                    documentReference = db.document("StudyMats/lesson5");
                    //fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);
                }
                if (lang && MainActivity.les1parent=="Lesson 4") {
                    documentReference = db.document("StudyMats/lesson4");
                    //fab.setImageResource(R.drawable.eng_removebg_preview);
                }
                else if (!lang && (MainActivity.les1parent=="Lesson 4")){
                    documentReference = db.document("StudyMats/lesson4");
                    //fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);

                }
                if (!lang){
                    fab.setText("தமிழ்");
                    documentReference.get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if (documentSnapshot.exists()){

                                        if (MainActivity.les1guide=="Credits"){
                                            Log.i("pref","hello");
                                        }
                                        /*String txt = documentSnapshot.getString("descNew");
                                        txt = txt.replace("\\n", "\n");
                                        t2.setText(txt);

                                        //Author
                                        String txtAuthor = documentSnapshot.getString("author");
                                        txtAuthor = txtAuthor.replace("\\n", "\n");
                                        tAuth.setText(txtAuthor);*/
                                        if (MainActivity.les1parent=="Preface"){
                                            Log.i("pref","hello");
                                            if (MainActivity.les1guide=="Introduction") {
                                                String txt = documentSnapshot.getString("descNew");
                                                txt = txt.replace("\\n", "\n");
                                                t2.setText(txt);
                                                //Author
                                                String txtAuthor = documentSnapshot.getString("author");
                                                txtAuthor = txtAuthor.replace("\\n", "\n");
                                                tAuth.setText(txtAuthor);
                                            }
                                            else if (MainActivity.les1guide=="Guidelines") {
                                                String txt = documentSnapshot.getString("descGuide");
                                                txt = txt.replace("\\n", "\n");
                                                t2.setText(txt);
                                                String txtTitle = documentSnapshot.getString("descGuideTitle");
                                                txtTitle = txtTitle.replace("\\n", "\n");
                                                tTitle.setText(txtTitle);
                                                //Questions
                                                String txtguide = documentSnapshot.getString("descGuideTitle2");
                                                txtguide = txtguide.replace("\\n", "\n");
                                                qt.setText(txtguide);
                                                String txtQuest = documentSnapshot.getString("descGuide2");
                                                txtQuest = txtQuest.replace("\\n", "\n");
                                                tQuest.setText(txtQuest);
                                            }
                                            else if (MainActivity.les1guide=="Credits"){
                                                String txt = documentSnapshot.getString("credits");
                                                txt = txt.replace("\\n", "\n");
                                                t2.setText(txt);
                                                String txtTitle = documentSnapshot.getString("creditsTitle");
                                                txtTitle = txtTitle.replace("\\n", "\n");
                                                tTitle.setText(txtTitle);
                                            }
                                        }
                                        else {
                                            String txt = documentSnapshot.getString("descNew");
                                            txt = txt.replace("\\n", "\n");
                                            t2.setText(txt);

                                            //Author
                                            String txtAuthor = documentSnapshot.getString("author");
                                            txtAuthor = txtAuthor.replace("\\n", "\n");
                                            tAuth.setText(txtAuthor);
                                            //Title
                                            String txtTitle = documentSnapshot.getString("title");
                                            txtTitle = txtTitle.replace("\\n", "\n");
                                            tTitle.setText(txtTitle);
                                            //Questions
                                            qt.setText("Questions");
                                            String txtQuest = documentSnapshot.getString("quest");
                                            txtQuest = txtQuest.replace("\\n", "\n");
                                            tQuest.setText(txtQuest);

                                            if (MainActivity.les1guide == "Leader's Guide") {
                                                tAnsTitle.setText("Answers");
                                                String ans = documentSnapshot.getString("answers");
                                                ans = ans.replace("\\n", "\n");
                                                tAns.setText(ans);
                                            }
                                        }
                                    }
                                    else{
                                        Log.i("FAILEDDD","hereeeeeee");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                    lang=true;

                }
                else if (lang) {
                    fab.setText("English");
                    documentReference.get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()){


                                    if (MainActivity.les1parent=="Preface"){
                                        Log.i("pref","hello");
                                        if (MainActivity.les1guide=="Introduction") {
                                            String txt = documentSnapshot.getString("descTamilNew");
                                            txt = txt.replace("\\n", "\n");
                                            t2.setText(txt);
                                            //Author
                                            String txtAuthor = documentSnapshot.getString("authorTamil");
                                            txtAuthor = txtAuthor.replace("\\n", "\n");
                                            tAuth.setText(txtAuthor);
                                        }
                                        else if (MainActivity.les1guide=="Guidelines") {
                                            String txt = documentSnapshot.getString("descGuideTamil");
                                            txt = txt.replace("\\n", "\n");
                                            t2.setText(txt);
                                            String txtTitle = documentSnapshot.getString("descGuideTitleTamil");
                                            txtTitle = txtTitle.replace("\\n", "\n");
                                            tTitle.setText(txtTitle);
                                            //Questions
                                            String txtguide = documentSnapshot.getString("descGuideTitleTamil2");
                                            txtguide = txtguide.replace("\\n", "\n");
                                            qt.setText(txtguide);
                                            String txtQuest = documentSnapshot.getString("descGuideTamil2");
                                            txtQuest = txtQuest.replace("\\n", "\n");
                                            tQuest.setText(txtQuest);
                                        }
                                        else if (MainActivity.les1guide=="Credits"){
                                            String txt = documentSnapshot.getString("creditsTamil");
                                            txt = txt.replace("\\n", "\n");
                                            t2.setText(txt);
                                            String txtTitle = documentSnapshot.getString("creditsTitleTamil");
                                            txtTitle = txtTitle.replace("\\n", "\n");
                                            tTitle.setText(txtTitle);
                                        }
                                    }
                                    else {
                                        String txt = documentSnapshot.getString("descTamilNew");
                                        txt = txt.replace("\\n", "\n");
                                        changeT.setText(txt);

                                        //Author
                                        String txtAuthor = documentSnapshot.getString("authorTamil");
                                        txtAuthor = txtAuthor.replace("\\n", "\n");
                                        tAuth.setText(txtAuthor);
                                        //Title
                                        String txtTitle = documentSnapshot.getString("titleTamil");
                                        txtTitle = txtTitle.replace("\\n", "\n");
                                        tTitle.setText(txtTitle);
                                        //Questions
                                        String txtQuestTitle = documentSnapshot.getString("questTitleTamil");
                                        txtQuestTitle = txtQuestTitle.replace("\\n", "\n");
                                        qt.setText(txtQuestTitle);
                                        String txtQuest = documentSnapshot.getString("questTamil");
                                        txtQuest = txtQuest.replace("\\n", "\n");
                                        tQuest.setText(txtQuest);
                                        if (MainActivity.les1guide == "Leader's Guide") {
                                            tAnsTitle.setText("பதில்கள்");
                                            String ans = documentSnapshot.getString("answersTamil");
                                            ans = ans.replace("\\n", "\n");
                                            tAns.setText(ans);
                                        }
                                    }

                                }
                                else{
                                    Log.i("FAILEDDD","hereeeeeee");
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                    lang = false;
                }
                Snackbar.make(view, "Press again to switch language", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}