package com.vinitac.tacflee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Counselling extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Ministries");
    private DocumentReference documentReference;
    private StorageReference mStorageRef;
    /*ExpandableListView expandableListView2;
    List<String> ChildList;
    HashMap<String,List<String>> ParentListItems;
    MainAdapter adapter2;
    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("Contact Us");
        ParentList.add("Make an Appointment");

    }
    String[] planetName = {
            "Date: ", "Venue: ","Contact: "
    };

    String[] appt = {
            "Contact: youthfellowshiptac@gmail.com"
    };
    String[] contact = {
            "TAC Director of Youth Work :Rev Timothy Raj" ,
                    "TAC Methodist Youth Fellowship President:Mr. Josiah Inbaraj"
    };
    String[] oplats = {
            "Instagram: myf.tac","Facebook: Tac Myf"
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselling2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        toolBarLayout.setCollapsedTitleTextAppearance(R.style.ttext);
        toolBarLayout.setExpandedTitleTextAppearance(R.style.ttext2);
        final TextView tDesc = findViewById(R.id.counsDesc);
        final TextView tC1 = findViewById(R.id.psdesc1);
        final TextView tC2 = findViewById(R.id.psdesc2);
        final TextView tC3 = findViewById(R.id.psdesc3);
        final TextView tC4 = findViewById(R.id.psdesc4);
        final ImageView image1 = findViewById(R.id.psimg1);
        final ImageView image2 = findViewById(R.id.psimg2);
        final ImageView image3 = findViewById(R.id.psimg3);
        final ImageView image4 = findViewById(R.id.psimg4);
        /*expandableListView2 = findViewById(R.id.counlist);
        ParentListItems = new LinkedHashMap<>();
        for (String HoldItem: ParentList){
            if (HoldItem.equals("Contact Us")){
                loadChild(contact);
            } else if (HoldItem.equals("Make an Appointment")){
                loadChild(appt);
            }  else {
                loadChild(planetName);
            }
            ParentListItems.put(HoldItem, ChildList);
        }



        //listGroup = new ArrayList<>();
        //listItem = new HashMap<>();
        adapter2 = new MainAdapter(this,ParentList,ParentListItems);
        expandableListView2.setAdapter(adapter2);
        final TextView ig = findViewById(R.id.iglink);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://instagram.com/myf.tac?igshid=17g4qovo2ru9x");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                Snackbar.make(view, "Link to TAC Website", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final TextView fb = findViewById(R.id.fblink);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/myf.tac/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                Snackbar.make(view, "Link to TAC Website", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    /*private void loadChild(String[] ParentElementName){
        ChildList = new ArrayList<>();
        Collections.addAll(ChildList,ParentElementName);

    }*/

}