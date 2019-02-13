package com.example.netcore.baseproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.netcore.baseproject.Model.MasterModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    List<MasterModel> notificationList;

    public RecyclerAdapter(Context applicationContext, List<MasterModel> notificationList) {
        context=applicationContext;
        this.notificationList=notificationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_message.setText(notificationList.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv_message;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv_message=itemView.findViewById(R.id.text_message);

    }
}
}
