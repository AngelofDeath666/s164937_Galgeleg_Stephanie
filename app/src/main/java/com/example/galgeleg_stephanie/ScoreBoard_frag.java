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
    private String sharedPref;


    @Override
    public View onCreateView(LayoutInflater iii, ViewGroup container, Bundle savedInstanceState) {
        scoreboard = iii.inflate(R.layout.score_board,container,false);

        home = scoreboard.findViewById(R.id.homeScoreboard);
        home.setOnClickListener(this);

        sbRecyclerView = scoreboard.findViewById(R.id.recyclerVeiw);

        ArrayList<ScoreBoardArray> sbList = new ArrayList<>();

        sharedPref = getString(R.string.preferenceFile);
        SharedPreferences mySharedPreferences = getActivity().getSharedPreferences(sharedPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        sbList.add(new ScoreBoardArray(mySharedPreferences.getString(getString(R.string.spiller1),"n/a"), "Forkerte gæt: " + mySharedPreferences.getString(getString(R.string.score1), "n/a")));
        sbList.add(new ScoreBoardArray(mySharedPreferences.getString(getString(R.string.spiller2),"n/a"), "Forkerte gæt: " + mySharedPreferences.getString(getString(R.string.score2), "n/a")));
        sbList.add(new ScoreBoardArray(mySharedPreferences.getString(getString(R.string.spiller3),"n/a"), "Forkerte gæt: " + mySharedPreferences.getString(getString(R.string.score3), "n/a")));

        //sbRecyclerView = scoreboard.findViewById(R.id.recyclerVeiw);
        sbRecyclerView.setHasFixedSize(true);
        sbLayoutManager = new LinearLayoutManager(scoreboard.getContext());
        sbAdapter = new ScoreBoardAdapter(sbList);


        sbRecyclerView.setLayoutManager(sbLayoutManager);
        sbRecyclerView.setAdapter(sbAdapter);



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
