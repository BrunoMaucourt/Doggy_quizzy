package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class Question implements Parcelable {

    private final String description;
    private final String goodAnswer;
    private final int picture;
    private final ArrayList<String> answersList;

    public Question(String description, String goodAnswer, int picture, ArrayList answerList){
        this.description = description;
        this.goodAnswer = goodAnswer;
        this.picture = picture;
        this.answersList = answerList;
        Collections.shuffle(this.answersList);
    }

    protected Question(Parcel in) {
        description = in.readString();
        goodAnswer = in.readString();
        picture = in.readInt();
        answersList = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(goodAnswer);
        dest.writeInt(picture);
        dest.writeStringList(answersList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    /**
     * Vérifier si la réponse à la question est juste si oui renvoyer true sinon false
     * @param userAnswer (String)
     * @return true ou false en fonction de si la réponse est juste (true) ou non
     */
    public Boolean checkAnswer(String userAnswer){
        if (userAnswer.equals(this.goodAnswer)){
            return true;
        }else{
            return false;
        }
    }

    public String getDescription(){
        return this.description;
    }

    public String getGoodAnswer(){
        return "La bonne réponse est " + this.goodAnswer;
    }

    public int getPicture(){
        return this.picture;
    }

    public ArrayList getAnswerList(){
        return this.answersList;
    }
}
