package com.brunodev.ceep.ui.recycler.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brunodev.ceep.model.Note;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter {

    private List<Note> notes;

    public NoteListAdapter(List<Note> notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
