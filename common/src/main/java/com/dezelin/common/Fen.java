package com.dezelin.common;

import android.util.Log;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.dezelin.parsers.FenBaseListener;
import com.dezelin.parsers.FenLexer;
import com.dezelin.parsers.FenParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by dezelin on 28.11.16..
 */

public class Fen implements BoardPosition, Iterable<Chessman> {

    private Chessman[][] mPieces = new Chessman[8][8];
    private boolean mWhiteOnMove;
    private int mCastlingSides;
    private int mEnPassantSquare;
    private int mHalfMoves;
    private int mFullMoves;

    private boolean mValid = false;

    public Fen(String fen) {
        parse(fen);
    }

    private void parse(String fen) {
        FenLexer lexer = new FenLexer((new ANTLRInputStream(fen)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FenParser parser = new FenParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());

        try {
            FenParser.FenContext tree = parser.fen();
            FenExtractor extractor = new FenExtractor(parser);
            ParseTreeWalker.DEFAULT.walk(extractor, tree);
            mValid = true;
        } catch (ParseCancellationException ex) {
        }
    }

    private class FenExtractor extends FenBaseListener {

        private FenParser mParser;
        private int mFile;
        private int mRank;

        public FenExtractor(FenParser parser) {
            mParser = parser;
            mFile = 0;
            mRank = 7;
        }

        @Override
        public void enterBlackPiece(FenParser.BlackPieceContext ctx) {
            super.enterBlackPiece(ctx);

            // If there are too many pieces in a rank exception will be thrown on rank exit.
            if(mFile <= 7) {
                final String payload = ctx.getPayload().getText();
                mPieces[mFile][mRank] = Chessman.getInstance(Chessman.Symbol.symbolFromChar(payload.charAt(0)),
                        Chessman.File.fromOrdinal(mFile), Chessman.Rank.fromOrdinal(mRank));
            }

            mFile = mFile + 1;
        }

        @Override
        public void enterCastlingAbility(FenParser.CastlingAbilityContext ctx) {
            super.enterCastlingAbility(ctx);

            final String payload = ctx.getPayload().getText();
            for (int i = 0; i < payload.length(); ++i) {
                final char c = payload.charAt(i);
                switch (c) {
                    case 'K': {
                        mCastlingSides = mCastlingSides | BoardPosition.CASTLING_WHITE_KING;
                        break;
                    }
                    case 'Q': {
                        mCastlingSides = mCastlingSides | BoardPosition.CASTLING_WHITE_QUEEN;
                        break;
                    }
                    case 'k': {
                        mCastlingSides = mCastlingSides | BoardPosition.CASTLING_BLACK_KING;
                        break;

                    }
                    case 'q': {
                        mCastlingSides = mCastlingSides | BoardPosition.CASTLING_BLACK_QUEEN;
                        break;
                    }
                    default: {
                        throw new ParseCancellationException("Invalid castling side");
                    }
                }
            }
        }

        @Override
        public void enterFileLetter(FenParser.FileLetterContext ctx) {
            super.enterFileLetter(ctx);

            final String payload = ctx.getPayload().getText();
            final int fileOrdinal = Character.getNumericValue(payload.charAt(0)) - Character.getNumericValue('a');
            final Chessman.File file = Chessman.File.fromOrdinal(fileOrdinal);
            mEnPassantSquare |= 1 << file.ordinal();
        }

        @Override
        public void enterEpRank(FenParser.EpRankContext ctx) {
            super.enterEpRank(ctx);

            final String payload = ctx.getPayload().getText();
            final int rankOrdinal = Character.getNumericValue(payload.charAt(0)) - Character.getNumericValue('1');
            final Chessman.Rank rank = Chessman.Rank.fromOrdinal(rankOrdinal);
            final int rankFlag = (rank == Chessman.Rank.R3) ? BoardPosition.ENPASSANT_SQUARE_3 : BoardPosition.ENPASSANT_SQUARE_6;
            mEnPassantSquare |= rankFlag;
        }

        @Override
        public void enterHalfMoveClock(FenParser.HalfMoveClockContext ctx) {
            super.enterHalfMoveClock(ctx);

            final String payload = ctx.getPayload().getText();
            mHalfMoves = Integer.valueOf(payload);
        }

        @Override
        public void enterFullMoveCounter(FenParser.FullMoveCounterContext ctx) {
            super.enterFullMoveCounter(ctx);

            final String payload = ctx.getPayload().getText();
            mFullMoves = Integer.valueOf(payload);
        }

        @Override
        public void enterSideToMove(FenParser.SideToMoveContext ctx) {
            super.enterSideToMove(ctx);

            final String payload = ctx.getPayload().getText();
            mWhiteOnMove = (payload.charAt(0) == 'w');
        }

        @Override
        public void enterSkipNumber(FenParser.SkipNumberContext ctx) {
            super.enterSkipNumber(ctx);

            final String payload = ctx.getPayload().getText();
            mFile += Character.getNumericValue(payload.charAt(0));
        }

        @Override
        public void enterSkipAll(FenParser.SkipAllContext ctx) {
            super.enterSkipAll(ctx);

            final String payload = ctx.getPayload().getText();
            mFile += Character.getNumericValue(payload.charAt(0));
        }

        @Override
        public void enterWhitePiece(FenParser.WhitePieceContext ctx) {
            super.enterWhitePiece(ctx);

            // If there are too many pieces in a rank exception will be thrown on rank exit.
            if(mFile <= 7) {
                final String payload = ctx.getPayload().getText();
                mPieces[mFile][mRank] = Chessman.getInstance(Chessman.Symbol.symbolFromChar(payload.charAt(0)),
                        Chessman.File.fromOrdinal(mFile), Chessman.Rank.fromOrdinal(mRank));
            }

            mFile += 1;
        }

        @Override
        public void exitFen(FenParser.FenContext ctx) {
            super.exitFen(ctx);
        }

        @Override
        public void exitRank(FenParser.RankContext ctx) {
            super.exitRank(ctx);
            mRank -= 1;

            if (mFile > 8) {
                throw new ParseCancellationException("Too many pieces in a rank");
            }

            mFile = 0;
        }
    }

    private Fen(Chessman[][] pieces) {
        assert pieces.length == 8;
        assert pieces[0].length == 8;
        mPieces = Arrays.copyOf(pieces, pieces.length * pieces[0].length);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Fen(mPieces);
    }

    @Override
    public void put(Chessman chessman) {
        mPieces[chessman.getFile().ordinal()][chessman.getRank().ordinal()] = chessman;
    }

    @Override
    public void remove(Chessman chessman) {
        mPieces[chessman.getFile().ordinal()][chessman.getRank().ordinal()] = null;
    }

    @Override
    public Chessman get(int file, int rank) {
        return mPieces[file][rank];
    }

    @Override
    public Chessman[][] getBoard() {
        return mPieces;
    }

    @Override
    public boolean getWhiteOnMove() {
        return mWhiteOnMove;
    }

    @Override
    public void setWhiteOnMove(boolean whiteOnMove) {
        mWhiteOnMove = whiteOnMove;
    }

    @Override
    public int getCastlingSides() {
        return mCastlingSides;
    }

    @Override
    public void setCastlingSides(int sides) {
        mCastlingSides = sides;
    }

    @Override
    public int getEnPassantSquares() {
        return mEnPassantSquare;
    }

    @Override
    public void setEnPassantSquares(int squares) {
        mEnPassantSquare = squares;
    }

    @Override
    public int getHalfMovesCount() {
        return mHalfMoves;
    }

    @Override
    public void setHalfMovesCount(int halfMoves) {
        mHalfMoves = halfMoves;
    }

    @Override
    public int getFullMovesCount() {
        return mFullMoves;
    }

    @Override
    public void setFullMovesCount(int fullMoves) {
        mFullMoves = fullMoves;
    }

    @Override
    public boolean isValid() {
        return mValid;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Serialize pieces

        int skipCount = 0;
        int current = 63;
        while(current >= 0) {
            final int file = 8 - (current % 8) - 1;
            final int rank = current / 8;

            if(mPieces[file][rank] == null) {
                skipCount++;
            } else {
                builder.append((skipCount > 0) ? String.valueOf(skipCount) : "");
                builder.append(mPieces[file][rank].getSymbol().toString());
                skipCount = 0;
            }

            if(file == 7) {
                builder.append((skipCount > 0) ? String.valueOf(skipCount) : "");
                builder.append(rank > 0 ? "/" : "");
                skipCount = 0;
            }

            current--;
        }

        builder.append(' ');

        // Serialize side to move
        builder.append(mWhiteOnMove ? 'w' : 'b');

        builder.append(' ');

        // Serialize castling sides
        int index = 0;
        final char[] castling = { 'K', 'Q', 'k', 'q' };
        for(int i = BoardPosition.CASTLING_WHITE_KING; i <= BoardPosition.CASTLING_BLACK_QUEEN; i <<= 1) {
            if((mCastlingSides & i) != 0) {
                builder.append(castling[index]);
            }

            index++;
        }

        builder.append(' ');

        // Serialize en passant squares
        if(mEnPassantSquare == 0) {
            builder.append('-');
        } else {
            final char[] squares = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', '3', '6' };

            index = 0;
            for (int i = BoardPosition.ENPASSANT_SQUARE_A; i <= BoardPosition.ENPASSANT_SQUARE_6; i <<= 1) {
                if ((mEnPassantSquare & i) != 0) {
                    builder.append(squares[index]);
                }

                index++;
            }
        }

        builder.append(' ');

        // Serialize half moves clock
        builder.append(String.valueOf(mHalfMoves));

        builder.append(' ');

        // Serialize full moves counter
        builder.append(String.valueOf(mFullMoves));

        return builder.toString();
    }

    @Override
    public Iterator<Chessman> iterator() {
        return new FenPiecesIterator();
    }

    private class FenPiecesIterator implements Iterator<Chessman> {

        private int mCurrent;

        public FenPiecesIterator() {
            mCurrent = 64;
        }

        @Override
        public boolean hasNext() {
            return isValid() && (nextPiece() != -1);
        }

        @Override
        public Chessman next() {
            if(!isValid()) {
                throw new NoSuchElementException();
            }

            final int current = nextPiece();
            if (current == -1) {
                throw new NoSuchElementException();
            }

            mCurrent = current;
            return mPieces[8 - (current % 8) - 1][current / 8];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private int nextPiece() {
            int current = mCurrent - 1;
            while (current >= 0) {
                if (mPieces[8 - (current % 8) - 1][current / 8] != null) {
                    break;
                }

                current--;
            }

            return (current >= 0) ? current : -1;
        }
    }
}
