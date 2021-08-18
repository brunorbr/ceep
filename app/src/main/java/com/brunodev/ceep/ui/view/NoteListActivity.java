package com.brunodev.ceep.ui.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.brunodev.ceep.R;
import com.brunodev.ceep.dao.NoteDAO;
import com.brunodev.ceep.model.Note;
import com.brunodev.ceep.ui.recycler.adapter.NoteListAdapter;


import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list_activity);

        RecyclerView noteList = findViewById(R.id.note_list_recycler_view);

        NoteDAO dao = new NoteDAO();

        for(int i = 0; i < 10000; i++) {
            dao.add(new Note("Title " + i,
                    "Description " + i));
        }
        List<Note> allNotes = dao.listAll();

        noteList.setAdapter(new NoteListAdapter());
    }
}
