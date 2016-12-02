package com.dezelin.common;

/**
 * Created by dezelin on 28.11.16..
 */

public interface BoardPosition {

    public static final int CASTLING_WHITE_KING =   1 << 0;
    public static final int CASTLING_WHITE_QUEEN =  1 << 1;
    public static final int CASTLING_BLACK_KING =   1 << 2;
    public static final int CASTLING_BLACK_QUEEN =  1 << 3;

    public static final int ENPASSANT_SQUARE_A =    1 << 0;
    public static final int ENPASSANT_SQUARE_B =    1 << 1;
    public static final int ENPASSANT_SQUARE_C =    1 << 2;
    public static final int ENPASSANT_SQUARE_D =    1 << 3;
    public static final int ENPASSANT_SQUARE_E =    1 << 4;
    public static final int ENPASSANT_SQUARE_F =    1 << 5;
    public static final int ENPASSANT_SQUARE_G =    1 << 6;
    public static final int ENPASSANT_SQUARE_H =    1 << 7;
    public static final int ENPASSANT_SQUARE_3 =    1 << 8;
    public static final int ENPASSANT_SQUARE_6 =    1 << 9;

    public void put(Chessman chessman);
    public void remove(Chessman chessman);
    public Chessman get(int file, int rank);
    public Chessman[][] getBoard();
    public boolean getWhiteOnMove();
    public void setWhiteOnMove(boolean whiteOnMove);
    public int getCastlingSides();
    public void setCastlingSides(int sides);
    public int getEnPassantSquares();
    public void setEnPassantSquares(int squares);
    public int getHalfMovesCount();
    public void setHalfMovesCount(int halfMoves);
    public int getFullMovesCount();
    public void setFullMovesCount(int fullMoves);
    public boolean isValid();
}
