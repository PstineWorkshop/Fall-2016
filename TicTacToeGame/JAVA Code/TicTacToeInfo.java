package com.hfad.tictactoegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class TicTacToeInfo extends AppCompatActivity {

   // private RatingBar ratingBar;
    //private TextView txtRatingValue;
    //private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_info);


    }
    public void onClickLearnToPlay(View view)
    {
       Intent i = new Intent(this, LearnToPlay.class);
       startActivity(i);
    }
    public void onClickHowAppWorks(View view)
    {
        Intent i = new Intent(this, HowAppWorks.class);
        startActivity(i);
    }
    public void onClickBackToMain(View v)
    {
       finish();
    }

}
