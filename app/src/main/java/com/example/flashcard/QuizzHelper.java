package com.example.flashcard;

import java.util.ArrayList;
import java.util.Collections;

public class QuizzHelper {

    /**
     * Méthode permettant de créer la liste des questions de difficulté facile
     * @return liste de question facile (mélangée)
     */
    public static ArrayList<Question> generateEasyQuestion(){

        ArrayList<String> q1Answers = new ArrayList<String>();
        q1Answers.add("Corgi");
        q1Answers.add("Pit-bull");
        Question q1 = new Question("Quelle est la race des chiens préférée de la Reine d’Angleterre ?",
                "Corgi",
                R.drawable.corgi,
                q1Answers);

        ArrayList<String> q2Answers = new ArrayList<String>();
        q2Answers.add("Border collie");
        q2Answers.add("Chihuahua");
        Question q2 = new Question("Quelle est la race de chien la plus intelligente ?",
                "Border collie",
                R.drawable.border_collie,
                q2Answers);

        ArrayList<String> q3Answers = new ArrayList<String>();
        q3Answers.add("Beagle");
        q3Answers.add("Saint-bernard");
        Question q3 = new Question("Quelle est la race du chien ayant le record du plus grand nombre de ballons arrêtés ?",
                "Beagle",
                R.drawable.beagle,
                q3Answers);

        // Ajouter les questtions dans une liste
        ArrayList<Question> easyQuestions = new ArrayList<>();
        easyQuestions.add(q1);
        easyQuestions.add(q2);
        easyQuestions.add(q3);

        // Mélanger l'ordre des questions
        Collections.shuffle(easyQuestions);

        return easyQuestions;
    };

    /**
     * Méthode permettant de créer la liste de questions de difficulté moyenne
     * @return la liste des questions moyenne (mélangée)
     */
    public static ArrayList<Question> generateMediumQuestion(){

        ArrayList<String> q1Answer = new ArrayList<String>();
        q1Answer.add("Colley");
        q1Answer.add("Chihuahua");
        q1Answer.add("Berger Allemand");
        q1Answer.add("berger de Brie");
        Question q1 = new Question("Quelle est la race de Blair, le premier chien à avoir été un héro dans un film ?",
                "Colley",
                R.drawable.colley,
                q1Answer);

        ArrayList<String> q2Answer = new ArrayList<String>();
        q2Answer.add("Husky");
        q2Answer.add("Terrier");
        q2Answer.add("Berger Allemand");
        q2Answer.add("Pédigré inconnu");
        Question q2 = new Question("Quelle est la race de Laika, le premier chien à avoir été dans l'espace ?",
                "Pédigré inconnu",
                R.drawable.laika,
                q2Answer);

        ArrayList<String> q3Answer = new ArrayList<String>();
        q3Answer.add("Corgi");
        q3Answer.add("Pit-bull");
        q3Answer.add("Basenji");
        q3Answer.add("Samoyède");
        Question q3 = new Question("Quelle est la race de chien qui n’aboie pas ?",
                "Basenji",
                R.drawable.basenji,
                q3Answer);

        // Créer la liste des questions
        ArrayList<Question> mediumQuestions = new ArrayList<>();
        mediumQuestions.add(q1);
        mediumQuestions.add(q2);
        mediumQuestions.add(q3);

        // Mélanger l'ordre des questions
        Collections.shuffle(mediumQuestions);

        return mediumQuestions;
    };

    /* Niveau Dur */
    public static ArrayList<Question> generateDifficultQuestion(){

        ArrayList<String> q1Answer = new ArrayList<String>();
        q1Answer.add("32");
        q1Answer.add("34");
        q1Answer.add("42");
        q1Answer.add("50");
        q1Answer.add("58");
        Question q1 = new Question("Combien de dents ont les chiens?",
                "42",
                R.drawable.teeth,
                q1Answer);

        ArrayList<String> q2Answer = new ArrayList<String>();
        q2Answer.add("entre 8 et 10 ans");
        q2Answer.add("entre 10 ans et 12 ans");
        q2Answer.add("entre 12 ans et 14 ans");
        q2Answer.add("entre 14 ans et 16 ans");
        q2Answer.add("plus de 16 ans");
        Question q2 = new Question("Quel est l'âge moyen d'un chien ?",
                "entre 10 ans et 12 ans",
                R.drawable.birthday,
                q2Answer);

        ArrayList<String> q3Answer = new ArrayList<String>();
        q3Answer.add("Chine");
        q3Answer.add("Russie");
        q3Answer.add("Brésil");
        q3Answer.add("Etats-Unis");
        q3Answer.add("Inde");
        Question q3 = new Question("Dans quel pays du monde se trouve le plus de chiens ?",
                "Etats-Unis",
                R.drawable.world_map,
                q3Answer);

        // Créer la liste des questions
        ArrayList<Question> difficultQuestions = new ArrayList<>();
        difficultQuestions.add(q1);
        difficultQuestions.add(q2);
        difficultQuestions.add(q3);

        // Mélanger l'ordre des questions
        Collections.shuffle(difficultQuestions);

        return difficultQuestions;
    };




    /**
     * Méthode permettant de créer la liste de questions de difficulté difficile
     * Les questions n'ont pas de réponses proposées (l'ArrayListe est donc vide)
     * @return la liste des questions moyenne (mélangée)
     */
    public  static ArrayList<Question> generateHardQuestion(){
        ArrayList<String> q1Answer = new ArrayList<>();
        Question q1 = new Question("Quelle est la race de Snuppy, le premier chien cloné (2005) ?",
                "Lévrier afghan",
                R.drawable.cloned_dog,
                q1Answer);

        ArrayList<String> q2answer = new ArrayList<>();
        Question q2 = new Question("Quelle est la race du chien Hatchi héro du film éponyme de 2009 ?",
                "Akita",
                R.drawable.akita,
                q2answer);

        ArrayList<String> q3answer = new ArrayList<>();
        Question q3 = new Question("Quelle est la race du chien qui a incarné Idefix dans Astérix et Obélix : mission Cléopâtre en 2001 ?",
                "Westie",
                R.drawable.westie,
                q3answer);

        // Créer la liste des questions difficile
        ArrayList<Question> hardQuestions = new ArrayList<>();
        hardQuestions.add(q1);
        hardQuestions.add(q2);
        hardQuestions.add(q3);

        // Mélanger l'ordre des questions
        Collections.shuffle(hardQuestions);

        return hardQuestions;
    };
}
