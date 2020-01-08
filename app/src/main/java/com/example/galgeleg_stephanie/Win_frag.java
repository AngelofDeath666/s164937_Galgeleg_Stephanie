package com.example.galgeleg_stephanie;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import nl.dionsegijn.konfetti.KonfettiView;

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

        final KonfettiView konfettiView = youWin.findViewById(R.id.viewKonfetti);

        konfettiView.build()
                .addColors(Color.MAGENTA, Color.GREEN, Color.RED)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.CIRCLE, Shape.RECT)
                .addSizes(new Size(12,5f))
                .setPosition(-50f, 1000f + 50f, -50f, -50f)
                .streamFor(300, 5000L);


        return youWin;
    }


    @Override
    public void onClick(View v) {
        for (Fragment fragment:getFragmentManager().getFragments()) {
            getFragmentManager().beginTransaction().remove(fragment).commit();

        }

        getActivity().findViewById(R.id.spil).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.hjaelp).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.indstillinger).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.title1).setVisibility(View.VISIBLE);


    }

}
