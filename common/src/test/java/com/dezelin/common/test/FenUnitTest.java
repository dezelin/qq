package com.dezelin.common.test;

import com.dezelin.common.Chessman;
import com.dezelin.common.Fen;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by dezelin on 28.11.16..
 */

public class FenUnitTest {

    private static final String PIECES = "rnbqkbnrpRNBQKBNRP";

    private static final String FEN0 = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String FEN1 = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1";
    private static final String FEN2 = "rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2";
    private static final String FEN3 = "rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2";

    private static final String INVALID_FEN0 = "";
    private static final String INVALID_FEN1 = "a";
    private static final String INVALID_FEN2 = "rnbqkbaa/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN3 = "rnbqkbnr/pppapppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN4 = "rnbqkbnr/pppppppp/8/8/8/8/PPAPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN5 = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/AABQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN6 = "0nbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN7 = "r0bqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN8 = "rn2qkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN9 = "rnbqkbnr1/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN10 = "9rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN11 = "8rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN12 = "/rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN13 = "r/nbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN14 = "rnbqkbnr//pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN15 = "rnbqkbnr/p/ppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN16 = "rnbqkbnr/pppppppp//8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final String INVALID_FEN17 = "rnbqkbnr/pppppppp/2/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    @Rule
    public final ExpectedException exception = ExpectedException.none();


     @Test
    public void board_Constructor() {
         Fen p = new Fen(FEN0);
         assertEquals(FEN0, p.toString());
         assertTrue(p.isValid());
    }

    @Test
    public void iterator_hasNext_valid_fen() {
        Fen p = new Fen(FEN0);
        assertTrue(p.isValid());

        Iterator<Chessman> it = p.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void iterator_next_valid_fen0() {
        List<Chessman> list = new ArrayList<>();
        Fen p = new Fen(FEN0);
        Iterator it = p.iterator();

        while(it.hasNext()) {
            Chessman cm = (Chessman) it.next();
            list.add(cm);
        }

        assertEquals(list.size(), 32);

        assertEquals(list.get(0).getFile(), Chessman.File.A);
        assertEquals(list.get(0).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(0).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(1).getFile(), Chessman.File.B);
        assertEquals(list.get(1).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(1).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(2).getFile(), Chessman.File.C);
        assertEquals(list.get(2).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(2).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(3).getFile(), Chessman.File.D);
        assertEquals(list.get(3).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(3).getSymbol(), Chessman.Symbol.BLACK_QUEEN);

        assertEquals(list.get(4).getFile(), Chessman.File.E);
        assertEquals(list.get(4).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(4).getSymbol(), Chessman.Symbol.BLACK_KING);

        assertEquals(list.get(5).getFile(), Chessman.File.F);
        assertEquals(list.get(5).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(5).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(6).getFile(), Chessman.File.G);
        assertEquals(list.get(6).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(6).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(7).getFile(), Chessman.File.H);
        assertEquals(list.get(7).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(7).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(8).getFile(), Chessman.File.A);
        assertEquals(list.get(8).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(8).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(9).getFile(), Chessman.File.B);
        assertEquals(list.get(9).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(9).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(10).getFile(), Chessman.File.C);
        assertEquals(list.get(10).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(10).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(11).getFile(), Chessman.File.D);
        assertEquals(list.get(11).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(11).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(12).getFile(), Chessman.File.E);
        assertEquals(list.get(12).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(12).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(13).getFile(), Chessman.File.F);
        assertEquals(list.get(13).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(13).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(14).getFile(), Chessman.File.G);
        assertEquals(list.get(14).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(14).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(15).getFile(), Chessman.File.H);
        assertEquals(list.get(15).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(15).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(16).getFile(), Chessman.File.A);
        assertEquals(list.get(16).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(16).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(17).getFile(), Chessman.File.B);
        assertEquals(list.get(17).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(17).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(18).getFile(), Chessman.File.C);
        assertEquals(list.get(18).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(18).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(19).getFile(), Chessman.File.D);
        assertEquals(list.get(19).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(19).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(20).getFile(), Chessman.File.E);
        assertEquals(list.get(20).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(20).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(21).getFile(), Chessman.File.F);
        assertEquals(list.get(21).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(21).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(22).getFile(), Chessman.File.G);
        assertEquals(list.get(22).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(22).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(23).getFile(), Chessman.File.H);
        assertEquals(list.get(23).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(23).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(24).getFile(), Chessman.File.A);
        assertEquals(list.get(24).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(24).getSymbol(), Chessman.Symbol.WHITE_ROOK);

        assertEquals(list.get(25).getFile(), Chessman.File.B);
        assertEquals(list.get(25).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(25).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(26).getFile(), Chessman.File.C);
        assertEquals(list.get(26).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(26).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(27).getFile(), Chessman.File.D);
        assertEquals(list.get(27).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(27).getSymbol(), Chessman.Symbol.WHITE_QUEEN);

        assertEquals(list.get(28).getFile(), Chessman.File.E);
        assertEquals(list.get(28).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(28).getSymbol(), Chessman.Symbol.WHITE_KING);

        assertEquals(list.get(29).getFile(), Chessman.File.F);
        assertEquals(list.get(29).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(29).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(30).getFile(), Chessman.File.G);
        assertEquals(list.get(30).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(30).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(31).getFile(), Chessman.File.H);
        assertEquals(list.get(31).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(31).getSymbol(), Chessman.Symbol.WHITE_ROOK);
    }

    @Test
    public void iterator_next_valid_fen1() {
        List<Chessman> list = new ArrayList<>();
        Fen p = new Fen(FEN1);
        Iterator it = p.iterator();

        while(it.hasNext()) {
            Chessman cm = (Chessman) it.next();
            list.add(cm);
        }

        assertEquals(list.size(), 32);

        assertEquals(list.get(0).getFile(), Chessman.File.A);
        assertEquals(list.get(0).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(0).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(1).getFile(), Chessman.File.B);
        assertEquals(list.get(1).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(1).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(2).getFile(), Chessman.File.C);
        assertEquals(list.get(2).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(2).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(3).getFile(), Chessman.File.D);
        assertEquals(list.get(3).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(3).getSymbol(), Chessman.Symbol.BLACK_QUEEN);

        assertEquals(list.get(4).getFile(), Chessman.File.E);
        assertEquals(list.get(4).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(4).getSymbol(), Chessman.Symbol.BLACK_KING);

        assertEquals(list.get(5).getFile(), Chessman.File.F);
        assertEquals(list.get(5).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(5).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(6).getFile(), Chessman.File.G);
        assertEquals(list.get(6).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(6).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(7).getFile(), Chessman.File.H);
        assertEquals(list.get(7).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(7).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(8).getFile(), Chessman.File.A);
        assertEquals(list.get(8).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(8).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(9).getFile(), Chessman.File.B);
        assertEquals(list.get(9).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(9).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(10).getFile(), Chessman.File.C);
        assertEquals(list.get(10).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(10).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(11).getFile(), Chessman.File.D);
        assertEquals(list.get(11).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(11).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(12).getFile(), Chessman.File.E);
        assertEquals(list.get(12).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(12).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(13).getFile(), Chessman.File.F);
        assertEquals(list.get(13).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(13).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(14).getFile(), Chessman.File.G);
        assertEquals(list.get(14).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(14).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(15).getFile(), Chessman.File.H);
        assertEquals(list.get(15).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(15).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        // 1. e4...
        assertEquals(list.get(16).getFile(), Chessman.File.E);
        assertEquals(list.get(16).getRank(), Chessman.Rank.R4);
        assertEquals(list.get(16).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(17).getFile(), Chessman.File.A);
        assertEquals(list.get(17).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(17).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(18).getFile(), Chessman.File.B);
        assertEquals(list.get(18).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(18).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(19).getFile(), Chessman.File.C);
        assertEquals(list.get(19).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(19).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(20).getFile(), Chessman.File.D);
        assertEquals(list.get(20).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(20).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(21).getFile(), Chessman.File.F);
        assertEquals(list.get(21).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(21).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(22).getFile(), Chessman.File.G);
        assertEquals(list.get(22).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(22).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(23).getFile(), Chessman.File.H);
        assertEquals(list.get(23).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(23).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(24).getFile(), Chessman.File.A);
        assertEquals(list.get(24).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(24).getSymbol(), Chessman.Symbol.WHITE_ROOK);

        assertEquals(list.get(25).getFile(), Chessman.File.B);
        assertEquals(list.get(25).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(25).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(26).getFile(), Chessman.File.C);
        assertEquals(list.get(26).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(26).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(27).getFile(), Chessman.File.D);
        assertEquals(list.get(27).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(27).getSymbol(), Chessman.Symbol.WHITE_QUEEN);

        assertEquals(list.get(28).getFile(), Chessman.File.E);
        assertEquals(list.get(28).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(28).getSymbol(), Chessman.Symbol.WHITE_KING);

        assertEquals(list.get(29).getFile(), Chessman.File.F);
        assertEquals(list.get(29).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(29).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(30).getFile(), Chessman.File.G);
        assertEquals(list.get(30).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(30).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(31).getFile(), Chessman.File.H);
        assertEquals(list.get(31).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(31).getSymbol(), Chessman.Symbol.WHITE_ROOK);
    }

    @Test
    public void iterator_next_valid_fen2() {
        List<Chessman> list = new ArrayList<>();
        Fen p = new Fen(FEN2);
        Iterator it = p.iterator();

        while(it.hasNext()) {
            Chessman cm = (Chessman) it.next();
            list.add(cm);
        }

        assertEquals(list.size(), 32);

        assertEquals(list.get(0).getFile(), Chessman.File.A);
        assertEquals(list.get(0).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(0).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(1).getFile(), Chessman.File.B);
        assertEquals(list.get(1).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(1).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(2).getFile(), Chessman.File.C);
        assertEquals(list.get(2).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(2).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(3).getFile(), Chessman.File.D);
        assertEquals(list.get(3).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(3).getSymbol(), Chessman.Symbol.BLACK_QUEEN);

        assertEquals(list.get(4).getFile(), Chessman.File.E);
        assertEquals(list.get(4).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(4).getSymbol(), Chessman.Symbol.BLACK_KING);

        assertEquals(list.get(5).getFile(), Chessman.File.F);
        assertEquals(list.get(5).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(5).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(6).getFile(), Chessman.File.G);
        assertEquals(list.get(6).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(6).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(7).getFile(), Chessman.File.H);
        assertEquals(list.get(7).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(7).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(8).getFile(), Chessman.File.A);
        assertEquals(list.get(8).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(8).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(9).getFile(), Chessman.File.B);
        assertEquals(list.get(9).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(9).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(10).getFile(), Chessman.File.D);
        assertEquals(list.get(10).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(10).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(11).getFile(), Chessman.File.E);
        assertEquals(list.get(11).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(11).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(12).getFile(), Chessman.File.F);
        assertEquals(list.get(12).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(12).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(13).getFile(), Chessman.File.G);
        assertEquals(list.get(13).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(13).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(14).getFile(), Chessman.File.H);
        assertEquals(list.get(14).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(14).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        // 1. ... c5
        assertEquals(list.get(15).getFile(), Chessman.File.C);
        assertEquals(list.get(15).getRank(), Chessman.Rank.R5);
        assertEquals(list.get(15).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        // 1. e4...
        assertEquals(list.get(16).getFile(), Chessman.File.E);
        assertEquals(list.get(16).getRank(), Chessman.Rank.R4);
        assertEquals(list.get(16).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(17).getFile(), Chessman.File.A);
        assertEquals(list.get(17).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(17).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(18).getFile(), Chessman.File.B);
        assertEquals(list.get(18).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(18).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(19).getFile(), Chessman.File.C);
        assertEquals(list.get(19).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(19).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(20).getFile(), Chessman.File.D);
        assertEquals(list.get(20).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(20).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(21).getFile(), Chessman.File.F);
        assertEquals(list.get(21).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(21).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(22).getFile(), Chessman.File.G);
        assertEquals(list.get(22).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(22).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(23).getFile(), Chessman.File.H);
        assertEquals(list.get(23).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(23).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(24).getFile(), Chessman.File.A);
        assertEquals(list.get(24).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(24).getSymbol(), Chessman.Symbol.WHITE_ROOK);

        assertEquals(list.get(25).getFile(), Chessman.File.B);
        assertEquals(list.get(25).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(25).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(26).getFile(), Chessman.File.C);
        assertEquals(list.get(26).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(26).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(27).getFile(), Chessman.File.D);
        assertEquals(list.get(27).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(27).getSymbol(), Chessman.Symbol.WHITE_QUEEN);

        assertEquals(list.get(28).getFile(), Chessman.File.E);
        assertEquals(list.get(28).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(28).getSymbol(), Chessman.Symbol.WHITE_KING);

        assertEquals(list.get(29).getFile(), Chessman.File.F);
        assertEquals(list.get(29).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(29).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(30).getFile(), Chessman.File.G);
        assertEquals(list.get(30).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(30).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(31).getFile(), Chessman.File.H);
        assertEquals(list.get(31).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(31).getSymbol(), Chessman.Symbol.WHITE_ROOK);
    }

    @Test
    public void iterator_next_valid_fen3() {
        List<Chessman> list = new ArrayList<>();
        Fen p = new Fen(FEN3);
        Iterator it = p.iterator();

        while(it.hasNext()) {
            Chessman cm = (Chessman) it.next();
            list.add(cm);
        }

        assertEquals(list.size(), 32);

        assertEquals(list.get(0).getFile(), Chessman.File.A);
        assertEquals(list.get(0).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(0).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(1).getFile(), Chessman.File.B);
        assertEquals(list.get(1).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(1).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(2).getFile(), Chessman.File.C);
        assertEquals(list.get(2).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(2).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(3).getFile(), Chessman.File.D);
        assertEquals(list.get(3).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(3).getSymbol(), Chessman.Symbol.BLACK_QUEEN);

        assertEquals(list.get(4).getFile(), Chessman.File.E);
        assertEquals(list.get(4).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(4).getSymbol(), Chessman.Symbol.BLACK_KING);

        assertEquals(list.get(5).getFile(), Chessman.File.F);
        assertEquals(list.get(5).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(5).getSymbol(), Chessman.Symbol.BLACK_BISHOP);

        assertEquals(list.get(6).getFile(), Chessman.File.G);
        assertEquals(list.get(6).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(6).getSymbol(), Chessman.Symbol.BLACK_KNIGHT);

        assertEquals(list.get(7).getFile(), Chessman.File.H);
        assertEquals(list.get(7).getRank(), Chessman.Rank.R8);
        assertEquals(list.get(7).getSymbol(), Chessman.Symbol.BLACK_ROOK);

        assertEquals(list.get(8).getFile(), Chessman.File.A);
        assertEquals(list.get(8).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(8).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(9).getFile(), Chessman.File.B);
        assertEquals(list.get(9).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(9).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(10).getFile(), Chessman.File.D);
        assertEquals(list.get(10).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(10).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(11).getFile(), Chessman.File.E);
        assertEquals(list.get(11).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(11).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(12).getFile(), Chessman.File.F);
        assertEquals(list.get(12).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(12).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(13).getFile(), Chessman.File.G);
        assertEquals(list.get(13).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(13).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        assertEquals(list.get(14).getFile(), Chessman.File.H);
        assertEquals(list.get(14).getRank(), Chessman.Rank.R7);
        assertEquals(list.get(14).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        // 1. ... c5
        assertEquals(list.get(15).getFile(), Chessman.File.C);
        assertEquals(list.get(15).getRank(), Chessman.Rank.R5);
        assertEquals(list.get(15).getSymbol(), Chessman.Symbol.BLACK_PAWN);

        // 1. e4...
        assertEquals(list.get(16).getFile(), Chessman.File.E);
        assertEquals(list.get(16).getRank(), Chessman.Rank.R4);
        assertEquals(list.get(16).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(17).getFile(), Chessman.File.F);
        assertEquals(list.get(17).getRank(), Chessman.Rank.R3);
        assertEquals(list.get(17).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(18).getFile(), Chessman.File.A);
        assertEquals(list.get(18).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(18).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(19).getFile(), Chessman.File.B);
        assertEquals(list.get(19).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(19).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(20).getFile(), Chessman.File.C);
        assertEquals(list.get(20).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(20).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(21).getFile(), Chessman.File.D);
        assertEquals(list.get(21).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(21).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(22).getFile(), Chessman.File.F);
        assertEquals(list.get(22).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(22).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(23).getFile(), Chessman.File.G);
        assertEquals(list.get(23).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(23).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(24).getFile(), Chessman.File.H);
        assertEquals(list.get(24).getRank(), Chessman.Rank.R2);
        assertEquals(list.get(24).getSymbol(), Chessman.Symbol.WHITE_PAWN);

        assertEquals(list.get(25).getFile(), Chessman.File.A);
        assertEquals(list.get(25).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(25).getSymbol(), Chessman.Symbol.WHITE_ROOK);

        assertEquals(list.get(26).getFile(), Chessman.File.B);
        assertEquals(list.get(26).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(26).getSymbol(), Chessman.Symbol.WHITE_KNIGHT);

        assertEquals(list.get(27).getFile(), Chessman.File.C);
        assertEquals(list.get(27).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(27).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(28).getFile(), Chessman.File.D);
        assertEquals(list.get(28).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(28).getSymbol(), Chessman.Symbol.WHITE_QUEEN);

        assertEquals(list.get(29).getFile(), Chessman.File.E);
        assertEquals(list.get(29).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(29).getSymbol(), Chessman.Symbol.WHITE_KING);

        assertEquals(list.get(30).getFile(), Chessman.File.F);
        assertEquals(list.get(30).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(30).getSymbol(), Chessman.Symbol.WHITE_BISHOP);

        assertEquals(list.get(31).getFile(), Chessman.File.H);
        assertEquals(list.get(31).getRank(), Chessman.Rank.R1);
        assertEquals(list.get(31).getSymbol(), Chessman.Symbol.WHITE_ROOK);
    }

    @Test
    public void iterator_next_invalid_fen0() {
        Fen p = new Fen(INVALID_FEN0);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen1() {
        Fen p = new Fen(INVALID_FEN1);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen2() {
        Fen p = new Fen(INVALID_FEN2);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen3() {
        Fen p = new Fen(INVALID_FEN3);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen4() {
        Fen p = new Fen(INVALID_FEN4);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen5() {
        Fen p = new Fen(INVALID_FEN5);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen6() {
        Fen p = new Fen(INVALID_FEN6);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen7() {
        Fen p = new Fen(INVALID_FEN7);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen8() {
        Fen p = new Fen(INVALID_FEN8);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen9() {
        Fen p = new Fen(INVALID_FEN9);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen10() {
        Fen p = new Fen(INVALID_FEN10);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen11() {
        Fen p = new Fen(INVALID_FEN11);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen12() {
        Fen p = new Fen(INVALID_FEN12);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen13() {
        Fen p = new Fen(INVALID_FEN13);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen14() {
        Fen p = new Fen(INVALID_FEN14);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen15() {
        Fen p = new Fen(INVALID_FEN15);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen16() {
        Fen p = new Fen(INVALID_FEN16);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

    @Test
    public void iterator_next_invalid_fen17() {
        Fen p = new Fen(INVALID_FEN17);
        assertFalse(p.isValid());
        assertFalse(p.iterator().hasNext());
        exception.expect(NoSuchElementException.class);
        p.iterator().next();
    }

}
