package com.designtask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.designtask.Models.ProblemModel;
import com.designtask.R;

import java.util.List;

public class WaitingAcceptedAdapter extends RecyclerView.Adapter<WaitingAcceptedAdapter.MyViewHolder> {


    private List<ProblemModel> problemModelList;
    private Context context;
    private LayoutInflater inflater;
    private boolean button;


    public WaitingAcceptedAdapter(List<ProblemModel> problemModelList, Context context,boolean button) {
        this.problemModelList = problemModelList;
        this.context = context;
        this.button=button;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public WaitingAcceptedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new WaitingAcceptedAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WaitingAcceptedAdapter.MyViewHolder holder, int position) {
        ProblemModel problemModel = problemModelList.get(position);
        holder.tvTime.setText(problemModel.getProTime());
        holder.tvType.setText(problemModel.getProType());
        holder.tvGender.setText(problemModel.getProGender());
        holder.tvViews.setText(problemModel.getProViews());
        holder.tvDesc.setText(problemModel.getProDescription());

        if (button)
        {
            holder.btn_cancel.setVisibility(View.GONE);
        }else {
            holder.btn_cancel.setVisibility(View.VISIBLE);
        }

        holder.iv_image_type.setImageResource(problemModel.getProImage());
    }

    @Override
    public int getItemCount() {
        return problemModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTime,tvType,tvGender,tvDesc,tvViews;
        ImageView iv_image_type;
        Button btn_cancel;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            tvViews = (TextView) itemView.findViewById(R.id.tv_views);
            iv_image_type = (ImageView) itemView.findViewById(R.id.iv_image_type);
            btn_cancel=(Button)itemView.findViewById(R.id.btn_cancel);

        }


    }


}
