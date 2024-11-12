package com.example.notesapp;

import android.util.Log;

public class AppLogger {

    public static void logNoteSaved(String title) {
        Log.d("AddNoteActivity", "Note saved: " + title);
    }

    public static void logNoteDeleted(String selectedNote) {
        Log.d("DeleteNoteActivity", "Note deleted: " + selectedNote);
    }
}
