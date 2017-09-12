package com.minres.rdl.messages;

import com.google.inject.Inject
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider

class RDLSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {
     
    public static val String USED_RESERVED_KEYWORD = "USED_RESERVED_KEYWORD" 
     
    @Inject IGrammarAccess grammarAccess
    /**
     * Customized error message for reserved keywords
     */
    override getSyntaxErrorMessage(IParserErrorContext context) {
    	println context?.recognitionException?.class
        val unexpectedText = context?.recognitionException?.token?.text
        if (GrammarUtil::getAllKeywords(grammarAccess.getGrammar()).contains(unexpectedText)) {
            println(context.defaultMessage)
            return new SyntaxErrorMessage('''
            "«unexpectedText»" is a reserved keyword which is not allowed as Identifier.
            Please choose another word or alternatively confuse your co-workers by escaping it with the caret (^) character like this: "^«unexpectedText»".''',
            USED_RESERVED_KEYWORD) 
        }
        super.getSyntaxErrorMessage(context)
    }
}