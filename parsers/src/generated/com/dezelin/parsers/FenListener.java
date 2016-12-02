// Generated from com/dezelin/parsers/Fen.g4 by ANTLR 4.5


package com.dezelin.parsers;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FenParser}.
 */
public interface FenListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FenParser#fen}.
	 * @param ctx the parse tree
	 */
	void enterFen(FenParser.FenContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#fen}.
	 * @param ctx the parse tree
	 */
	void exitFen(FenParser.FenContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#piecePlacement}.
	 * @param ctx the parse tree
	 */
	void enterPiecePlacement(FenParser.PiecePlacementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#piecePlacement}.
	 * @param ctx the parse tree
	 */
	void exitPiecePlacement(FenParser.PiecePlacementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#rank}.
	 * @param ctx the parse tree
	 */
	void enterRank(FenParser.RankContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#rank}.
	 * @param ctx the parse tree
	 */
	void exitRank(FenParser.RankContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#skipNumber}.
	 * @param ctx the parse tree
	 */
	void enterSkipNumber(FenParser.SkipNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#skipNumber}.
	 * @param ctx the parse tree
	 */
	void exitSkipNumber(FenParser.SkipNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#skipAll}.
	 * @param ctx the parse tree
	 */
	void enterSkipAll(FenParser.SkipAllContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#skipAll}.
	 * @param ctx the parse tree
	 */
	void exitSkipAll(FenParser.SkipAllContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#piece}.
	 * @param ctx the parse tree
	 */
	void enterPiece(FenParser.PieceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#piece}.
	 * @param ctx the parse tree
	 */
	void exitPiece(FenParser.PieceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#blackPiece}.
	 * @param ctx the parse tree
	 */
	void enterBlackPiece(FenParser.BlackPieceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#blackPiece}.
	 * @param ctx the parse tree
	 */
	void exitBlackPiece(FenParser.BlackPieceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#whitePiece}.
	 * @param ctx the parse tree
	 */
	void enterWhitePiece(FenParser.WhitePieceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#whitePiece}.
	 * @param ctx the parse tree
	 */
	void exitWhitePiece(FenParser.WhitePieceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#sideToMove}.
	 * @param ctx the parse tree
	 */
	void enterSideToMove(FenParser.SideToMoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#sideToMove}.
	 * @param ctx the parse tree
	 */
	void exitSideToMove(FenParser.SideToMoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#castlingAbility}.
	 * @param ctx the parse tree
	 */
	void enterCastlingAbility(FenParser.CastlingAbilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#castlingAbility}.
	 * @param ctx the parse tree
	 */
	void exitCastlingAbility(FenParser.CastlingAbilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#enPassantTargetSquare}.
	 * @param ctx the parse tree
	 */
	void enterEnPassantTargetSquare(FenParser.EnPassantTargetSquareContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#enPassantTargetSquare}.
	 * @param ctx the parse tree
	 */
	void exitEnPassantTargetSquare(FenParser.EnPassantTargetSquareContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#epSquare}.
	 * @param ctx the parse tree
	 */
	void enterEpSquare(FenParser.EpSquareContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#epSquare}.
	 * @param ctx the parse tree
	 */
	void exitEpSquare(FenParser.EpSquareContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#fileLetter}.
	 * @param ctx the parse tree
	 */
	void enterFileLetter(FenParser.FileLetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#fileLetter}.
	 * @param ctx the parse tree
	 */
	void exitFileLetter(FenParser.FileLetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#epRank}.
	 * @param ctx the parse tree
	 */
	void enterEpRank(FenParser.EpRankContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#epRank}.
	 * @param ctx the parse tree
	 */
	void exitEpRank(FenParser.EpRankContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#halfMoveClock}.
	 * @param ctx the parse tree
	 */
	void enterHalfMoveClock(FenParser.HalfMoveClockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#halfMoveClock}.
	 * @param ctx the parse tree
	 */
	void exitHalfMoveClock(FenParser.HalfMoveClockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FenParser#fullMoveCounter}.
	 * @param ctx the parse tree
	 */
	void enterFullMoveCounter(FenParser.FullMoveCounterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FenParser#fullMoveCounter}.
	 * @param ctx the parse tree
	 */
	void exitFullMoveCounter(FenParser.FullMoveCounterContext ctx);
}