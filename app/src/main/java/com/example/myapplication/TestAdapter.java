package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.movie.com.example.myapplication.Search;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    List<Search>listttt;
    TestAdapter (List<Search>list){
        listttt= list;
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
        Search search = listttt.get(position);
        holder.title.setText(search.getTitle());

    }

    @Override
    public int getItemCount() {
        return listttt.size();
    }

    public class TestHolder extends RecyclerView.ViewHolder {

        TextView  title;
        ImageView img;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTile);

    }
}


    }

