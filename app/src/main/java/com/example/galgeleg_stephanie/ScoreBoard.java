package com.example.galgeleg_stephanie;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreBoard extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView sbRecyclerView;
    private RecyclerView.Adapter sbAdapter;
    private RecyclerView.LayoutManager sbLayoutManager;
    private String sbName;
    private String sbTries;

    public ScoreBoard(String name, String tries){
        sbName = name;
        sbTries = tries;
    }

    public String getSbName(){
        return sbName;
    }

    public String getSbTries(){
        return sbTries;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);

        ArrayList<HighScores> sbList = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {

    }
}
