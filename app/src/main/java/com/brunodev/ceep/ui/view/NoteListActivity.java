package com.brunodev.ceep.ui.view;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.brunodev.ceep.R;
import com.brunodev.ceep.dao.NoteDAO;
import com.brunodev.ceep.model.Note;
import com.brunodev.ceep.ui.adapter.NoteListAdapter;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list_activity);

        ListView noteList = findViewById(R.id.listView);

        NoteDAO dao = new NoteDAO();
        dao.add(new Note("First note",
                "First description"));

        List<Note> allNotes = dao.listAll();

        noteList.setAdapter(new NoteListAdapter(this, allNotes));
    }
}
