package com.example.galgeleg_stephanie;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreBoardArray extends AppCompatActivity {

    private String sbName;
    private String sbTries;

    public ScoreBoardArray(String name, String tries){
        this.sbName = name;
        this.sbTries = tries;
    }

    public String getSbName(){
        return sbName;
    }

    public String getSbTries(){
        return sbTries;
    }


}
