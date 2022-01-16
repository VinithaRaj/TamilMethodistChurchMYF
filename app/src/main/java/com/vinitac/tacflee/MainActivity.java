package com.vinitac.tacflee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> ChildList;
    HashMap<String,List<String>> ParentListItems;
    MainAdapter adapter;
    public static String les1parent;
    public static String les1guide;
    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("Preface");
        ParentList.add("Lesson 1");
        ParentList.add("Lesson 2");
        ParentList.add("Lesson 3");
        ParentList.add("Lesson 4");
        ParentList.add("Finale");

    }
    String[] planetName = {
            "Study Notes", "Testimony Video","Leader's Guide"
    };
    String[] pName2 ={
            "Introduction","Guidelines","Credits"
    };
    String[] pName3 = {
      "Study Notes"
    };
    String[] defaultName = {
            "Hey"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.les1);
        ParentListItems = new LinkedHashMap<>();
        for (String HoldItem: ParentList){
            if (HoldItem.equals("Preface")){
                //loadChild( new String[]{"Study Notes: Temptation", "Testimony Video: Temptation", "Leader's Guide: Temptation"});
                loadChild(pName2);
            } else if (HoldItem.equals("Finale")){
                loadChild(pName3);
            } else {
                loadChild(planetName);
            }

            ParentListItems.put(HoldItem, ChildList);
        }



        //listGroup = new ArrayList<>();
        //listItem = new HashMap<>();
        adapter = new MainAdapter(this,ParentList,ParentListItems);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final String selected = (String) adapter.getChild(groupPosition,childPosition);
                final String sparent = (String) adapter.getGroup(groupPosition);
                Log.i("lesson1check", sparent);
                les1parent = sparent;
                les1guide = selected;
                Intent intent;
                if (sparent == "Lesson 1" ){
                    if (selected == "Study Notes"|| selected=="Leader's Guide") {
                        intent = new Intent(MainActivity.this,Lesson1.class);
                        startActivity(intent);

                    }
                    else if (selected == "Testimony Video"){
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                    }
                }
                else if (sparent == "Lesson 2"){
                    if (selected == "Study Notes"|| selected=="Leader's Guide") {


                        intent = new Intent(MainActivity.this,Lesson1.class);
                        startActivity(intent);

                    }
                    else if (selected == "Testimony Video"){
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                    }
                }
                else if (sparent == "Lesson 3"){
                    if (selected == "Study Notes"|| selected=="Leader's Guide") {
                        intent = new Intent(MainActivity.this,Lesson1.class);
                        startActivity(intent);

                    }
                    else if (selected == "Testimony Video"){
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                    }
                }
                else if (sparent == "Lesson 4"){
                    if (selected == "Study Notes"|| selected=="Leader's Guide") {
                        intent = new Intent(MainActivity.this,Lesson1.class);
                        startActivity(intent);

                    }
                    else if (selected == "Testimony Video"){
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                    }
                }
                else if (sparent == "Preface"){
                    if (selected == "Introduction"|| selected=="Guidelines"||selected=="Credits") {

                        intent = new Intent(getApplicationContext(),Lesson1.class);

                        //intent.putExtra(String.valueOf(R.id.temptEng), new String[]{getResources().getString(R.string.title_activity_lesson1)});
                        //
                        startActivity(intent);

                        View inflatedlayout = getLayoutInflater().inflate(R.layout.content_scrolling,null);
                        TextView anyeng = inflatedlayout.findViewById(R.id.temptEng);
                        Log.i("pref0", String.valueOf(anyeng.getText()));
                        anyeng.setText(getResources().getString(R.string.prefaceeng));
                        Log.i("preface2", String.valueOf(anyeng.getText()));

                    }
                    else if (selected == "Testimony Video"){
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                    }
                }
                else if (sparent == "Finale"){
                    if (selected == "Study Notes"|| selected=="Leader's Guide") {
                        intent = new Intent(MainActivity.this,Lesson1.class);
                        startActivity(intent);

                    }
                    else if (selected == "Testimony Video"){
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                    }
                }
                /*switch (selected){
                    case "Study Notes: Temptation":
                        intent = new Intent(MainActivity.this,Lesson1.class);
                        startActivity(intent);
                        break;
                    case "Testimony Video: Temptation":
                        intent = new Intent(MainActivity.this,Lesson1Video.class);
                        startActivity(intent);
                        break;
                    case "Leader's Guide: Temptation":
                        intent = new Intent(MainActivity.this,mainhome.class);
                        startActivity(intent);
                        break;

                }*/
                return  true;
            }
        });

    }

    private void loadChild(String[] ParentElementName){
        ChildList = new ArrayList<>();
        Collections.addAll(ChildList,ParentElementName);

    }

}