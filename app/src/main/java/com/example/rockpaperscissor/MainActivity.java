package com.example.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int playerScore = 0, comScore = 0;
    Button rockButton, paperButton, scissorButton;
    ProgressBar playerProgress, comProgress;
    ImageView playerImg, comImg;
    TextView decisionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockButton = (Button) findViewById(R.id.rockButton);
        paperButton = (Button) findViewById(R.id.paperButton);
        scissorButton = (Button) findViewById(R.id.scissorButton);

        playerProgress = (ProgressBar) findViewById(R.id.playerProgress);
        comProgress = (ProgressBar) findViewById(R.id.comProgress);

        playerImg = (ImageView) findViewById(R.id.playerImg);
        comImg = (ImageView) findViewById(R.id.comImg);

        decisionText = (TextView) findViewById(R.id.decisionText);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImg.setImageResource(R.drawable.rock);
                computerPlay("rock");
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImg.setImageResource(R.drawable.paper);
                computerPlay("paper");
            }
        });

        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImg.setImageResource(R.drawable.scissors);
                computerPlay("scissor");
            }
        });

    }

    public void computerPlay(String playerChoice){
        String comChoice = "";
        Random random = new Random();
        int comInt = random.nextInt(3) + 1;

        if(comInt == 1){
            comChoice = "rock";
            comImg.setImageResource(R.drawable.rock);
        }
        else if(comInt == 2){
            comChoice = "paper";
            comImg.setImageResource(R.drawable.paper);

        }
        else if(comInt == 3){
            comChoice = "scissor";
            comImg.setImageResource(R.drawable.scissors);
        }

        if(playerChoice == comChoice){
            decisionText.setText("DRAW");
        }
        else if(playerChoice == "rock" && comChoice == "scissor"){
            decisionText.setText("YOU WIN");
            playerScore++;
        }
        else if(playerChoice == "paper" && comChoice == "rock"){
            decisionText.setText("YOU WIN");
            playerScore++;
        }
        else if(playerChoice == "scissor" && comChoice == "paper"){
            decisionText.setText("YOU WIN");
            playerScore++;
        }
        else if(playerChoice == "rock" && comChoice == "paper"){
            decisionText.setText("YOU LOSE");
            comScore++;
        }
        else if(playerChoice == "paper" && comChoice == "scissor"){
            decisionText.setText("YOU LOSE");
            comScore++;
        }
        else if(playerChoice == "scissor" && comChoice == "rock"){
            decisionText.setText("YOU LOSE");
            comScore++;
        }
        else{
            decisionText.setText("INVALID");
        }
        updateProgress();

    }

    public void updateProgress(){
        playerProgress.setProgress(playerScore);
        comProgress.setProgress(comScore);
    }
}
