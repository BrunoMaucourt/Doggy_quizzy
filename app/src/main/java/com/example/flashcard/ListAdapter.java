package com.example.flashcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Question> questions;

    public ListAdapter(List<Question> questions){
        this.questions = questions;
    }

    // Appeller uniquement au début pour initialiser les éléments de base
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Le fiher xml est "parsé"
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.questionTitle.setText(question.getDescription());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    // Garde le lien avec un élément UI
    class ViewHolder extends RecyclerView.ViewHolder{

        // Charger les éléments de l'unité de base du recyclerView
        final TextView questionTitle;
        final TextView questionDifficulty;

        // Constructeur
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // On ne pas faire directement findview
            questionTitle = itemView.findViewById(R.id.listQuestionTextView);
            questionDifficulty = itemView.findViewById(R.id.listDifficultyTextView);
        }
    }
}
