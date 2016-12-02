package com.dezelin.common;

import android.support.annotation.NonNull;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dezelin on 28.11.16..
 */

public class Chessman {

    private final Symbol mSymbol;
    private final File mFile;
    private final Rank mRank;

    // Cache
    private static final Map<String, Chessman> mCache = new HashMap<>(64);

    public enum Symbol {
        BLACK_KING('k'),
        BLACK_QUEEN('q'),
        BLACK_ROOK('r'),
        BLACK_BISHOP('b'),
        BLACK_KNIGHT('n'),
        BLACK_PAWN('p'),
        WHITE_KING('K'),
        WHITE_QUEEN('Q'),
        WHITE_ROOK('R'),
        WHITE_BISHOP('B'),
        WHITE_KNIGHT('N'),
        WHITE_PAWN('P')
        ;

        private final char mSymbol;

        Symbol(char symbol) {
            mSymbol = symbol;
        }

        @NonNull
        @Override
        public String toString() { return String.valueOf(mSymbol); }

        public static Symbol fromOrdinal(int rank) {
            switch (rank) {
                case 0: return BLACK_KING;
                case 1: return BLACK_QUEEN;
                case 2: return BLACK_ROOK;
                case 3: return BLACK_BISHOP;
                case 4: return BLACK_KNIGHT;
                case 5: return BLACK_PAWN;
                case 6: return WHITE_KING;
                case 7: return WHITE_QUEEN;
                case 8: return WHITE_ROOK;
                case 9: return WHITE_BISHOP;
                case 10: return WHITE_KNIGHT;
                case 11: return WHITE_PAWN;
                default: {
                    throw new RuntimeException();
                }
            }
        }

        static public Symbol symbolFromChar(char c) {
            switch(c) {
                case 'p': return Chessman.Symbol.BLACK_PAWN;
                case 'n': return Chessman.Symbol.BLACK_KNIGHT;
                case 'b': return Chessman.Symbol.BLACK_BISHOP;
                case 'r': return Chessman.Symbol.BLACK_ROOK;
                case 'q': return Chessman.Symbol.BLACK_QUEEN;
                case 'k': return Chessman.Symbol.BLACK_KING;
                case 'P': return Chessman.Symbol.WHITE_PAWN;
                case 'N': return Chessman.Symbol.WHITE_KNIGHT;
                case 'B': return Chessman.Symbol.WHITE_BISHOP;
                case 'R': return Chessman.Symbol.WHITE_ROOK;
                case 'Q': return Chessman.Symbol.WHITE_QUEEN;
                case 'K': return Chessman.Symbol.WHITE_KING;
                default: {
                    throw new InvalidParameterException(String.valueOf(c));
                }
            }
        }

    }

    public enum Rank {
        R1, R2, R3, R4, R5, R6, R7, R8;

        @NonNull
        @Override
        public String toString() {
            switch(name()) {
                case "R1": return "1";
                case "R2": return "2";
                case "R3": return "3";
                case "R4": return "4";
                case "R5": return "5";
                case "R6": return "6";
                case "R7": return "7";
                case "R8": return "8";
                default: {
                    throw new RuntimeException();
                }
            }
        }

        public static Rank fromOrdinal(int rank) {
            switch (rank) {
                case 0: return R1;
                case 1: return R2;
                case 2: return R3;
                case 3: return R4;
                case 4: return R5;
                case 5: return R6;
                case 6: return R7;
                case 7: return R8;
                default: {
                    throw new RuntimeException();
                }
            }
        }
    }

    public enum File {
        A, B, C, D, E, F ,G, H;

        @NonNull
        @Override
        public String toString() {
            switch(name()) {
                case "A": return "a";
                case "B": return "b";
                case "C": return "c";
                case "D": return "d";
                case "E": return "e";
                case "F": return "f";
                case "G": return "g";
                case "H": return "h";
                default: {
                    throw new RuntimeException();
                }
            }
        }

        public static File fromOrdinal(int file) {
            switch (file) {
                case 0: return A;
                case 1: return B;
                case 2: return C;
                case 3: return D;
                case 4: return E;
                case 5: return F;
                case 6: return G;
                case 7: return H;
                default: {
                    throw new RuntimeException();
                }
            }
        }
    }

    private Chessman(Symbol symbol, File file, Rank rank) {
        mSymbol = symbol;
        mFile = file;
        mRank = rank;
    }

    public static Chessman getInstance(Symbol symbol, File file, Rank rank) {
        final String key = createKey(symbol, file, rank);
        Chessman chessman = mCache.get(key);
        if (chessman == null) {
            chessman = new Chessman(symbol, file, rank);
            mCache.put(key, chessman);
        }

        return chessman;
    }

    public Chessman promote(Symbol symbol, File file, Rank rank) {
        return getInstance(symbol, file, rank);
    }

    @NonNull
    @Override
    public String toString() {
        return createKey(mSymbol, mFile, mRank);
    }

    public File getFile() {
        return mFile;
    }

    public Rank getRank() {
        return mRank;
    }

    public Symbol getSymbol() {
        return mSymbol;
    }

    private static String createKey(Symbol symbol, File file, Rank rank) {
        return symbol.toString() + file.toString() + rank.toString();
    }
}
