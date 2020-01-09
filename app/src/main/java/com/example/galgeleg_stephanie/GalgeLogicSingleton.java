package com.example.galgeleg_stephanie;

import android.os.AsyncTask;

import java.util.ArrayList;


public class GalgeLogicSingleton  {
    private static Galgelogik singleton;
    private static boolean gameRunning = false;
    public static Galgelogik getGalgelogic(){
        if (singleton == null) {
            singleton = new Galgelogik();


        }
        return singleton;

    }

    public static void nustil(){
        singleton.nulstil();
        gameRunning = false;

    }

    private static class getWords extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... strings) {
            ArrayList<String> tempOrd = new ArrayList<String>();
            switch (strings[0]){
                case "dr":
                    try{
                        singleton.hentOrdFraDr();
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    break;
                case "regneark":
                    try{
                        singleton.hentOrdFraRegneark(strings[1]);
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    break;
                case "begge":
                    try {
                        singleton.hentOrdFraRegneark(strings[1]);
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    tempOrd.addAll(singleton.muligeOrd);
                    try{
                        singleton.hentOrdFraDr();
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    singleton.muligeOrd.addAll(tempOrd);
                    break;
            }
            return null;
        }
    }

    public static void getWordsOnline(int rawr){
        getWords wordGetter = new getWords();
        if (rawr == 0){
            wordGetter.execute("dr");
        }else if (rawr == 1){
            wordGetter.execute("regneark","123");
        }else if (rawr == 2){
            wordGetter.execute("begge","123");
        }
    }
}
