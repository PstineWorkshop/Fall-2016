package com.hfad.tictactoegame;

/**
 * Created by pstin on 10/5/2016.
 */

import java.util.Random;

public class TicTacToeHvC

{//start  TicTacToeHvC class
    private char mBoard[];
    private final static int BOARD_SIZE = 9;

    public static final char HUMAN_PLAYER = 'X';
    public static final char COMPUTER_PLAYER = '0';
    public static final char EMPTY_SPACE = ' ';

    private Random mRand;

    public static int getBOARD_SIZE()
    {//start method getBOARD_SIZE
        return BOARD_SIZE;
    }//end method getBOARD_SIZE

    public TicTacToeHvC()
    {//start method tic tac toe hvc

        mBoard = new char[BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++)
        {//start for loop
            mBoard[i] = EMPTY_SPACE;
        }//end for loop


        mRand = new Random();
    }//end method tic tac toe hvv

    public void clearBoard()
    {//start clearBoard
        for (int i = 0; i < BOARD_SIZE; i++)
        {//start for loop
            mBoard[i] = EMPTY_SPACE;
        }//end for loop
    }//end method clear board

    public void setMove(char player, int location)
    {//start setMove method
        mBoard[location] = player;
    }//end setmove method

    public int getComputerMove()
    {//start getComputerMove
        int move;

        for (int i = 0; i < getBOARD_SIZE(); i++)
        {//start for loop
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != COMPUTER_PLAYER)
            {//start if
                char curr = mBoard[i];
                mBoard[i] = COMPUTER_PLAYER;
                if (WhoWon() == 3)
                {//start if
                    setMove(COMPUTER_PLAYER, i);
                    return i;
                }//end if
                else
                {//start else statement
                    mBoard[i] = curr;
                }//end else statement

            }//end if
        }//end for loop

        for (int i = 0; i < getBOARD_SIZE(); i++)
        {//start for loop
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != COMPUTER_PLAYER)
            {//start if
                char curr = mBoard[i];
                mBoard[i] = HUMAN_PLAYER;
                if (WhoWon() == 2)
                {//start if
                    setMove(COMPUTER_PLAYER, i);
                    return i;
                }//end if
                else
                    mBoard[i] = curr;
            }//end if
        }//end for loop

        do
        {//start do loop
            move = mRand.nextInt(getBOARD_SIZE());
        } while (mBoard[move] == HUMAN_PLAYER || mBoard[move] == COMPUTER_PLAYER);//end do wjile loop

        setMove(COMPUTER_PLAYER, move);
        return move;
    }//end computer move method

    public int WhoWon()
    {//start of method who won
        int number=1;


        for (int i = 0; i <= 6; i += 3)
        {//start for loop
            if (mBoard[i] == HUMAN_PLAYER &&
                    mBoard[i+1] == HUMAN_PLAYER &&
                    mBoard[i+2] == HUMAN_PLAYER)
            {//start if
                return 2;
            }//end if

            if (mBoard[i] == COMPUTER_PLAYER &&
                    mBoard[i+1] == COMPUTER_PLAYER &&
                    mBoard[i+2] == COMPUTER_PLAYER)
            {//start if
                return 3;
            }//end if

        }//end for loop

        for (int i = 0; i <= 2; i++)
        {//start for loop
            if (mBoard[i] == HUMAN_PLAYER &&
                    mBoard[i+3] == HUMAN_PLAYER &&
                    mBoard[i+6] == HUMAN_PLAYER)
            {//start if
                return 2;
            }//end if

            if (mBoard[i] == COMPUTER_PLAYER &&
                    mBoard[i+3] == COMPUTER_PLAYER &&
                    mBoard[i+6] == COMPUTER_PLAYER)
            {//start if
                return 3;
            }//end if

        }//end for loop

        if ((mBoard[0] == HUMAN_PLAYER &&
                mBoard[4] == HUMAN_PLAYER &&
                mBoard[8] == HUMAN_PLAYER) ||
                mBoard[2] == HUMAN_PLAYER &&
                mBoard[4] == HUMAN_PLAYER &&
                mBoard[6] == HUMAN_PLAYER)
            {//start if
                return 2;
            }//end if

        if ((mBoard[0] == COMPUTER_PLAYER &&
                mBoard[4] == COMPUTER_PLAYER &&
                mBoard[8] == COMPUTER_PLAYER) ||
                mBoard[2] == COMPUTER_PLAYER &&
                mBoard[4] == COMPUTER_PLAYER &&
                mBoard[6] == COMPUTER_PLAYER)
        {//start if
            return 3;
        }//end if


        for (int i = 0; i < getBOARD_SIZE(); i++)
        {//start for loop
            if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != COMPUTER_PLAYER)
            {//start if
                return 0;
            }//end if

        }//end for loop

        return 1;

    }//end of who won method
}//end TicTacToeHvC class