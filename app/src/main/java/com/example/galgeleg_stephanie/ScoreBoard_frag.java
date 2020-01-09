package com.example.galgeleg_stephanie;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreBoard_frag extends Fragment implements View.OnClickListener {
    private View scoreboard;
    private RecyclerView sbRecyclerView;
    private RecyclerView.Adapter sbAdapter;
    private RecyclerView.LayoutManager sbLayoutManager;
    private Button home;
    private String sharedPref, spiller1, spiller2, spiller3, score1, score2, score3;


    @Override
    public View onCreateView(LayoutInflater iii, ViewGroup container, Bundle savedInstanceState) {
        scoreboard = iii.inflate(R.layout.score_board,container,false);
        //super.onCreate(savedInstanceState);

        home = scoreboard.findViewById(R.id.homeScoreboard);

        ArrayList<ScoreBoardArray> sbList = new ArrayList<>();
        //sbList.add(new ScoreBoardArray("Johan","2"));
        //sbList.add(new ScoreBoardArray("Stephanie","4"));

        sbRecyclerView = scoreboard.findViewById(R.id.recyclerVeiw);
        sbRecyclerView.setHasFixedSize(true);
        sbLayoutManager = new LinearLayoutManager(scoreboard.getContext());
        sbAdapter = new ScoreBoardAdapter(sbList);

        sbRecyclerView.setLayoutManager(sbLayoutManager);
        sbRecyclerView.setAdapter(sbAdapter);
        home.setOnClickListener(this);

        sharedPref = getString(R.string.preferenceFile);
        spiller1 = getString(R.string.spiller1);
        spiller2 = getString(R.string.spiller2);
        spiller3 = getString(R.string.spiller3);
        score1 = getString(R.string.score1);
        score2 = getString(R.string.score2);
        score3 = getString(R.string.score3);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(sharedPref, Context.MODE_PRIVATE);

        return scoreboard;


    }

    @Override
    public void onClick(View v) {
        for (Fragment fragment:getFragmentManager().getFragments()) {
            getFragmentManager().beginTransaction().remove(fragment).commit();

        }

        getActivity().findViewById(R.id.spil).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.hjaelp).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.indstillinger).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.scoreboard).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.title1).setVisibility(View.VISIBLE);

    }
}
