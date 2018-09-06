package com.designtask.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.designtask.Utils;
import com.designtask.activities.ParentActivity;


public class ParentFragment extends Fragment implements View.OnClickListener {
    // used to hold connection handlers that should be cancelled when destroyed


    protected ParentActivity activity;
    protected View rootView;
    TextView tvCart;
    protected ProgressDialog progressDialog;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (ParentActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (activity.hasToolbar()) {
            setHasOptionsMenu(true);
        }
    }

    public View findViewById(int id) {
        if (rootView != null) {
            return rootView.findViewById(id);
        } else {
            return null;
        }
    }

    public int getResColor(int id) {
        return getResources().getColor(id);
    }

    public void logE(String msg) {
        Utils.logE(msg);
    }

    @Override
    public void onClick(View v) {
    }

    public void loadFragment(int container, Fragment fragment) {
        loadFragment(container, fragment, 0, 0);
    }

    public void loadFragment(int container, Fragment fragment, int enterAnim, int exitAnim) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        if (enterAnim != 0 && exitAnim != 0) {
            ft.setCustomAnimations(enterAnim, exitAnim);
        }
        ft.replace(container, fragment);
        ft.commitAllowingStateLoss();
    }





    @Override
    public void onDestroy() {
        // cancel requests if found

        super.onDestroy();
    }




}
