package com.designtask.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.designtask.Const;
import com.designtask.R;
import com.designtask.fragments.AcceptedFragment;
import com.designtask.fragments.CanceledFragment;
import com.designtask.fragments.InWaitingFragment;

import info.hoang8f.android.segmented.SegmentedGroup;

public class MainActivity extends ParentActivity {

    AcceptedFragment acceptedFragment;
    InWaitingFragment inWaitingFragment;
    CanceledFragment canceledFragment;
    LinearLayout frame_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        bindWidgetsWithAnEvent();
        setupTabLayout();






    }

    private void initViews(){
        tbProblems = (TabLayout) findViewById(R.id.tabs_Problems);
        frame_container=(LinearLayout)findViewById(R.id.frame_container);

        segmented= (SegmentedGroup)findViewById(R.id.segmented);
        btn_Problems=(RadioButton)findViewById(R.id.btn_problems);
        btn_others=(RadioButton)findViewById(R.id.btn_others);
        segmented.setOnCheckedChangeListener(this);
        btn_Problems.toggle();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (checkedId==R.id.btn_problems){

        }else if (checkedId==R.id.btn_others){

        }
    }

    private void setupTabLayout() {
        canceledFragment = new CanceledFragment();

        acceptedFragment = new AcceptedFragment();
        inWaitingFragment = new InWaitingFragment();



        tbProblems.addTab(tbProblems.newTab().setText("تم الالغاء"));
        tbProblems.addTab(tbProblems.newTab().setText("تم القبول"));
        tbProblems.addTab(tbProblems.newTab().setText("قيد الانتظار"),true);



    }
    private void bindWidgetsWithAnEvent() {

        tbProblems.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());

            }
        });
    }

    private void setCurrentTabFragment(int tabPosition) {
        switch (tabPosition) {

            case 0:

                replaceFragment(canceledFragment);
                break;

            case 1:
                replaceFragment(acceptedFragment);

                break;
            case 2:

            replaceFragment(inWaitingFragment);
            break;
        }
    }


    public void replaceFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putString(Const.PROB_waiting, Const.PROB_waiting);
        bundle.putString(Const.PROB_accepted,Const.PROB_accepted);
        bundle.putString(Const.PROB_canceld, Const.PROB_canceld);
        bundle.putString(Const.OTHER_waiting,Const.OTHER_waiting);
        bundle.putString(Const.OTHER_accepted,Const.OTHER_accepted);
        bundle.putString(Const.OTHER_canceld,Const.OTHER_canceld);
        fragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.detach(fragment).attach(fragment);
        ft.commit();
    }



}
