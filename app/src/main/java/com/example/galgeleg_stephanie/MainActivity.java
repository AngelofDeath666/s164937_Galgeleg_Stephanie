package com.example.galgeleg_stephanie;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button spilKnap,hjaelpKnap,indstillingerKnap;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalgeLogicSingleton.getGalgelogic();
        setContentView(R.layout.hovedmenu);

        spilKnap = findViewById(R.id.knap1);
        hjaelpKnap = findViewById(R.id.knap2);
        indstillingerKnap = findViewById(R.id.knap3);
        title = findViewById(R.id.title1);
        final KonfettiView konfettiView = findViewById(R.id.viewKonfetti);

        spilKnap.setOnClickListener(this);
        hjaelpKnap.setOnClickListener(this);
        indstillingerKnap.setOnClickListener(this);
        konfettiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.CIRCLE, Shape.RECT)
                        .addSizes(new Size(12,5f))
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(300, 5000L);
            }
        });








    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.knap1)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Spil_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.knap2)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Spil_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }else if (v == findViewById(R.id.knap3)){
            spilKnap.setVisibility(View.INVISIBLE);
            hjaelpKnap.setVisibility(View.INVISIBLE);
            indstillingerKnap.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            Fragment fragment = new Indstillinger_frag();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment,fragment)
                    .commit();

        }
    }
}
