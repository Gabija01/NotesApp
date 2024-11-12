package com.example.notesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class DeleteNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        SharedPreferences prefs = getSharedPreferences("NotesApp", MODE_PRIVATE);
        Map<String, ?> notes = prefs.getAll();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<>(notes.keySet()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinnerNotes);
        spinner.setAdapter(adapter);

        Button deleteButton = findViewById(R.id.btnDeleteNote);
        deleteButton.setOnClickListener(v -> {
            String selectedNote = spinner.getSelectedItem().toString();
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove(selectedNote);
            editor.apply();
            finish();
        });
    }
}
