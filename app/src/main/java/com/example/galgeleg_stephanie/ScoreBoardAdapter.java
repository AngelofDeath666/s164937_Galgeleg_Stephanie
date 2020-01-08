package com.example.galgeleg_stephanie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreBoardAdapter extends RecyclerView.Adapter<ScoreBoardAdapter.ScoreBoardViewHolder> {
    private ArrayList<HighScores> sbList;
    private String sbaname;
    private int sbatries;

    public static class ScoreBoardViewHolder extends RecyclerView.ViewHolder {

        public ScoreBoardViewHolder(View itemView) {
            super(itemView);

            //add findViev.By.Id here
            //variable = item.View.findViewByID(R.ID.x)
        }
    }

    public ScoreBoardAdapter(ArrayList<HighScores> scoreBoardList) {
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
        HighScores currentScore = sbList.get(position);

        holder.

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
