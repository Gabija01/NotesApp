package com.example.notesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        Button saveButton = findViewById(R.id.btnSaveNote);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ((EditText) findViewById(R.id.etNoteTitle)).getText().toString();
                String content = ((EditText) findViewById(R.id.etNoteContent)).getText().toString();

                if (!title.isEmpty() && !content.isEmpty()) {
                    SharedPreferences prefs = getSharedPreferences("NotesApp", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(title, content);
                    editor.apply();

                    AppLogger.logNoteSaved(title);

                    Toast.makeText(AddNoteActivity.this, "Užrašas išsaugotas!", Toast.LENGTH_SHORT).show();

                    finish();
                } else {
                    Toast.makeText(AddNoteActivity.this, "Pavadinimas ir turinys negali būti tušti", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
