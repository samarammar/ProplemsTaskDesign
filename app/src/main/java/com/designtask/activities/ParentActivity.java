
package com.designtask.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.designtask.R;

import info.hoang8f.android.segmented.SegmentedGroup;

public class ParentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private Toolbar toolbar;
    protected AppCompatActivity activity;
    public FrameLayout rootView;
    SegmentedGroup segmented;
    RadioButton btn_others ,btn_Problems;
//    private  tbShop;
    public TabLayout tbProblems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        activity = this;
        rootView = (FrameLayout) findViewById(android.R.id.content);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // init the view_home_toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rootView = (FrameLayout) findViewById(android.R.id.content);

        // check the view_home_toolbar
        if (toolbar != null) {
            // view_home_toolbar is available >> handle it
            setSupportActionBar(toolbar);


            toolbar.setTitle("");

            tbProblems = (TabLayout) toolbar.findViewById(R.id.tabs_Problems);
            segmented= (SegmentedGroup)toolbar.findViewById(R.id.segmented);
            btn_Problems=(RadioButton)toolbar.findViewById(R.id.btn_problems);
            btn_others=(RadioButton)toolbar.findViewById(R.id.btn_others);
            btn_Problems.toggle();
            segmented.setOnCheckedChangeListener(this);




        }
    }



    @Override
    protected void onDestroy() {
        // cancel requests if found

        super.onDestroy();
    }


    public boolean hasToolbar() {
        return toolbar != null;
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
