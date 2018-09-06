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

public class AcceptedFragment extends ParentFragment {
    private RecyclerView rvProblems;
    private List<ProblemModel> problemModels = new ArrayList<ProblemModel>();
    private String[] desc ={"شباب حد يعرف كافيه النجم فين في شارع الجلاء","حد يعرف مكونات البسبوسة؟"};
    private int[] image = {R.drawable.type_car,R.drawable.type_food};
    private String[] types = {"فزعة سيارة","فزعة أكل"};
    private String[] gender ={"رجال","سيدات"};
    private String[] views = {"5 فزعات","3 فزعات"};
    private String[] times = {"منذ 12ساعة","منذ 3 ساعات"};
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
            rvProblems.setAdapter(new WaitingAcceptedAdapter(problemModels, getContext(),false));
        }
    }
}
