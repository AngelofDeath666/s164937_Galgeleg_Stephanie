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

        spilKnap = findViewById(R.id.spil);
        hjaelpKnap = findViewById(R.id.hjaelp);
        indstillingerKnap = findViewById(R.id.indstillinger);
        scoreboardKnap = findViewById(R.id.scoreboard);
        title = findViewById(R.id.title1);


        spilKnap.setOnClickListener(this);
        hjaelpKnap.setOnClickListener(this);
        indstillingerKnap.setOnClickListener(this);
        scoreboardKnap.setOnClickListener(this);








    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.spil)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            scoreboardKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Spil_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.hjaelp)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            scoreboardKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Spil_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.indstillinger)){
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
