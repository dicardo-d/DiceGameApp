package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // creating array for the spinner
    private Spinner spinner;
    private Button spinButton;
    private Dice selectedDice;
    private TextView afterTextView;
    private TextView beforeTextView;

    Dice[] dices = new Dice[6];
    String[] diceNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //applying spinner
        spinner = findViewById(R.id.spinner);
        spinButton = findViewById(R.id.button);
        afterTextView = findViewById(R.id.textView4);
        beforeTextView = findViewById(R.id.textView3);

        dices[0] = new Dice(4, "Dice 4");
        dices[1] = new Dice(6, "Dice 6");
        dices[2] = new Dice(8, "Dice 8");
        dices[3] = new Dice(10, "Dice 10");
        dices[4] = new Dice(12, "Dice 12");
        dices[5] = new Dice(20, "Dice 20");


        diceNames = new String[dices.length];

        for(int i = 0; i < diceNames.length; i++) {
            Dice localDice = dices[i];
            diceNames[i] = localDice.getName();
        }

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rollItem = selectedDice.roll();
                if (!afterTextView.getText().toString().isEmpty() && !afterTextView.getText().toString().equals("After")) {
                    beforeTextView.setText(afterTextView.getText());
                }
                afterTextView.setText(String.valueOf(rollItem));
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, diceNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choice = adapterView.getItemAtPosition(i).toString();
                selectedDice = dices[i];
                Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}