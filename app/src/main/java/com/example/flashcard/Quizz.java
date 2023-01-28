package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Quizz implements Parcelable {

    private int step;
    private int score;
    private int difficulty;
    public ArrayList<Question> questionsList;

    public static final int DIFFICULTY_EASY = 0;
    public static final int DIFFICULTY_NORMAL = 1;
    public static final int DIFFICULTY_HARD = 2;
    public static final int DIFFICULTY_EXTREME = 3;

    public Quizz(int difficulty){
        this.difficulty = difficulty;

        // de base score est égal à zéro en début de partie
        this.score = 0;

        // de base step est égale à zéro en début de partie
        this.step = 0;

        // Générer la liste de question selon le niveau de difficulté
        switch (this.difficulty){
            case DIFFICULTY_EASY:
                this.questionsList = QuizzHelper.generateEasyQuestion();
                break;
            case DIFFICULTY_NORMAL:
                this.questionsList = QuizzHelper.generateMediumQuestion();
                break;
            case DIFFICULTY_HARD:
                this.questionsList = QuizzHelper.generateDifficultQuestion();
                break;
            case DIFFICULTY_EXTREME:
                this.questionsList = QuizzHelper.generateHardQuestion();
                break;
        }
    }

    protected Quizz(Parcel in) {
        step = in.readInt();
        score = in.readInt();
        difficulty = in.readInt();
        questionsList = in.createTypedArrayList(Question.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(step);
        dest.writeInt(score);
        dest.writeInt(difficulty);
        dest.writeTypedList(questionsList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Quizz> CREATOR = new Creator<Quizz>() {
        @Override
        public Quizz createFromParcel(Parcel in) {
            return new Quizz(in);
        }

        @Override
        public Quizz[] newArray(int size) {
            return new Quizz[size];
        }
    };

    public void setScore(int value){
        this.score += value;
    }

    public void setStep(int value){
        this.step += value;
    }

    public String getDifficulty(){
        String difficultyLevel = "";
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
        return difficultyLevel;
    }

    public int getDifficultyInt(){
        return this.difficulty;
    }

    public int getStep(){
        return this.step;
    }

    public int getActualQuestionNumber(){
        return this.step + 1;
    }

    public int getScore(){
        return this.score;
    }

    public ArrayList<Question> getQuestionsList() {
        return this.questionsList;
    }

    public Question getActualQuestion(){
        Question actual = this.questionsList.get(this.step);
        return actual;
    }

    /**
     * Indique le nombre total de question dans la liste
     * @return le nombre de question ou 0 si la liste est nulle
     */
    public int getTotalQuestionNumber(){
        if(this.questionsList.size() == 0){
            return 0;
        }else{
            return this.questionsList.size();
        }
    }
}