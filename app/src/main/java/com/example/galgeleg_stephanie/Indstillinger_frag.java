package com.example.galgeleg_stephanie;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

public class Indstillinger_frag extends Fragment implements View.OnClickListener {

    private View settinges;
    TextView indstillinger,brugOrd;
    Switch dr,regneark;
    String drSwitch,regnearkSwitch,sharedPreference;
    Button home;

   @Override
    public View onCreateView(LayoutInflater i,ViewGroup container, Bundle savedInstanceState) {
        settinges = i.inflate(R.layout.indstillinger,container,false);
        indstillinger = settinges.findViewById(R.id.indstillinger);
        brugOrd = settinges.findViewById(R.id.brugOrd);
        dr = settinges.findViewById(R.id.drSwitch);
        regneark = settinges.findViewById(R.id.regnearkSwitch);
        home = settinges.findViewById(R.id.homeIndstillinger);

        dr.setOnClickListener(this);
        regneark.setOnClickListener(this);
        home.setOnClickListener(this);

        sharedPreference = getString(R.string.preferenceFile);
        drSwitch = getString(R.string.drSwitch);
        regnearkSwitch = getString(R.string.regnearkSwitch);

       SharedPreferences sharedPref = getActivity().getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);

        if (sharedPref.getBoolean(drSwitch,false) == true){
            dr.setChecked(true);
        }

        if (sharedPref.getBoolean(regnearkSwitch,false) == true){
            regneark.setChecked(true);
        }

       return settinges;
    }



    @Override
    public void onClick(View v) {
       if (v == getActivity().findViewById(R.id.drSwitch)){
           if (dr.isChecked() == true) {
               SharedPreferences sharedPref = getActivity().getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedPref.edit();
               editor.putBoolean(drSwitch,true);
               editor.commit();

           }else if (dr.isChecked() == false) {
               SharedPreferences sharedPref = getActivity().getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedPref.edit();
               editor.putBoolean(drSwitch,false);
               editor.commit();
           }

       }else if (v == getActivity().findViewById(R.id.regnearkSwitch)) {
           if (regneark.isChecked() == true) {
               SharedPreferences sharedPref = getActivity().getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedPref.edit();
               editor.putBoolean(regnearkSwitch,true);
               editor.commit();

           }else if (regneark.isChecked() == false){
               SharedPreferences sharedPref = getActivity().getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedPref.edit();
               editor.putBoolean(regnearkSwitch,false);
               editor.commit();
           }
       }else if (v == getActivity().findViewById(R.id.homeIndstillinger)){
           SharedPreferences sharedPref = getActivity().getSharedPreferences(sharedPreference, Context.MODE_PRIVATE);

           if (sharedPref.getBoolean(getString(R.string.drSwitch),false) == true){
               GalgeLogicSingleton.getWordsOnline(1);
           }else if (sharedPref.getBoolean(getString(R.string.regnearkSwitch),false) == true){
               GalgeLogicSingleton.getWordsOnline(2);
           }else if (sharedPref.getBoolean(getString(R.string.drSwitch),false) == true && sharedPref.getBoolean(getString(R.string.regnearkSwitch),false) == true){
               GalgeLogicSingleton.getWordsOnline(3);
           }



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
