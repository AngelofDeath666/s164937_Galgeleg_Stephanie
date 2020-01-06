package com.example.galgeleg_stephanie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Win_frag extends Fragment implements View.OnClickListener {

    private View youWin;
    TextView attempts,winnerWord;
    Button homeWon;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        youWin = i.inflate(R.layout.game_won,container,false);
        attempts = youWin.findViewById(R.id.attempts);
        winnerWord = youWin.findViewById(R.id.winnerWord);
        homeWon = youWin.findViewById(R.id.homeWon);

        homeWon.setOnClickListener(this);

        winnerWord.setText("Du har vundet. Ordet var: " + getArguments().getString("theCorrectWord"));
        attempts.setText("Antal forsøg: " + getArguments().getString("attempts"));


        return youWin;
    }


    @Override
    public void onClick(View v) {
        for (Fragment fragment:getFragmentManager().getFragments()) {
            getFragmentManager().beginTransaction().remove(fragment).commit();

        }

        getActivity().findViewById(R.id.knap1).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.knap2).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.knap3).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.title1).setVisibility(View.VISIBLE);


    }
}
