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

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private final List<Note> notes;
    private final Context context;

    public NoteListAdapter(List<Note> notes, Context context){
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteListAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(NoteListAdapter.NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bindInfo(note);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void addNote(Note note) {
        notes.add(note);
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.note_item_title);
            description = itemView.findViewById(R.id.note_item_description);
        }

        public void bindInfo(Note note){
            fillUpFields(note);
        }

        private void fillUpFields(Note note) {
            title.setText(note.getTitle());
            description.setText(note.getDescription());
        }
    }
}
