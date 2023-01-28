package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Question> questions;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // charger le button
        Button returnButton = findViewById(R.id.returnListButton);

        // Action lors du click
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Déclarer le changement de page
                Intent main = new Intent(ListActivity.this, MainActivity.class);
                // Lancer la nouvelle page
                startActivity(main);
            }
        });

        questions = new ArrayList<>();

        Quizz quizzEasy = new Quizz(Quizz.DIFFICULTY_EASY);
        for(int i = 0; i < quizzEasy.getQuestionsList().size(); i ++){
            questions.add(quizzEasy.getQuestionsList().get(i));
        }

        Quizz quizzNormal = new Quizz(Quizz.DIFFICULTY_NORMAL);
        for(int i = 0; i < quizzNormal.getQuestionsList().size(); i ++){
            questions.add(quizzNormal.getQuestionsList().get(i));
        }

        Quizz quizzHard = new Quizz(Quizz.DIFFICULTY_HARD);
        for(int i = 0; i < quizzHard.getQuestionsList().size(); i ++){
            questions.add(quizzHard.getQuestionsList().get(i));
        }

        Quizz quizzExtreme = new Quizz(Quizz.DIFFICULTY_EXTREME);
        for(int i = 0; i < quizzExtreme.getQuestionsList().size(); i ++){
            questions.add(quizzExtreme.getQuestionsList().get(i));
        }

        adapter = new ListAdapter(questions);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}