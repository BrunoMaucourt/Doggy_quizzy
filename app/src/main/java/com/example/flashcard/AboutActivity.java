package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // charger le button
        Button returnButton = findViewById(R.id.returnButton);

        // Action lors du click
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Déclarer le changement de page
                Intent main = new Intent(AboutActivity.this, MainActivity.class);
                // Lancer la nouvelle page
                startActivity(main);
            }
        });
    }
}