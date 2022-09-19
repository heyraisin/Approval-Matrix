package com.example.approvalmatrix;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, name, feature, min, max, total;

    public CustomAdapter(Context context, ArrayList id, ArrayList name, ArrayList feature, ArrayList min, ArrayList max, ArrayList total) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.feature = feature;
        this.min = min;
        this.max = max;
        this.total = total;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

//    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.feature_txt.setText(String.valueOf(feature.get(position)));
        holder.min_txt.setText(String.valueOf(min.get(position)));
        holder.max_txt.setText(String.valueOf(max.get(position)));
        holder.total_txt.setText(String.valueOf(total.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name_txt, feature_txt, min_txt, max_txt, total_txt;
//        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.name_txt);
            feature_txt = itemView.findViewById(R.id.feature_txt);
            min_txt = itemView.findViewById(R.id.min_txt);
            max_txt = itemView.findViewById(R.id.max_txt);
            total_txt = itemView.findViewById(R.id.total_txt);
        }
    }
}
