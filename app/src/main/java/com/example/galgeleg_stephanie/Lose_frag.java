package com.example.galgeleg_stephanie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Lose_frag extends Fragment implements View.OnClickListener {

    private View youLoose;
    TextView correctWord;
    Button homeLost;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        youLoose = i.inflate(R.layout.game_lost,container,false);
        correctWord = youLoose.findViewById(R.id.correctWord);
        homeLost = youLoose.findViewById(R.id.homeLost);

        homeLost.setOnClickListener(this);

        correctWord.setText("Du har tabt. Det korrekte ord var: " + getArguments().getString("theCorrectWord"));



        return youLoose;
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
