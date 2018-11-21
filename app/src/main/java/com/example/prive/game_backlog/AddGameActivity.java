package com.example.prive.game_backlog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddGameActivity extends AppCompatActivity {

    private EditText name;
    private EditText platform;
    private EditText notes;
    private Spinner status;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String nametxt, platformtxt, notestxt, statustxt, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        name = findViewById(R.id.ChangeTitle);
        platform = findViewById(R.id.ChangePlatform);
        notes = findViewById(R.id.ChangeNotes);
        status = findViewById(R.id.Spinner);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());

        final String[] statusArray = new String[]{"Want to play","Playing","Stalled","Dropped"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, statusArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nametxt = name.getText().toString();
                platformtxt = platform.getText().toString();
                notestxt = notes.getText().toString();
                statustxt = status.getSelectedItem().toString();
                date = date.toString();

                Game game = new Game (nametxt,platformtxt,statustxt,notestxt,date);
                MainActivity.db.gameDao().insertGames(game);

                Intent intent = new Intent(AddGameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
