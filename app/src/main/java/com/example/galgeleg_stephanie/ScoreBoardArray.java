package com.example.galgeleg_stephanie;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreBoardArray extends AppCompatActivity {

    private String sbName;
    private String sbTries;

    public ScoreBoardArray(String name, String tries){
        sbName = name;
        sbTries = tries;
    }

    public String getSbName(){
        return sbName;
    }

    public String getSbTries(){
        return sbTries;
    }


}
