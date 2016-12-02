// Generated from com/dezelin/parsers/Fen.g4 by ANTLR 4.5


package com.dezelin.parsers;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FenParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, ErrorCharacter=34;
	public static final int
		RULE_fen = 0, RULE_piecePlacement = 1, RULE_rank = 2, RULE_skipNumber = 3, 
		RULE_skipAll = 4, RULE_piece = 5, RULE_blackPiece = 6, RULE_whitePiece = 7, 
		RULE_sideToMove = 8, RULE_castlingAbility = 9, RULE_enPassantTargetSquare = 10, 
		RULE_epSquare = 11, RULE_fileLetter = 12, RULE_epRank = 13, RULE_halfMoveClock = 14, 
		RULE_fullMoveCounter = 15;
	public static final String[] ruleNames = {
		"fen", "piecePlacement", "rank", "skipNumber", "skipAll", "piece", "blackPiece", 
		"whitePiece", "sideToMove", "castlingAbility", "enPassantTargetSquare", 
		"epSquare", "fileLetter", "epRank", "halfMoveClock", "fullMoveCounter"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "' '", "'/'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", 
		"'p'", "'n'", "'b'", "'r'", "'q'", "'k'", "'P'", "'N'", "'B'", "'R'", 
		"'Q'", "'K'", "'w'", "'-'", "'a'", "'c'", "'d'", "'e'", "'f'", "'g'", 
		"'h'", "'0'", "'9'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "ErrorCharacter"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Fen.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FenParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FenContext extends ParserRuleContext {
		public PiecePlacementContext piecePlacement() {
			return getRuleContext(PiecePlacementContext.class,0);
		}
		public SideToMoveContext sideToMove() {
			return getRuleContext(SideToMoveContext.class,0);
		}
		public CastlingAbilityContext castlingAbility() {
			return getRuleContext(CastlingAbilityContext.class,0);
		}
		public EnPassantTargetSquareContext enPassantTargetSquare() {
			return getRuleContext(EnPassantTargetSquareContext.class,0);
		}
		public HalfMoveClockContext halfMoveClock() {
			return getRuleContext(HalfMoveClockContext.class,0);
		}
		public FullMoveCounterContext fullMoveCounter() {
			return getRuleContext(FullMoveCounterContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FenParser.EOF, 0); }
		public FenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterFen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitFen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitFen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FenContext fen() throws RecognitionException {
		FenContext _localctx = new FenContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			piecePlacement();
			setState(33);
			match(T__0);
			setState(34);
			sideToMove();
			setState(35);
			match(T__0);
			setState(36);
			castlingAbility();
			setState(37);
			match(T__0);
			setState(38);
			enPassantTargetSquare();
			setState(39);
			match(T__0);
			setState(40);
			halfMoveClock();
			setState(41);
			match(T__0);
			setState(42);
			fullMoveCounter();
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PiecePlacementContext extends ParserRuleContext {
		public List<RankContext> rank() {
			return getRuleContexts(RankContext.class);
		}
		public RankContext rank(int i) {
			return getRuleContext(RankContext.class,i);
		}
		public PiecePlacementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piecePlacement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterPiecePlacement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitPiecePlacement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitPiecePlacement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PiecePlacementContext piecePlacement() throws RecognitionException {
		PiecePlacementContext _localctx = new PiecePlacementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_piecePlacement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			rank();
			setState(46);
			match(T__1);
			setState(47);
			rank();
			setState(48);
			match(T__1);
			setState(49);
			rank();
			setState(50);
			match(T__1);
			setState(51);
			rank();
			setState(52);
			match(T__1);
			setState(53);
			rank();
			setState(54);
			match(T__1);
			setState(55);
			rank();
			setState(56);
			match(T__1);
			setState(57);
			rank();
			setState(58);
			match(T__1);
			setState(59);
			rank();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RankContext extends ParserRuleContext {
		public List<PieceContext> piece() {
			return getRuleContexts(PieceContext.class);
		}
		public PieceContext piece(int i) {
			return getRuleContext(PieceContext.class,i);
		}
		public List<SkipNumberContext> skipNumber() {
			return getRuleContexts(SkipNumberContext.class);
		}
		public SkipNumberContext skipNumber(int i) {
			return getRuleContext(SkipNumberContext.class,i);
		}
		public SkipAllContext skipAll() {
			return getRuleContext(SkipAllContext.class,0);
		}
		public RankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterRank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitRank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitRank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RankContext rank() throws RecognitionException {
		RankContext _localctx = new RankContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rank);
		int _la;
		try {
			int _alt;
			setState(78);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
					{
					setState(61);
					skipNumber();
					}
				}

				setState(64);
				piece();
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(66);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
							{
							setState(65);
							skipNumber();
							}
						}

						setState(68);
						piece();
						}
						} 
					}
					setState(73);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(75);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
					{
					setState(74);
					skipNumber();
					}
				}

				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				skipAll();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipNumberContext extends ParserRuleContext {
		public SkipNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterSkipNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitSkipNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitSkipNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipNumberContext skipNumber() throws RecognitionException {
		SkipNumberContext _localctx = new SkipNumberContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_skipNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipAllContext extends ParserRuleContext {
		public SkipAllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipAll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterSkipAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitSkipAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitSkipAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipAllContext skipAll() throws RecognitionException {
		SkipAllContext _localctx = new SkipAllContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_skipAll);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PieceContext extends ParserRuleContext {
		public BlackPieceContext blackPiece() {
			return getRuleContext(BlackPieceContext.class,0);
		}
		public WhitePieceContext whitePiece() {
			return getRuleContext(WhitePieceContext.class,0);
		}
		public PieceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_piece; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterPiece(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitPiece(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitPiece(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PieceContext piece() throws RecognitionException {
		PieceContext _localctx = new PieceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_piece);
		try {
			setState(86);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				blackPiece();
				}
				break;
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				whitePiece();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlackPieceContext extends ParserRuleContext {
		public BlackPieceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blackPiece; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterBlackPiece(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitBlackPiece(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitBlackPiece(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlackPieceContext blackPiece() throws RecognitionException {
		BlackPieceContext _localctx = new BlackPieceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blackPiece);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhitePieceContext extends ParserRuleContext {
		public WhitePieceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whitePiece; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterWhitePiece(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitWhitePiece(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitWhitePiece(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhitePieceContext whitePiece() throws RecognitionException {
		WhitePieceContext _localctx = new WhitePieceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whitePiece);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SideToMoveContext extends ParserRuleContext {
		public SideToMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sideToMove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterSideToMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitSideToMove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitSideToMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SideToMoveContext sideToMove() throws RecognitionException {
		SideToMoveContext _localctx = new SideToMoveContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sideToMove);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastlingAbilityContext extends ParserRuleContext {
		public CastlingAbilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castlingAbility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterCastlingAbility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitCastlingAbility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitCastlingAbility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastlingAbilityContext castlingAbility() throws RecognitionException {
		CastlingAbilityContext _localctx = new CastlingAbilityContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_castlingAbility);
		int _la;
		try {
			setState(107);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(T__23);
				}
				break;
			case T__0:
			case T__14:
			case T__15:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(95);
					match(T__21);
					}
				}

				setState(99);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(98);
					match(T__20);
					}
				}

				setState(102);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(101);
					match(T__15);
					}
				}

				setState(105);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(104);
					match(T__14);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnPassantTargetSquareContext extends ParserRuleContext {
		public EpSquareContext epSquare() {
			return getRuleContext(EpSquareContext.class,0);
		}
		public EnPassantTargetSquareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enPassantTargetSquare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterEnPassantTargetSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitEnPassantTargetSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitEnPassantTargetSquare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnPassantTargetSquareContext enPassantTargetSquare() throws RecognitionException {
		EnPassantTargetSquareContext _localctx = new EnPassantTargetSquareContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enPassantTargetSquare);
		try {
			setState(111);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(T__23);
				}
				break;
			case T__12:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				epSquare();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EpSquareContext extends ParserRuleContext {
		public FileLetterContext fileLetter() {
			return getRuleContext(FileLetterContext.class,0);
		}
		public EpRankContext epRank() {
			return getRuleContext(EpRankContext.class,0);
		}
		public EpSquareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_epSquare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterEpSquare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitEpSquare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitEpSquare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EpSquareContext epSquare() throws RecognitionException {
		EpSquareContext _localctx = new EpSquareContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_epSquare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			fileLetter();
			setState(114);
			epRank();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileLetterContext extends ParserRuleContext {
		public FileLetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileLetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterFileLetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitFileLetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitFileLetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileLetterContext fileLetter() throws RecognitionException {
		FileLetterContext _localctx = new FileLetterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fileLetter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EpRankContext extends ParserRuleContext {
		public EpRankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_epRank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterEpRank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitEpRank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitEpRank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EpRankContext epRank() throws RecognitionException {
		EpRankContext _localctx = new EpRankContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_epRank);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HalfMoveClockContext extends ParserRuleContext {
		public HalfMoveClockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halfMoveClock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterHalfMoveClock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitHalfMoveClock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitHalfMoveClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalfMoveClockContext halfMoveClock() throws RecognitionException {
		HalfMoveClockContext _localctx = new HalfMoveClockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_halfMoveClock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__32))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__32))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullMoveCounterContext extends ParserRuleContext {
		public FullMoveCounterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullMoveCounter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).enterFullMoveCounter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FenListener ) ((FenListener)listener).exitFullMoveCounter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FenVisitor ) return ((FenVisitor<? extends T>)visitor).visitFullMoveCounter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullMoveCounterContext fullMoveCounter() throws RecognitionException {
		FullMoveCounterContext _localctx = new FullMoveCounterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fullMoveCounter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__32))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				{
				setState(126);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__32))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u0087\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\5\4A\n\4\3\4\3\4\5\4E\n\4\3\4"+
		"\7\4H\n\4\f\4\16\4K\13\4\3\4\5\4N\n\4\3\4\5\4Q\n\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\5\7Y\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\5\13c\n\13\3\13\5\13f"+
		"\n\13\3\13\5\13i\n\13\3\13\5\13l\n\13\5\13n\n\13\3\f\3\f\5\fr\n\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\6\20|\n\20\r\20\16\20}\3\21\3\21\7\21"+
		"\u0082\n\21\f\21\16\21\u0085\13\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \2\n\3\2\5\13\3\2\r\22\3\2\23\30\4\2\17\17\31\31\4\2\17"+
		"\17\33!\4\2\7\7\n\n\4\2\5\f\"#\4\2\5\f##\u0084\2\"\3\2\2\2\4/\3\2\2\2"+
		"\6P\3\2\2\2\bR\3\2\2\2\nT\3\2\2\2\fX\3\2\2\2\16Z\3\2\2\2\20\\\3\2\2\2"+
		"\22^\3\2\2\2\24m\3\2\2\2\26q\3\2\2\2\30s\3\2\2\2\32v\3\2\2\2\34x\3\2\2"+
		"\2\36{\3\2\2\2 \177\3\2\2\2\"#\5\4\3\2#$\7\3\2\2$%\5\22\n\2%&\7\3\2\2"+
		"&\'\5\24\13\2\'(\7\3\2\2()\5\26\f\2)*\7\3\2\2*+\5\36\20\2+,\7\3\2\2,-"+
		"\5 \21\2-.\7\2\2\3.\3\3\2\2\2/\60\5\6\4\2\60\61\7\4\2\2\61\62\5\6\4\2"+
		"\62\63\7\4\2\2\63\64\5\6\4\2\64\65\7\4\2\2\65\66\5\6\4\2\66\67\7\4\2\2"+
		"\678\5\6\4\289\7\4\2\29:\5\6\4\2:;\7\4\2\2;<\5\6\4\2<=\7\4\2\2=>\5\6\4"+
		"\2>\5\3\2\2\2?A\5\b\5\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BI\5\f\7\2CE\5\b"+
		"\5\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FH\5\f\7\2GD\3\2\2\2HK\3\2\2\2IG\3\2"+
		"\2\2IJ\3\2\2\2JM\3\2\2\2KI\3\2\2\2LN\5\b\5\2ML\3\2\2\2MN\3\2\2\2NQ\3\2"+
		"\2\2OQ\5\n\6\2P@\3\2\2\2PO\3\2\2\2Q\7\3\2\2\2RS\t\2\2\2S\t\3\2\2\2TU\7"+
		"\f\2\2U\13\3\2\2\2VY\5\16\b\2WY\5\20\t\2XV\3\2\2\2XW\3\2\2\2Y\r\3\2\2"+
		"\2Z[\t\3\2\2[\17\3\2\2\2\\]\t\4\2\2]\21\3\2\2\2^_\t\5\2\2_\23\3\2\2\2"+
		"`n\7\32\2\2ac\7\30\2\2ba\3\2\2\2bc\3\2\2\2ce\3\2\2\2df\7\27\2\2ed\3\2"+
		"\2\2ef\3\2\2\2fh\3\2\2\2gi\7\22\2\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jl\7"+
		"\21\2\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2\2m`\3\2\2\2mb\3\2\2\2n\25\3\2\2\2"+
		"or\7\32\2\2pr\5\30\r\2qo\3\2\2\2qp\3\2\2\2r\27\3\2\2\2st\5\32\16\2tu\5"+
		"\34\17\2u\31\3\2\2\2vw\t\6\2\2w\33\3\2\2\2xy\t\7\2\2y\35\3\2\2\2z|\t\b"+
		"\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\37\3\2\2\2\177\u0083\t\t"+
		"\2\2\u0080\u0082\t\b\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084!\3\2\2\2\u0085\u0083\3\2\2\2"+
		"\20@DIMPXbehkmq}\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}