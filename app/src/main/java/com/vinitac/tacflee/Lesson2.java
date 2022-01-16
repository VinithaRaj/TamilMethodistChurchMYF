package com.vinitac.tacflee;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Lesson2 extends AppCompatActivity {
    boolean lang=true;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        toolBarLayout.setCollapsedTitleTextAppearance(R.style.ttext);
        toolBarLayout.setExpandedTitleTextAppearance(R.style.ttext2);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView changeT = findViewById(R.id.temptEng);
                if (lang) {
                    changeT.setText(getResources().getString(R.string.prefacetam));
                    fab.setImageResource(R.drawable.eng_removebg_preview);
                    lang = false;
                }
                else{
                    changeT.setText(getResources().getString(R.string.prefaceeng));
                    fab.setImageResource(R.drawable.tamil2_removebg_preview__2_);
                    lang = true;
                }
                Snackbar.make(view, "Press again to switch language", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}