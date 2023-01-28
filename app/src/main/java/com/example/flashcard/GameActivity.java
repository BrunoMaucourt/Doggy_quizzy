package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    String actualAnswer;
    Boolean answerChoosed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Récupérer l'intent qui a généré cette page
        Intent srcIntent = getIntent();
        System.out.println("srcIntent " + srcIntent);

        // Récupérer l'objet quizz
        Quizz quizz = srcIntent.getParcelableExtra("Quizz");

        // Récupérer la question actuelle
        Question actualQuestion = quizz.getActualQuestion();

        // Modifier l'image
        ImageView questionPictureImageView = findViewById(R.id.questionPictureImageView);
        questionPictureImageView.setImageResource(actualQuestion.getPicture());

        // Agrandir l'image
        questionPictureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zoomIntent = new Intent(GameActivity.this, PictureActivity.class);
                zoomIntent.putExtra("Quizz",quizz);
                startActivity(zoomIntent);

            }
        });


        // Modifier la description
        TextView questionDescriptionTextView = findViewById(R.id.questionDescriptionTextView);
        questionDescriptionTextView.setText(actualQuestion.getDescription());

        // Modifier le numéro de question
        TextView questionNumberTextView = findViewById(R.id.questionTitleTextView);
        questionNumberTextView.setText("Question " + quizz.getActualQuestionNumber() + " / " + quizz.getTotalQuestionNumber());

        // Masquer le textView bonne réponse
        TextView questionGoodAnswerTextView = findViewById(R.id.questionGoodAnswerTextView);
        questionGoodAnswerTextView.setText("");

        // Modifier le champ d'input
        EditText questionAnswerEditText = findViewById(R.id.questionAnswerEditText);
        if(quizz.getDifficultyInt() == Quizz.DIFFICULTY_EXTREME){
            questionAnswerEditText.setVisibility(View.VISIBLE);
        }

        // Ajouter la liste des réponses
        //TODO : addapter pour les questions sans réponses
        // Créer un groupe de boutons
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        // Pour chaque réponse de la liste
        for(int i=0; i<actualQuestion.getAnswerList().size(); i++){

            RadioButton rb = new RadioButton(this);
            rb.setText(actualQuestion.getAnswerList().get(i).toString());
            rb.setTextColor(Color.parseColor("#673AB7"));
            rb.setTextSize(20);
            radioGroup.addView(rb); //the RadioButtons are added to the radioGroup instead of the layout
        }

        // gérer le clic
        Button questionValidationButton = findViewById(R.id.questionValidationButton);
        questionValidationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Vérifier si une réponse a déjà été proposée
                if(answerChoosed == false){

                    // Mode de jeu classique
                    // Aucune réponse n'a été sélectionné
                    // Récupérer le numéro du radio button sélectionné
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    if (checkedRadioButtonId != -1) {
                        // Récupérer le radio button qui a été sélectionné
                        View checkedDadioButton = radioGroup.findViewById(checkedRadioButtonId);
                        int idx = radioGroup.indexOfChild(checkedDadioButton);
                        RadioButton r = (RadioButton) radioGroup.getChildAt(idx);

                        // Récupérer le texte associé au bouton sélectionné
                        actualAnswer = r.getText().toString();
                    }

                    // Mode de jeu Extreme
                    // Récupérer les données du champ de texte
                    if(quizz.getDifficultyInt() == Quizz.DIFFICULTY_EXTREME){
                        actualAnswer = questionAnswerEditText.getText().toString();
                        // Si vide alors égal à null
                        if(actualAnswer.equals("") || actualAnswer.equals(" ")){
                            actualAnswer = null;
                        }
                    }

                    // Si une réponse a été sélectionnée alors la vérifier sinon indiquer "choisir une réponse"
                    if(actualAnswer != null){
                        // Vérifier si la réponse est bonne
                        if(actualQuestion.checkAnswer(actualAnswer)){
                            Toast.makeText(getApplicationContext(),
                                    "Bonne réponse",
                                    Toast.LENGTH_SHORT).show();

                            // Mettre à jour le score
                            quizz.setScore(1);
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "Mauvaise réponse",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // Afficher la bonne réponse
                        questionGoodAnswerTextView.setText(actualQuestion.getGoodAnswer());

                        // Modifier le texte du bouton
                        if(quizz.getStep() < 2){
                            questionValidationButton.setText("Passer à la question suivante");
                        }else{
                            questionValidationButton.setText("Afficher les statistiques de fin");
                        }

                        // Modifier le booléan pour indiquer qu'une réponse a été sélectionnée
                        answerChoosed = true;
                    }else{
                        // Afficher un message indiquant aucune réponse sélectionnée
                        Toast.makeText(getApplicationContext(),
                                "Veuillez choisir une réponse",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{// Si answerChoosed == true
                    // Ajouter +1 au step
                    if(quizz.getStep() == 2){
                        // Annoncer le prochaine Intent
                        Intent newIntent = new Intent(GameActivity.this, KpiActivity.class);

                        // TODO Transmettre l'objet quizz à la prochaine activity
                        newIntent.putExtra("Quizz", quizz);

                        // TODO Mettre fin à l'activity
                        // TODO Lancer la nouvelle activity
                        startActivity(newIntent);
                        finish();
                    }else{
                        // Passer à la question suivante
                        quizz.setStep(1);

                        // Annoncer le prochaine Intent
                        Intent newIntent = new Intent(GameActivity.this, GameActivity.class);

                        // TODO Transmettre l'objet quizz à la prochaine activity
                        newIntent.putExtra("Quizz", quizz);

                        // TODO Mettre fin à l'activity
                        // TODO Lancer la nouvelle activity
                        startActivity(newIntent);
                        finish();
                    }
                }
            }
        });
    }

    // Ajouter un layout        ConstraintLayout picLL = new ConstraintLayout(this);
    //        picLL.setBackgroundColor(Color.parseColor("#ECA2AF"));
    //        picLL.layout(0, 0, 0, 0);
    //        picLL.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    //
    //        // Ajouter l'image associée à la question
    //        ImageView myImage = new ImageView(this);
    //        myImage.setImageResource(q1.getPicture());
    //        picLL.addView(myImage);
    //
    //        // Ajouter l'ennoncé de la question
    //        TextView descriptionEditText = new TextView(this);
    //        descriptionEditText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    //        descriptionEditText.setText(q1.getDescription());
    //        descriptionEditText.setTextColor(Color.parseColor("#673AB7"));
    //        picLL.addView(descriptionEditText);
}