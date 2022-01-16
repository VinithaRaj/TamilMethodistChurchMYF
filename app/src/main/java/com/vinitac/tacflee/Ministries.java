package com.vinitac.tacflee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Ministries extends AppCompatActivity {
    private FirebaseFirestore db2 = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db2.collection("Ministries");
    private DocumentReference documentReference2;
    ExpandableListView expandableListView2;
    List<String> ChildList;
    ArrayList<String> ar = new ArrayList<String>();
    HashMap<String,List<String>> ParentListItems;
    MainAdapter adapter2;
    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("MYF Conference AGM 2020");
        //ParentList.add("MYF Disrict AGM 2020");

    }
    String[] planetName = {
            "Date: ", "Venue: ","Contact: "
    };

    String[] defaultName = {
            "Date: 15th August, 2020",
                    "Venue: TMC KL" ,
                    "Contact: Ps. Timothy Raj"
    };
    String[] defaultName2 = {
            "Date: 31st October, 2020",
            "Venue: TMC KL" ,
            "Time: 2.00 p.m.",
            "Contact: Mr. Josiah Inbaraj"

    };
    String[] a ={"b"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ministries);
        expandableListView2 = findViewById(R.id.minlist);
        ParentListItems = new LinkedHashMap<>();
        final String[] qwe = {"treat"};
        final TextView minsyear = findViewById(R.id.mins);
        final TextView minstitle = findViewById(R.id.minstitle);
        final TextView minstime = findViewById(R.id.time);
        final TextView minsdate = findViewById(R.id.date);
        final TextView minsvenue = findViewById(R.id.venue);
        final TextView minscontact = findViewById(R.id.contact);
        documentReference2 = db2.document("Ministries/MYFConfAGM");
        documentReference2.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            String txt = documentSnapshot.getString("year");
                            txt = txt.replace("\\n", "\n");
                            minsyear.setText(txt);
                            String txt2 = documentSnapshot.getString("title");
                            txt2 = txt2.replace("\\n", "\n");
                            minstitle.setText(txt2);
                            String txt3 = "Date: ";
                            txt3 += documentSnapshot.getString("date5");
                            txt3 = txt3.replace("\\n", "\n");
                            Log.i("date",txt3);
                            minsdate.setText(txt3);
                            String txt4 = "Time: ";
                            txt4 += documentSnapshot.getString("time");
                            txt4 = txt4.replace("\\n", "\n");
                            minstime.setText(txt4);
                            String txt5 = "Venue: ";
                            txt5 += documentSnapshot.getString("venue");
                            txt5 = txt5.replace("\\n", "\n");
                            minsvenue.setText(txt5);
                            String txt6 = "Contact: ";
                            txt6 += documentSnapshot.getString("contact");
                            txt6 = txt6.replace("\\n", "\n");
                            minscontact.setText(txt6);

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


        //loadChild(qwe);
        Log.i("a2",a[0]);
        /*for (String HoldItem: ParentList){
            if (HoldItem.equals("MYF Conference AGM 2020")){
                //documentReference2 = db2.document("Ministries/MYFConfAGM");


                Log.i("a3",a[0]);

            }  else {
                loadChild(qwe);
            }
            ParentListItems.put(HoldItem, ChildList);
        }
        adapter2 = new MainAdapter(this,ParentList,ParentListItems);
        expandableListView2.setAdapter(adapter2);*/


    }

    public void loadChild(String[] ParentElementName){
        ChildList = new ArrayList<>();
        Collections.addAll(ChildList,ParentElementName);

    }

}