package com.brunodev.ceep.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.brunodev.ceep.R;
import com.brunodev.ceep.model.Note;
import java.util.List;


public class NoteListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Note> notes;

    public NoteListAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View renderedView = LayoutInflater.from(context)
                .inflate(R.layout.note_item, viewGroup, false);
        Note note = notes.get(position);

        TextView title = renderedView.findViewById(R.id.note_item_title);
        title.setText(note.getTitle());

        TextView descricao = renderedView.findViewById(R.id.note_item_description);
        descricao.setText(note.getDescription());

        return renderedView;
    }
}
