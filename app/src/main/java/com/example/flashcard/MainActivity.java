package com.example.flashcard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String difficultyLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Charger les boutons
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
        Button listButton = findViewById(R.id.listButton);
        listButton.setOnClickListener(this);
        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(this);
    }

    /**
     * Méthode pour créer un quizz correspondant à la difficulté choise par l'utilisateur
     * Passe à l'activity suivante
     * @param difficulty 1 = facile, 2 = normal, 3 = difficile
     */
    public void generateQuizz(int difficulty){
        // Ecrire le niveau de difficulté
        switch (difficulty){
            case Quizz.DIFFICULTY_EASY:
                difficultyLevel = "facile";
                break;
            case Quizz.DIFFICULTY_NORMAL:
                difficultyLevel = "normal";
                break;
            case Quizz.DIFFICULTY_HARD:
                difficultyLevel = "difficile";
                break;
            case Quizz.DIFFICULTY_EXTREME:
                difficultyLevel = "extreme";
                break;
        }
        
        // Afficher un message indiquant le début de la partie
        Toast.makeText(getApplicationContext(),
                "Niveau de difficulté choisi : " + difficultyLevel,
                Toast.LENGTH_SHORT).show();

        // Décider de la page où aller
        Intent playIntent = new Intent(MainActivity.this, GameActivity.class);

        // Créer un quizz
        Quizz actualQuizz = new Quizz(difficulty);

        // Transmettre le quizz à la prochaine activité
        playIntent.putExtra("Quizz", actualQuizz);

        // Lancer la nouvelle activity
        startActivity(playIntent);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.playButton:
                // Créer une boite de dialogue
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                setContentView(R.layout.dialogbox);
                alert.setTitle("Quel niveau de difficulté voulez-vous choisir?");
                String[] difficultyLevel = {
                        "FACILE",
                        "MOYEN",
                        "DIFFICILE",
                        "EXTREME"};
                // Créer la liste des buttons
                // On utilise la valeur -1 pour l'argument checkedItem pour indiquer qu'aucun bouton est coché
                alert.setSingleChoiceItems(difficultyLevel, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int difficulty) {
                        switch (difficulty) {
                            case Quizz.DIFFICULTY_EASY:
                                generateQuizz(difficulty);
                                break;
                            case Quizz.DIFFICULTY_NORMAL:
                                generateQuizz(difficulty);
                                break;
                            case Quizz.DIFFICULTY_HARD:
                                generateQuizz(difficulty);
                                break;
                            case Quizz.DIFFICULTY_EXTREME:
                                generateQuizz(difficulty);
                                break;
                        }
                    }
                });
                alert.show();
                break;

            case R.id.listButton:
                Intent listIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(listIntent);
                break;

            case R.id.aboutButton:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
    }
}