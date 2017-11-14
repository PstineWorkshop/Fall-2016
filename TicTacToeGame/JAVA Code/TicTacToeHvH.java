package com.hfad.tictactoegame;

/**
 * Created by pstin on 10/5/2016.
 */
import java.util.Random;

public class TicTacToeHvH
{
    private char mBoard[];
    private final static int BOARD_SIZE = 9;

    public static final char PLAYER_ONE = 'X';
    public static final char PLAYER_TWO = '0';
    public static final char EMPTY_SPACE = ' ';

   // private Random mRand;


    public static int getBOARD_SIZE()
    {
        // Return the size of the board
        return BOARD_SIZE;
    }


    public TicTacToeHvH(){

        mBoard = new char[BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++)
            mBoard[i] = EMPTY_SPACE;

        //mRand = new Random();
    }

    // Clear the board of all X's and O's
    public void clearBoard()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            mBoard[i] = EMPTY_SPACE;
        }
    }

    // set the given player at the given location on the game board.
    // the location must be available, or the board will not be changed.
    public void setMove(char player, int location)
    {//start setMove method
        mBoard[location] = player;
    }//end setmove method


    // Check for a winner and return a status value indicating who has won.
    // Return 0 if no winner or tie yet, 1 if it's a tie, 2 if X won, or 3
    // if O won.
    public int checkForWinner()
    {
        // Check horizontal wins
        for (int i = 0; i <= 6; i += 3)
        {
            if (mBoard[i] == PLAYER_ONE &&
                    mBoard[i+1] == PLAYER_ONE &&
                    mBoard[i+2] == PLAYER_ONE)
                return 2;
            if (mBoard[i] == PLAYER_TWO &&
                    mBoard[i+1] == PLAYER_TWO &&
                    mBoard[i+2] == PLAYER_TWO)
                return 3;
        }

        // Check vertical wins
        for (int i = 0; i <= 2; i++)
        {
            if (mBoard[i] == PLAYER_ONE &&
                    mBoard[i+3] == PLAYER_ONE &&
                    mBoard[i+6] == PLAYER_ONE)
                return 2;
            if (mBoard[i] == PLAYER_TWO &&
                    mBoard[i+3] == PLAYER_TWO &&
                    mBoard[i+6] == PLAYER_TWO)
                return 3;
        }

        // Check for diagonal wins
        if ((mBoard[0] == PLAYER_ONE &&
                mBoard[4] == PLAYER_ONE &&
                mBoard[8] == PLAYER_ONE) ||
                mBoard[2] == PLAYER_ONE &&
                        mBoard[4] == PLAYER_ONE &&
                        mBoard[6] == PLAYER_ONE)
            return 2;
        if ((mBoard[0] == PLAYER_TWO &&
                mBoard[4] == PLAYER_TWO &&
                mBoard[8] == PLAYER_TWO) ||
                mBoard[2] == PLAYER_TWO &&
                        mBoard[4] == PLAYER_TWO &&
                        mBoard[6] == PLAYER_TWO)
            return 3;

        // Check for a tie
        for (int i = 0; i < getBOARD_SIZE(); i++)
        {
            // if we find a number, then no one has won yet
            if (mBoard[i] != PLAYER_ONE && mBoard[i] != PLAYER_TWO)
                return 0;
        }

        // If we make it through the previous loop, all places are taken, so it's a tie
        return 1;
    }
}
