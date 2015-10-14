package com.example.Android_Client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Zombie_Dice extends Activity {
    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void Play(View view){
        Intent intent = new Intent(this,Join_Game.class);
        startActivity(intent);
    }
}
