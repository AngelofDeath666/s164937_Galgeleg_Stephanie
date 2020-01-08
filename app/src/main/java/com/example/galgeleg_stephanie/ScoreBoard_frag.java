package com.example.galgeleg_stephanie;

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


    @Override
    public View onCreateView(LayoutInflater iii, ViewGroup container, Bundle savedInstanceState) {
        scoreboard = iii.inflate(R.layout.score_board,container,false);
        //super.onCreate(savedInstanceState);

        home = scoreboard.findViewById(R.id.homeScoreboard);

        ArrayList<ScoreBoardArray> sbList = new ArrayList<>();
        sbList.add(new ScoreBoardArray("Johan","2"));
        sbList.add(new ScoreBoardArray("Stephanie","4"));

        sbRecyclerView = scoreboard.findViewById(R.id.recyclerVeiw);
        sbRecyclerView.setHasFixedSize(true);
        sbLayoutManager = new LinearLayoutManager(scoreboard.getContext());
        sbAdapter = new ScoreBoardAdapter(sbList);

        sbRecyclerView.setLayoutManager(sbLayoutManager);
        sbRecyclerView.setAdapter(sbAdapter);
        home.setOnClickListener(this);

        return scoreboard;


    }

    @Override
    public void onClick(View v) {
        if (v == getActivity().findViewById(R.id.homeScoreboard)){
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
}
