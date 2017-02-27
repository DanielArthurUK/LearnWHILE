// Generated from TreeParser.g4 by ANTLR 4.6

	package uk.danielarthur.learnwhile.datatypes;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TreeParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, WS=5;
	public static final int
		RULE_binaryTree = 0, RULE_nil = 1;
	public static final String[] ruleNames = {
		"binaryTree", "nil"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<'", "'.'", "'>'", "'nil'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "WS"
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
	public String getGrammarFileName() { return "TreeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TreeParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BinaryTreeContext extends ParserRuleContext {
		public NilContext nil() {
			return getRuleContext(NilContext.class,0);
		}
		public List<BinaryTreeContext> binaryTree() {
			return getRuleContexts(BinaryTreeContext.class);
		}
		public BinaryTreeContext binaryTree(int i) {
			return getRuleContext(BinaryTreeContext.class,i);
		}
		public BinaryTreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryTree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeParserListener ) ((TreeParserListener)listener).enterBinaryTree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeParserListener ) ((TreeParserListener)listener).exitBinaryTree(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeParserVisitor ) return ((TreeParserVisitor<? extends T>)visitor).visitBinaryTree(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryTreeContext binaryTree() throws RecognitionException {
		BinaryTreeContext _localctx = new BinaryTreeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_binaryTree);
		try {
			setState(11);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(4);
				nil();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(5);
				match(T__0);
				setState(6);
				binaryTree();
				setState(7);
				match(T__1);
				setState(8);
				binaryTree();
				setState(9);
				match(T__2);
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

	public static class NilContext extends ParserRuleContext {
		public NilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TreeParserListener ) ((TreeParserListener)listener).enterNil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TreeParserListener ) ((TreeParserListener)listener).exitNil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TreeParserVisitor ) return ((TreeParserVisitor<? extends T>)visitor).visitNil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NilContext nil() throws RecognitionException {
		NilContext _localctx = new NilContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nil);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			match(T__3);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\22\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\16\n\2\3\3\3\3\3\3\2\2\4\2\4\2\2"+
		"\20\2\r\3\2\2\2\4\17\3\2\2\2\6\16\5\4\3\2\7\b\7\3\2\2\b\t\5\2\2\2\t\n"+
		"\7\4\2\2\n\13\5\2\2\2\13\f\7\5\2\2\f\16\3\2\2\2\r\6\3\2\2\2\r\7\3\2\2"+
		"\2\16\3\3\2\2\2\17\20\7\6\2\2\20\5\3\2\2\2\3\r";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}