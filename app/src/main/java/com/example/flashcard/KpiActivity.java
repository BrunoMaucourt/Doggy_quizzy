package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KpiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpi);
    Intent srcIntent = getIntent();
    Quizz quizz = srcIntent.getParcelableExtra("Quizz");

        // charger le button
        Button returnButton = findViewById(R.id.returnKpiButton);

        // Action lors du click
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Déclarer le changement de page
                Intent main = new Intent(KpiActivity.this, MainActivity.class);
                // Lancer la nouvelle page
                startActivity(main);
            }
        });

        TextView difficultydisplay = findViewById(R.id.kpiDifficultyTextView);
        difficultydisplay.setText("Niveau de difficulté" +" "+quizz.getDifficulty());

        TextView scoreDisplay = findViewById(R.id.scoreTextView);
        scoreDisplay.setText(quizz.getScore() +"/"+ quizz.getQuestionsList().size());
    }
}