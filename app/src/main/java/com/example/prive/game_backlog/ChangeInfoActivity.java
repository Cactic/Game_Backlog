package com.example.prive.game_backlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ChangeInfoActivity extends AppCompatActivity {

    private EditText editTitle, editPlatform, editNotes;
    private String titleString, platformString, statusString, notesString;
    private Spinner statusSpinner;
    private FloatingActionButton fab;

    private ArrayAdapter<String> arrayAdapter;

    private String[] statusArray = {"Want to Play", "Playing", "Stalled", "Dropped"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_info);

        editTitle = findViewById(R.id.ChangeTitle);
        editPlatform = findViewById(R.id.ChangePlatform);
        editNotes = findViewById(R.id.ChangeNotes);
        statusSpinner = findViewById(R.id.ChangeStatus);
        fab = findViewById(R.id.floatingActionButton);

        final Game game = (Game) getIntent().getSerializableExtra("Game");

        editTitle.setText(game.getName());
        editPlatform.setText(game.getPlatform());
        editNotes.setText(game.getNotes());


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, statusArray);
        statusSpinner.setAdapter(arrayAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleString = editTitle.getText().toString();
                platformString = editPlatform.getText().toString();
                notesString = editNotes.getText().toString();
                statusString = statusSpinner.getSelectedItem().toString();

                game.setName(titleString);
                game.setPlatform(platformString);
                game.setNotes(notesString);
                game.setStatus(statusString);

                MainActivity.db.gameDao().updateGames(game);

                Intent intent = new Intent(ChangeInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
