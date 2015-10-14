package com.example.Android_Client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by s213391244 on 10/13/2015.
 */
public class Join_Game extends Activity {
    private Player player;
    TextView prompt;
    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_game);
        prompt = (TextView) findViewById(R.id.txtViewPrompt);
        editText = (EditText) findViewById(R.id.editTextName);
    }

    public void FindGame(View view) {
        String text = editText.getText().toString();
        if (editText.getText().length()<3) {
            prompt.setText("Enter your Name!!!");
        } else {
            Intent intent = new Intent(this, Game.class);
            player = new Player(text);
            intent.putExtra("player", player);
            startActivity(intent);
        }
    }
}