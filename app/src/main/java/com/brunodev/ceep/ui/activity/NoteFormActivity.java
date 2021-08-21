package com.brunodev.ceep.ui.activity;

import static com.brunodev.ceep.ui.activity.NoteActivityConstants.NOTE_KEY;
import static com.brunodev.ceep.ui.activity.NoteActivityConstants.SUCCESS_RESULT_CODE;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.brunodev.ceep.R;
import com.brunodev.ceep.model.Note;

public class NoteFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form_add_note, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(checkMenu(item)){
            Note createdNote = createNewNote();
            returnCreatedNote(createdNote);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void returnCreatedNote(Note createdNote) {
        Intent addResult = new Intent();
        addResult.putExtra(NOTE_KEY, createdNote);
        setResult(SUCCESS_RESULT_CODE, addResult);
    }

    @NonNull
    private Note createNewNote() {
        EditText title = findViewById(R.id.note_title_field);
        EditText description = findViewById(R.id.note_description_field);
        return new Note(title.getText().toString(),
                description.getText().toString());
    }

    private boolean checkMenu(@NonNull MenuItem item) {
        return item.getItemId() == R.id.menu_form_note_ic_save;
    }
}