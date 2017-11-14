package com.hfad.tictactoegame;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class HumanVHuman extends Activity {

    private TicTacToeHvH mGame;

    private Button mBoardButtons[];

    public Button newGame;

    private TextView mInfoTextView;
   private TextView mPlayerOneCount;
   private TextView mTieCount;
   private TextView mPlayerTwoCount;
    private TextView mPlayerOneText;
    private TextView mPlayerTwoText;

    private int mPlayerOneCounter = 0;
    private int mTieCounter = 0;
    private int mPlayerTwoCounter = 0;

    private boolean mPlayerOneFirst = true;
    private boolean mGameOver = false;

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {//start oin create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_vhuman);


        if (savedInstanceState != null) {
            mPlayerOneCounter= savedInstanceState.getInt("mplayerc");
            mTieCounter= savedInstanceState.getInt("mtiec");
            mPlayerTwoCounter=savedInstanceState.getInt("mplayer2");
            }




        mBoardButtons = new Button[mGame.getBOARD_SIZE()];
        mBoardButtons[0] = (Button) findViewById(R.id.one);
        mBoardButtons[1] = (Button) findViewById(R.id.two);
        mBoardButtons[2] = (Button) findViewById(R.id.three);
        mBoardButtons[3] = (Button) findViewById(R.id.four);
        mBoardButtons[4] = (Button) findViewById(R.id.five);
        mBoardButtons[5] = (Button) findViewById(R.id.six);
        mBoardButtons[6] = (Button) findViewById(R.id.seven);
        mBoardButtons[7] = (Button) findViewById(R.id.eight);
        mBoardButtons[8] = (Button) findViewById(R.id.nine);





        mInfoTextView = (TextView) findViewById(R.id.information);
       mPlayerOneCount =(TextView) findViewById(R.id.player_one_count);
        mPlayerOneCount = (TextView) findViewById(R.id.player_one_count);
       mTieCount = (TextView) findViewById(R.id.tiesCount);
       mPlayerTwoCount = (TextView) findViewById(R.id.player_two_count);



        mInfoTextView.setBackgroundResource(R.drawable.border_with_color);
       mPlayerOneCount.setText(Integer.toString(mPlayerOneCounter));
        mTieCount.setText(Integer.toString(mTieCounter));
        mPlayerTwoCount.setText(Integer.toString(mPlayerTwoCounter));

        mGame = new TicTacToeHvH();

        startNewGame();


    }//end on create
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("mplayerc", mPlayerOneCounter);
        savedInstanceState.putInt("mplayer2", mPlayerTwoCounter);
        savedInstanceState.putInt("mtiec", mTieCounter);
    }

    public void onclickChooseAnOption(View v)
    {
        Spinner options = (Spinner)findViewById(R.id.options);

        String chose =String.valueOf(options.getSelectedItem());

        ExitOrNewGame(chose);
    }

    public void startNewGame()
    {
        mGame.clearBoard();

        for (int i = 0; i < mBoardButtons.length; i++)
        {
            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
        }

        if (mPlayerOneFirst)
        {
            mInfoTextView.setText(R.string.turn_player_one);
            mPlayerOneFirst = false;
        }
        else
        {
            mInfoTextView.setText(R.string.turn_player_two);
            //int move = mGame.getComputerMove();
            //setMove(mGame.PLAYER_TWO, move);
            mPlayerOneFirst = true;
        }
    }

    public class ButtonClickListener implements View.OnClickListener
    {
        int location;

        public ButtonClickListener(int location)
        {
            this.location = location;
        }

        public void onClick(View view)
        {
            if (!mGameOver)
            {//start if for end hame
                if (mBoardButtons[location].isEnabled())
                {//start if for if the button is enabled
                    if(mPlayerOneFirst)
                    {
                        setMove(mGame.PLAYER_ONE, location);
                    }

                    else
                    {
                        setMove(mGame.PLAYER_TWO, location);
                    }

                    int winner = mGame.checkForWinner();

                    if (winner == 0)
                    {
                        if(mPlayerOneFirst)
                        {
                            mInfoTextView.setText(R.string.turn_player_two);
                            mPlayerOneFirst =false;
                            //int move = mGame.getComputerMove();
                            //setMove(mGame.PLAYER_TWO, move);
                            //winner = mGame.checkForWinner();
                        }
                        else
                        {
                            mInfoTextView.setText(R.string.turn_player_one);
                            mPlayerOneFirst =true;
                        }

                    }


                    else if (winner == 1)
                    {
                        mInfoTextView.setText(R.string.result_tie);
                        mTieCounter++;

                       mTieCount.setText(Integer.toString(mTieCounter));
                        mGameOver = true;
                    }
                    else if (winner == 2)
                    {
                        mInfoTextView.setText(R.string.result_player_one_wins);
                        mPlayerOneCounter++;

                       mPlayerOneCount.setText(Integer.toString(mPlayerOneCounter));
                        mGameOver = true;
                    }
                    else
                    {
                        mInfoTextView.setText(R.string.result_player_two_wins);
                        mPlayerTwoCounter++;

                      mPlayerTwoCount.setText(Integer.toString(mPlayerTwoCounter));
                        mGameOver = true;
                    }
                }//end if if button is enabled
            }//end for game not false
        }


    }


    public void setMove(char player, int location)
    {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
        if (player == mGame.PLAYER_ONE)
        {
            mBoardButtons[location].setTextColor(Color.MAGENTA);
        }
        else
        {
            mBoardButtons[location].setTextColor(Color.YELLOW);
        }

    }
    public void ExitOrNewGame(String s)
    {//start exit or new game
        if(s.equals("Start New Game"))
        {//starts the new game conditon
            if (Build.VERSION.SDK_INT >= 11) {
                recreate();
            } else
            {
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);

                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }//end the new game conditon
        else
        {
            finish();
        }


    }//end exit or start new game
    public void onClickResetCounters(View v)
    {
        mPlayerOneCounter=0;
        mPlayerTwoCounter=0;
        mTieCounter=0;
    }


}
