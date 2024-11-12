package com.example.notesapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNotes = findViewById(R.id.listViewNotes);

        loadNotes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAddNote) {
            startActivity(new Intent(this, AddNoteActivity.class));
            return true;
        } else if (id == R.id.menuDeleteNote) {
            startActivity(new Intent(this, DeleteNoteActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void loadNotes() {
        SharedPreferences prefs = getSharedPreferences("NotesApp", MODE_PRIVATE);
        Map<String, ?> notes = prefs.getAll();

        ArrayList<String> noteTitles = new ArrayList<>(notes.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteTitles);
        listViewNotes.setAdapter(adapter);

        Log.d("MainActivity", "Notes loaded: " + noteTitles.size() + " items");
    }
}

