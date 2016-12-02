// Generated from com/dezelin/parsers/Fen.g4 by ANTLR 4.5


package com.dezelin.parsers;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FenParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FenVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FenParser#fen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFen(FenParser.FenContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#piecePlacement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiecePlacement(FenParser.PiecePlacementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#rank}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRank(FenParser.RankContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#skipNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipNumber(FenParser.SkipNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#skipAll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipAll(FenParser.SkipAllContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#piece}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiece(FenParser.PieceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#blackPiece}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlackPiece(FenParser.BlackPieceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#whitePiece}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhitePiece(FenParser.WhitePieceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#sideToMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSideToMove(FenParser.SideToMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#castlingAbility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastlingAbility(FenParser.CastlingAbilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#enPassantTargetSquare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnPassantTargetSquare(FenParser.EnPassantTargetSquareContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#epSquare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpSquare(FenParser.EpSquareContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#fileLetter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileLetter(FenParser.FileLetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#epRank}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpRank(FenParser.EpRankContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#halfMoveClock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalfMoveClock(FenParser.HalfMoveClockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FenParser#fullMoveCounter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullMoveCounter(FenParser.FullMoveCounterContext ctx);
}