package com.designtask.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.designtask.Models.ProblemModel;
import com.designtask.R;
import com.designtask.adapters.WaitingAcceptedAdapter;

import java.util.ArrayList;
import java.util.List;

public class CanceledFragment extends ParentFragment {
    private RecyclerView rvProblems;
    private List<ProblemModel> problemModels = new ArrayList<ProblemModel>();
    private String[] desc ={"حد يعرف مكونات الزبادي اللي بيتعمل في البيت؟"};
    private int[] image = {R.drawable.type_food};
    private String[] types = {"فزعة أكل"};
    private String[] gender ={"سيدات"};
    private String[] views = {"4 فزعات"};
    private String[] times = {"منذ 4 ساعات"};
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);
        rvProblems = (RecyclerView) view.findViewById(R.id.rv_Problems);
        rvProblems.setHasFixedSize(true);

        setView();


        return view;
    }

    private void setView(){
        problemModels.clear();
        for (int i=0;i<desc.length;i++) {
            ProblemModel model = new ProblemModel(desc[i], times[i], gender[i], types[i], views[i], image[i]);
            problemModels.add(model);

            layoutManager = new LinearLayoutManager(getActivity());
            rvProblems.setLayoutManager(layoutManager);
            rvProblems.setAdapter(new WaitingAcceptedAdapter(problemModels, getContext(),true));
        }
    }
}
