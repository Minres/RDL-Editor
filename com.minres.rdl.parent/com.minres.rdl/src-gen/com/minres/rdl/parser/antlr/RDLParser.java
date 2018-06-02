/*
 * generated by Xtext 2.13.0
 */
package com.minres.rdl.parser.antlr;

import com.google.inject.Inject;
import com.minres.rdl.parser.antlr.internal.InternalRDLParser;
import com.minres.rdl.services.RDLGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class RDLParser extends AbstractAntlrParser {

	@Inject
	private RDLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ESCAPE_JSP", "RULE_ESCAPE_ORDL");
	}
	

	@Override
	protected InternalRDLParser createParser(XtextTokenStream stream) {
		return new InternalRDLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Root";
	}

	public RDLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RDLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
