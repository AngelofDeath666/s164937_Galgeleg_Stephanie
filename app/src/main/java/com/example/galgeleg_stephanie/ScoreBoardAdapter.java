package com.example.galgeleg_stephanie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreBoardAdapter extends RecyclerView.Adapter<ScoreBoardAdapter.ScoreBoardViewHolder> {
    private ArrayList<ScoreBoardArray> sbList;


    public static class ScoreBoardViewHolder extends RecyclerView.ViewHolder {
        public TextView sbaName;
        public TextView sbaTries;

        public ScoreBoardViewHolder(View itemView) {
            super(itemView);
            sbaName = itemView.findViewById(R.id.high_names);
            sbaTries = itemView.findViewById(R.id.tries);


        }
    }

    public ScoreBoardAdapter(ArrayList<ScoreBoardArray> scoreBoardList) {
        sbList = scoreBoardList;

    }

    @Override
    public ScoreBoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_board, parent, false);
        ScoreBoardViewHolder sbvh = new ScoreBoardViewHolder(v);
        return sbvh;
    }

    @Override
    public void onBindViewHolder(ScoreBoardViewHolder holder, int position) {
        ScoreBoardArray currentScore = sbList.get(position);

        holder.sbaName.setText(currentScore.getSbName());
        holder.sbaTries.setText(currentScore.getSbTries());


    }

    @Override
    public int getItemCount() {
        return sbList.size();
    }
}
