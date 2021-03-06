// Generated from While.g4 by ANTLR 4.6

	package uk.danielarthur.learnwhile.interpreter;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ID=16, WS=17, 
		COMMENT=18, LINE_COMMENT=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "ID", "WS", "COMMENT", 
		"LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'read'", "'write'", "'nil'", "'cons'", "'hd'", "'tl'", "'('", "')'", 
		"'{'", "'}'", "';'", "'else'", "':='", "'while'", "'if'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ID", "WS", "COMMENT", "LINE_COMMENT"
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


	public WhileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "While.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\6\21`\n\21\r\21\16\21"+
		"a\3\22\6\22e\n\22\r\22\16\22f\3\22\3\22\3\23\3\23\3\23\3\23\7\23o\n\23"+
		"\f\23\16\23r\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24}"+
		"\n\24\f\24\16\24\u0080\13\24\3\24\3\24\3p\2\25\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		"\3\2\5\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u0086\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\3)\3\2\2\2\5.\3\2\2\2\7\64\3\2\2\2\t8\3\2\2\2\13=\3\2\2\2\r"+
		"@\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2\2\2\25I\3\2\2\2\27K\3\2\2\2"+
		"\31M\3\2\2\2\33R\3\2\2\2\35U\3\2\2\2\37[\3\2\2\2!_\3\2\2\2#d\3\2\2\2%"+
		"j\3\2\2\2\'x\3\2\2\2)*\7t\2\2*+\7g\2\2+,\7c\2\2,-\7f\2\2-\4\3\2\2\2./"+
		"\7y\2\2/\60\7t\2\2\60\61\7k\2\2\61\62\7v\2\2\62\63\7g\2\2\63\6\3\2\2\2"+
		"\64\65\7p\2\2\65\66\7k\2\2\66\67\7n\2\2\67\b\3\2\2\289\7e\2\29:\7q\2\2"+
		":;\7p\2\2;<\7u\2\2<\n\3\2\2\2=>\7j\2\2>?\7f\2\2?\f\3\2\2\2@A\7v\2\2AB"+
		"\7n\2\2B\16\3\2\2\2CD\7*\2\2D\20\3\2\2\2EF\7+\2\2F\22\3\2\2\2GH\7}\2\2"+
		"H\24\3\2\2\2IJ\7\177\2\2J\26\3\2\2\2KL\7=\2\2L\30\3\2\2\2MN\7g\2\2NO\7"+
		"n\2\2OP\7u\2\2PQ\7g\2\2Q\32\3\2\2\2RS\7<\2\2ST\7?\2\2T\34\3\2\2\2UV\7"+
		"y\2\2VW\7j\2\2WX\7k\2\2XY\7n\2\2YZ\7g\2\2Z\36\3\2\2\2[\\\7k\2\2\\]\7h"+
		"\2\2] \3\2\2\2^`\t\2\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\"\3"+
		"\2\2\2ce\t\3\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\b"+
		"\22\2\2i$\3\2\2\2jk\7*\2\2kl\7,\2\2lp\3\2\2\2mo\13\2\2\2nm\3\2\2\2or\3"+
		"\2\2\2pq\3\2\2\2pn\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\7,\2\2tu\7+\2\2uv\3\2"+
		"\2\2vw\b\23\2\2w&\3\2\2\2xy\7\61\2\2yz\7\61\2\2z~\3\2\2\2{}\n\4\2\2|{"+
		"\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0082\b\24\2\2\u0082(\3\2\2\2\7\2afp~\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}