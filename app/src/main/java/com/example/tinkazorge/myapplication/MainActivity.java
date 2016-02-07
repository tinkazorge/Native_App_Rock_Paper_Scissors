package com.example.tinkazorge.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView chooseText;
    Button rockButton;
    Button paperButton;
    Button scissorsButton;
    int userinput = 0;
    int computer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chooseText = (TextView) findViewById(R.id.textView);
        rockButton = (Button) findViewById(R.id.rock_button);
        paperButton = (Button) findViewById(R.id.paper_button);
        scissorsButton = (Button) findViewById(R.id.scissors_button);


        //register clicks and give userinput a certain number with each click
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userinput = 1;
                WinTieLose();
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userinput = 2;
                WinTieLose();
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userinput = 3;
                WinTieLose();
            }
        });
    }

    public void WinTieLose() {
        // give computer a random number between 1 and 3
        Random rand = new Random();
        computer = rand.nextInt(3) + 1;

        if ((computer == 1 && userinput == 1) || (computer == 2 && userinput == 2) || (computer == 3 && userinput == 3)) {
            Intent intent = new Intent(MainActivity.this, TieActivity.class);
            startActivity(intent);
        }
        if ((computer == 1 && userinput == 3) || (computer == 2 && userinput == 1) || (computer == 3 && userinput == 2)) {
            Intent intent = new Intent(MainActivity.this, LoseActivity.class);
            startActivity(intent);
        }
        if ((computer == 1 && userinput == 2) || (computer == 2 && userinput == 3) || (computer == 3 && userinput == 1)) {
            Intent intent = new Intent(MainActivity.this, WinActivity.class);
            startActivity(intent);
        }
    }

}
