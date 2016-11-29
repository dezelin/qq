package com.dezelin.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dezelin on 28.11.16..
 */

public class FenBoardPosition implements BoardPosition, Iterable<Chessman> {
    private String mFen;

    public FenBoardPosition(String fen) {
        mFen = fen;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new FenBoardPosition(mFen);
    }

    @Override
    public void put(Chessman chessman) {

    }

    @Override
    public Chessman remove(Chessman.File file, Chessman.Rank rank) {
        return null;
    }

    @Override
    public Chessman get(Chessman.File file, Chessman.Rank rank) {
        return null;
    }

    @Override
    public Iterator<Chessman> iterator() {
        return new PositionIterator();
    }

    public String getFen() {
        return mFen;
    }

    private enum Token {
        INVALID, SKIP, PIECE, NEXTRANK
    }

    private class PositionIterator implements Iterator<Chessman> {

        private int mCurrent;
        private int mFile;
        private int mRank;
        private char mSymbol;

        public PositionIterator() {
        }

        private PositionIterator(int current, int file, int rank, char symbol) {
            mCurrent = current;
            mFile = file;
            mRank = rank;
            mSymbol = symbol;
        }

        @Override
        public boolean hasNext() {
            Token nextToken, prevToken = Token.INVALID;
            PositionIterator it = new PositionIterator(mCurrent, mFile, mRank, mSymbol);
            while((nextToken = it.nextToken()) != Token.INVALID) {
                if (nextToken == Token.PIECE) {
                    return true;
                }

                // Invalid token sequence
                if (prevToken == nextToken) {
                    break;
                }
            }

            return false;
        }

        @Override
        public Chessman next() {
            Token nextToken, prevToken = Token.INVALID;
            while((nextToken = nextToken()) != Token.INVALID) {
                if(nextToken == Token.PIECE) {
                    final Chessman.Symbol symbol = Chessman.Symbol.symbolFromChar(mSymbol);
                    final Chessman.File file = Chessman.File.fromOrdinal(mFile - 1);
                    final Chessman.Rank rank = Chessman.Rank.fromOrdinal(Chessman.Rank.R8.ordinal() - mRank);
                    return Chessman.getInstance(symbol, file, rank);
                }

                if (prevToken == nextToken) {
                    break;
                }
            }

            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Token nextToken() {
            if(mCurrent >= mFen.length()) {
                return Token.INVALID;
            }

            final char c = mFen.charAt(mCurrent);
            if(isPiece(c)) {
                if(mFile <= Chessman.File.H.ordinal()) {
                    mSymbol = c;
                    mFile += 1;
                    mCurrent += 1;
                    return Token.PIECE;
                }
            } else if (isSkipNumber(c)) {
                final int number = Character.getNumericValue(c);
                if(number <= Chessman.File.H.ordinal() - mFile + 1) {
                    mFile += number;
                    mCurrent += 1;
                    return Token.SKIP;
                }
            } else if (isRankSeparator(c)) {
                if((mFile == Chessman.File.H.ordinal() + 1)
                    && mRank <= Chessman.Rank.R8.ordinal() + 1)
                {
                    mRank += 1;
                    mFile = 0;
                    mCurrent += 1;
                    return Token.NEXTRANK;
                }
            }

            return Token.INVALID;
        }
    }

    private boolean isSkipNumber(char c) {
        return c >= '1' && c <= '8';
    }

    private boolean isPiece(char c) {
        switch(c) {
            case 'p': case 'n': case 'b': case 'r': case 'q': case 'k':
            case 'P': case 'N': case 'B': case 'R': case 'Q': case 'K':
                return true;
            default:
                return false;
        }
    }

    private boolean isRankSeparator(char c) {
        return c == '/';
    }

}
