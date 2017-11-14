package com.hfad.tictactoegame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void StartHumanVsComputer(View view)
    {
        Intent i = new Intent(this, HumanVComputer.class);
        startActivity(i);
    }
    public  void StartHumanVsHuman(View view)
    {
        Intent i = new Intent(this, HumanVHuman.class);
        startActivity(i);
    }
    public void TicTacToeInfo (View view)
    {
        Intent i = new Intent(this, TicTacToeInfo.class);
        startActivity(i);
    }
    public void ExitApp(View view)

    {

        MainMenu.this.finish();
    }
   // public void gamestart()
   // {
       // startNewGame();
  //  }

}
