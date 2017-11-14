package com.hfad.tictactoegame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class HumanVComputer extends Activity {

    private TicTacToeHvC mGame;

    private Button mBoardButtons[];

    private TextView mInfoTextView;
    private TextView mHumanCount;
    private TextView mTieCount;
    private TextView mAndroidCount;

    private int mHumanCounter = 0;
    private int mTieCounter = 0;
    private int mAndroidCounter = 0;

    private boolean mHumanFirst = true;
    private boolean mGameOver = false;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {//start in create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_vcomputer);


        if (savedInstanceState != null) {
            mHumanCounter= savedInstanceState.getInt("mhuman");
            mTieCounter= savedInstanceState.getInt("mtiec");
            mAndroidCounter=savedInstanceState.getInt("mcomputer");
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
        mInfoTextView.setBackgroundResource(R.drawable.border_with_color);
        mHumanCount = (TextView) findViewById(R.id.humanCount);
        mTieCount = (TextView) findViewById(R.id.tiesCount);
        mAndroidCount = (TextView) findViewById(R.id.androidCount);

        mHumanCount.setText(Integer.toString(mHumanCounter));
        mTieCount.setText(Integer.toString(mTieCounter));
        mAndroidCount.setText(Integer.toString(mAndroidCounter));

        mGame = new TicTacToeHvC();

        startNewGame();

    }//end create
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("mhuman", mHumanCounter);
        savedInstanceState.putInt("mcomputer", mAndroidCounter);
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

        if (mHumanFirst)
        {
            mInfoTextView.setText(R.string.first_human);
            mHumanFirst = false;
        }
        else
        {
            mInfoTextView.setText(R.string.turn_computer);
            int move = mGame.getComputerMove();
            setMove(mGame.COMPUTER_PLAYER, move);
            mHumanFirst = true;
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
            {
                if (mBoardButtons[location].isEnabled())
                {
                    setMove(mGame.HUMAN_PLAYER, location);

                    int winner = mGame.WhoWon();

                    if (winner == 0)
                    {
                        mInfoTextView.setText(R.string.turn_computer);
                        int move = mGame.getComputerMove();
                        setMove(mGame.COMPUTER_PLAYER, move);
                        winner = mGame.WhoWon();
                    }

                    if (winner == 0)
                        mInfoTextView.setText(R.string.turn_human);
                    else if (winner == 1)
                    {
                        mInfoTextView.setText(R.string.result_tie);
                        mTieCounter++;
                        mInfoTextView.setBackgroundResource(R.drawable.mvht);
                        mTieCount.setText(Integer.toString(mTieCounter));
                        mGameOver = true;

                    }
                    else if (winner == 2)
                    {
                        mInfoTextView.setText(R.string.result_human_wins);
                        mHumanCounter++;
                        mInfoTextView.setBackgroundResource(R.drawable.thw);
                        mHumanCount.setText(Integer.toString(mHumanCounter));
                        mGameOver = true;
                    }
                    else
                    {
                        mInfoTextView.setText(R.string.result_android_wins);
                        mAndroidCounter++;
                        mInfoTextView.setBackgroundResource(R.drawable.ter);
                        mAndroidCount.setText(Integer.toString(mAndroidCounter));
                        mGameOver = true;
                    }
                }
            }
        }
    }

    public void setMove(char player, int location)
    {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
        if (player == mGame.HUMAN_PLAYER)
            mBoardButtons[location].setTextColor(Color.MAGENTA);
        else
            mBoardButtons[location].setTextColor(Color.YELLOW);
    }

    public void ExitOrNewGame(String s)
    {//start exit game
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


    }//end exit game
    public void onClickResetCounters(View v)
    {
        mHumanCounter=0;
        mAndroidCounter=0;
        mTieCounter=0;
    }

}