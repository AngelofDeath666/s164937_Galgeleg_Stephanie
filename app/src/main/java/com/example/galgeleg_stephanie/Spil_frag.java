package com.example.galgeleg_stephanie;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Spil_frag extends Fragment implements View.OnClickListener {

    private View zeGame;
    private int antalForkerte;
    Galgelogik  logik = GalgeLogicSingleton.getGalgelogic();
    TextView info;
    ImageView billede;
    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,x,y,z,ae,oe,aa;

    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container, Bundle savedInstanceState) {
        zeGame = ii.inflate(R.layout.spil,container,false);

        info = zeGame.findViewById(R.id.info);
        billede = zeGame.findViewById(R.id.galge);


        a = zeGame.findViewById(R.id.a);
        b = zeGame.findViewById(R.id.b);
        c = zeGame.findViewById(R.id.c);
        d = zeGame.findViewById(R.id.d);
        e = zeGame.findViewById(R.id.e);
        f = zeGame.findViewById(R.id.f);
        g = zeGame.findViewById(R.id.g);
        h = zeGame.findViewById(R.id.h);
        i = zeGame.findViewById(R.id.i);
        j = zeGame.findViewById(R.id.j);
        k = zeGame.findViewById(R.id.k);
        l = zeGame.findViewById(R.id.l);
        m = zeGame.findViewById(R.id.m);
        n = zeGame.findViewById(R.id.n);
        o = zeGame.findViewById(R.id.o);
        p = zeGame.findViewById(R.id.p);
        q = zeGame.findViewById(R.id.q);
        r = zeGame.findViewById(R.id.r);
        s = zeGame.findViewById(R.id.s);
        t = zeGame.findViewById(R.id.t);
        u = zeGame.findViewById(R.id.u);
        v = zeGame.findViewById(R.id.v);
        x = zeGame.findViewById(R.id.x);
        y = zeGame.findViewById(R.id.y);
        z = zeGame.findViewById(R.id.z);
        ae = zeGame.findViewById(R.id.ae);
        oe = zeGame.findViewById(R.id.oe);
        aa = zeGame.findViewById(R.id.aa);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        x.setOnClickListener(this);
        v.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
        ae.setOnClickListener(this);
        oe.setOnClickListener(this);
        aa.setOnClickListener(this);

        SharedPreferences sharedPref = getActivity().getSharedPreferences(getString(R.string.preferenceFile), Context.MODE_PRIVATE);

        if (sharedPref.getBoolean(getString(R.string.drSwitch),false) == true){
            GalgeLogicSingleton.getWordsOnline(1);
        }else if (sharedPref.getBoolean(getString(R.string.regnearkSwitch),false) == true){
            GalgeLogicSingleton.getWordsOnline(2);
        }else if (sharedPref.getBoolean(getString(R.string.drSwitch),false) == true && sharedPref.getBoolean(getString(R.string.regnearkSwitch),false) == true){
            GalgeLogicSingleton.getWordsOnline(3);
        }


        opdaterSkærm();
        return zeGame;
    }

    @Override
    public void onClick(View v) {
        Button gættetBokstav = (Button)v;
        v.setVisibility(View.INVISIBLE);
        logik.gætBogstav(gættetBokstav.getText().toString());
        opdaterSkærm();

        if (logik.erSidsteBogstavKorrekt() == false) {
            if (antalForkerte == 1) {
                billede.setImageResource(R.drawable.forkert1);
            } else if (antalForkerte == 2) {
                billede.setImageResource(R.drawable.forkert2);
            } else if (antalForkerte == 3) {
                billede.setImageResource(R.drawable.forkert3);
            } else if (antalForkerte == 4) {
                billede.setImageResource(R.drawable.forkert4);
            } else if (antalForkerte == 5) {
                billede.setImageResource(R.drawable.forkert5);
            }


            antalForkerte++;
        }

    }

    private void opdaterSkærm() {
        info.setText("Gæt ordet: " + logik.getSynligtOrd());
        info.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


        if (logik.erSpilletVundet()) {
            Fragment fragment = new Win_frag();
            Bundle winData = new Bundle();
            winData.putString("theCorrectWord",logik.getOrdet());
            winData.putString("attempts",antalForkerte+"");
            fragment.setArguments(winData);

            getFragmentManager().beginTransaction()
                    .replace(R.id.Fragment,fragment)
                    .addToBackStack(null)
                    .commit();


        }
        if (logik.erSpilletTabt()) {
            Fragment fragment = new Lose_frag();
            Bundle loseData = new Bundle();
            loseData.putString("theCorrectWord",logik.getOrdet());
            fragment.setArguments(loseData);

            getFragmentManager().beginTransaction()
                    .replace(R.id.Fragment,fragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
