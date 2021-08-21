package com.brunodev.ceep.ui.activity;

import static com.brunodev.ceep.ui.activity.NoteActivityConstants.ADD_NOTE_REQUEST_CODE;
import static com.brunodev.ceep.ui.activity.NoteActivityConstants.NOTE_KEY;
import static com.brunodev.ceep.ui.activity.NoteActivityConstants.SUCCESS_RESULT_CODE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.brunodev.ceep.R;
import com.brunodev.ceep.dao.NoteDAO;
import com.brunodev.ceep.model.Note;
import com.brunodev.ceep.ui.recycler.adapter.NoteListAdapter;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    private NoteListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        List<Note> allNotes = getAllNotes();
        setupRecylcerView(allNotes);
        setupAddNoteAction();
    }

    private void setupAddNoteAction() {
        TextView addNote = findViewById(R.id.note_list_add_note);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNoteFormActivity();
            }
        });
    }

    private void goToNoteFormActivity() {
        Intent noteForm = new Intent(NoteListActivity.this,
                NoteFormActivity.class);
        startActivityForResult(noteForm, ADD_NOTE_REQUEST_CODE);
    }

    private List<Note> getAllNotes() {
        NoteDAO dao = new NoteDAO();
        List<Note> allNotes = dao.listAll();
        return allNotes;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(validateResult(requestCode, resultCode, data)){
            Note receivedNote = (Note) data.getSerializableExtra(NOTE_KEY);
            addReceivedNote(receivedNote);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addReceivedNote(Note receivedNote) {
        new NoteDAO().add(receivedNote);
        adapter.addNote(receivedNote);
    }

    private boolean validateResult(int requestCode, int resultCode, @Nullable Intent data) {
        return checkRequestCode(requestCode) &&
                checkResultCode(resultCode) &&
                hasNote(data);
    }

    private boolean hasNote(@Nullable Intent data) {
        return data.hasExtra(NOTE_KEY);
    }

    private boolean checkResultCode(int resultCode) {
        return resultCode == SUCCESS_RESULT_CODE;
    }

    private boolean checkRequestCode(int requestCode) {
        return requestCode == ADD_NOTE_REQUEST_CODE;
    }

    private void setupRecylcerView(List<Note> allNotes) {
        RecyclerView noteList = findViewById(R.id.note_list_recycler_view);
        setupAdapter(allNotes, noteList);
    }

    private void setupAdapter(List<Note> allNotes, RecyclerView noteList) {
        adapter = new NoteListAdapter(allNotes, this);
        noteList.setAdapter(adapter);
    }
}
