package com.brunodev.ceep.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.brunodev.ceep.model.Note;

public class NoteDAO {

    private final static ArrayList<Note> NOTES = new ArrayList<>();

    public List<Note> listAll() {
        return (List<Note>) NOTES.clone();
    }

    public void add(Note... notes) {
        NoteDAO.NOTES.addAll(Arrays.asList(notes));
    }

    public void edit(int position, Note note) {
        NOTES.set(position, note);
    }

    public void delete(int position) {
        NOTES.remove(position);
    }

    public void swapPositions(int initialPosition, int endPosition) {
        Collections.swap(NOTES, initialPosition, endPosition);
    }

    public void deleteAll() {
        NOTES.clear();
    }
}
