package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TestAdapter extends RecyclerView.Adapter<TestHolder> {

    ArrayList<ModelClass> listModel;
    TestAdapter (ArrayList<ModelClass>list){
        listModel= list;
    }
    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View v =  inflater.inflate(R.layout.recycler_item,parent,false);
        TestHolder holder =  new TestHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        ModelClass modelClass = listModel.get(position);
        holder.title.setText(modelClass.getName());
        holder.img.setImageResource(modelClass.getPic());

    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }
}
 class TestHolder extends RecyclerView.ViewHolder{
    TextView  title;
    ImageView img;

    public TestHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.txtTile);
        img = itemView.findViewById(R.id.imgMe);
    }
}
