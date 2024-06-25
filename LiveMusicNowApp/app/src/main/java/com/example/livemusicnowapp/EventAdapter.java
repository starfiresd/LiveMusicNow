package com.example.livemusicnowapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter{
    private ArrayList<String> eventData;
    public class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewEvent;
        //public TextView textViewDescription;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEvent = itemView.findViewById(R.id.textViewBand);
            //textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
        public TextView getEventTextView(){
            return textViewEvent;
        }
//        public TextView getDescriptionTextView(){
//            return textViewDescription;
//        }
    }
    public EventAdapter(ArrayList<String> arrayList) {
        eventData = arrayList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item_view, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EventViewHolder tvh = (EventViewHolder) holder;
        tvh.getEventTextView().setText(eventData.get(position));
        //tvh.getDescriptionTextView().setText(eventData.get(position));
    }

    @Override
    public int getItemCount() {
        return eventData.size();
    }
}
