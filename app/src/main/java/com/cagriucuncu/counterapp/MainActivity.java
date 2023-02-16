package com.cagriucuncu.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView currentNumber;
    private EditText name;
    private Button starButton;
    private Button increaseButton;
    private Button decreaseButton;

    private int number;

    SharedPreferenceService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_UI();
    }


    @Override
    protected void onPause() {
        super.onPause();
        service.setValue(String.valueOf(name.getText()), number);
    }

    private void init_UI(){

        service = new SharedPreferenceService(this);

        currentNumber = (TextView) findViewById(R.id.current_number_tv);
        name = (EditText) findViewById(R.id.nameEditText);
        starButton = (Button) findViewById(R.id.startButton);

        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = service.getValue(String.valueOf(name.getText()));
                currentNumber.setText("Number: " + number);
                increaseButton.setEnabled(true);
                decreaseButton.setEnabled(true);
                name.setEnabled(false);
                starButton.setEnabled(false);
            }
        });

        increaseButton = (Button) findViewById(R.id.increaseButton);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                currentNumber.setText("Number: " + number);
            }
        });

        increaseButton.setEnabled(false);

        decreaseButton = (Button) findViewById(R.id.deceaseButton);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number--;
                currentNumber.setText("Number: " + number);
            }
        });
        decreaseButton.setEnabled(false);

    }
}