package com.brunodev.ceep.ui.recycler.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brunodev.ceep.R;
import com.brunodev.ceep.model.Note;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter {

    private List<Note> notes;
    private Context context;

    public NoteListAdapter(List<Note> notes, Context context){
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Note note = notes.get(position);
        TextView title = holder.itemView.findViewById(R.id.note_item_title);
        title.setText(note.getTitle());
        TextView description = holder.itemView.findViewById(R.id.note_item_description);
        description.setText(note.getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
