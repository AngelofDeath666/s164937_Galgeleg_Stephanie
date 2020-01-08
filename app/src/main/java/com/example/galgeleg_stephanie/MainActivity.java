package com.example.galgeleg_stephanie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button spilKnap,hjaelpKnap,indstillingerKnap,scoreboardKnap;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalgeLogicSingleton.getGalgelogic();
        setContentView(R.layout.hovedmenu);

        spilKnap = findViewById(R.id.knap1);
        hjaelpKnap = findViewById(R.id.knap2);
        indstillingerKnap = findViewById(R.id.knap3);
        scoreboardKnap = findViewById(R.id.scoreboard);
        title = findViewById(R.id.title1);


        spilKnap.setOnClickListener(this);
        hjaelpKnap.setOnClickListener(this);
        indstillingerKnap.setOnClickListener(this);
        scoreboardKnap.setOnClickListener(this);








    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.knap1)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            scoreboardKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Spil_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.knap2)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            scoreboardKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Spil_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.knap3)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            scoreboardKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Indstillinger_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.scoreboard)) {
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            scoreboardKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new ScoreBoard_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }
    }
}
