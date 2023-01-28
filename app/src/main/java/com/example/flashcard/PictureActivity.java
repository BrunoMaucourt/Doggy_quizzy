package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);


        Intent srcIntent = getIntent();
        Quizz quizz = srcIntent.getParcelableExtra("Quizz");
        Question actualQuestion = quizz.getActualQuestion();

        ImageView questionPictureImageView = findViewById(R.id.questionPictureImageView);
        questionPictureImageView.setImageResource(actualQuestion.getPicture());

        questionPictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }});
    }
}