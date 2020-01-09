package com.example.galgeleg_stephanie;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import nl.dionsegijn.konfetti.KonfettiView;

public class Win_frag extends Fragment implements View.OnClickListener {

    private View youWin;
    TextView attempts,winnerWord;
    EditText name;
    Button homeWon;
    String sharedPref, score;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        youWin = i.inflate(R.layout.game_won,container,false);
        attempts = youWin.findViewById(R.id.attempts);
        winnerWord = youWin.findViewById(R.id.winnerWord);
        homeWon = youWin.findViewById(R.id.homeWon);
        name = youWin.findViewById(R.id.name);


        homeWon.setOnClickListener(this);

        score = getArguments().getString("attempts");
        winnerWord.setText("Du har vundet. Ordet var: " + getArguments().getString("theCorrectWord"));
        attempts.setText("Antal forsøg: " + score);

        final MediaPlayer MP = MediaPlayer.create(getContext(), R.raw.dracula);

        MP.start();





        final KonfettiView konfettiView = youWin.findViewById(R.id.viewKonfetti);

        konfettiView.build()
                .addColors(Color.DKGRAY, Color.MAGENTA, Color.RED)
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

        sharedPref = getString(R.string.preferenceFile);
        sharedPreferences = getContext().getSharedPreferences(sharedPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        /*
        editor.putString(getString(R.string.spiller1),name.getText().toString());
        editor.putString(getString(R.string.score1),score);
        editor.commit();

        editor.putString(getString(R.string.spiller2),name.getText().toString());
        editor.putString(getString(R.string.score2),score);
        editor.commit();

        editor.putString(getString(R.string.spiller3),name.getText().toString());
        editor.putString(getString(R.string.score3),score);
        editor.commit();

         */

        if (Integer.parseInt(sharedPreferences.getString(getString(R.string.score1),"7")) > Integer.parseInt(score)){
            editor.putString(getString(R.string.spiller3),sharedPreferences.getString(getString(R.string.spiller2),null));
            editor.putString(getString(R.string.score3),sharedPreferences.getString(getString(R.string.score2),null));

            editor.putString(getString(R.string.spiller2),sharedPreferences.getString(getString(R.string.spiller1),null));
            editor.putString(getString(R.string.score2),sharedPreferences.getString(getString(R.string.score1),null));

            editor.putString(getString(R.string.spiller3),name.getText().toString());
            editor.putString(getString(R.string.score3),score);
            editor.commit();

        } else if (Integer.parseInt(sharedPreferences.getString(getString(R.string.score2),"7")) > Integer.parseInt(score)){
            editor.putString(getString(R.string.spiller3),sharedPreferences.getString(getString(R.string.spiller2),null));
            editor.commit();
            editor.putString(getString(R.string.score3),sharedPreferences.getString(getString(R.string.score2),null));
            editor.commit();

            editor.putString(getString(R.string.spiller2),name.getText().toString());
            editor.commit();
            editor.putString(getString(R.string.score2),score);
            editor.commit();


        } else if (Integer.parseInt(sharedPreferences.getString(getString(R.string.score3),"7")) > Integer.parseInt(score)){
            editor.putString(getString(R.string.spiller3),name.getText().toString());
            editor.commit();
            editor.putString(getString(R.string.score3),score);
            editor.commit();

        }





        getActivity().findViewById(R.id.spil).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.hjaelp).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.indstillinger).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.scoreboard).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.title1).setVisibility(View.VISIBLE);


    }

}
