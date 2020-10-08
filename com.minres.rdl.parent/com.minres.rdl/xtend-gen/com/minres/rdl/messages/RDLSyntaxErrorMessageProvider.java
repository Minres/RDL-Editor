package com.minres.rdl.messages;

import com.google.inject.Inject;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class RDLSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {
  public static final String USED_RESERVED_KEYWORD = "USED_RESERVED_KEYWORD";
  
  @Inject
  private IGrammarAccess grammarAccess;
  
  /**
   * Customized error message for reserved keywords
   */
  @Override
  public SyntaxErrorMessage getSyntaxErrorMessage(final ISyntaxErrorMessageProvider.IParserErrorContext context) {
    SyntaxErrorMessage _xblockexpression = null;
    {
      InputOutput.println();
      RecognitionException _recognitionException = null;
      if (context!=null) {
        _recognitionException=context.getRecognitionException();
      }
      if (_recognitionException!=null) {
        _recognitionException.getClass();
      }
      RecognitionException _recognitionException_1 = null;
      if (context!=null) {
        _recognitionException_1=context.getRecognitionException();
      }
      Token _ken = null;
      if (_recognitionException_1!=null) {
        _ken=_recognitionException_1.token;
      }
      String _text = null;
      if (_ken!=null) {
        _text=_ken.getText();
      }
      final String unexpectedText = _text;
      boolean _contains = GrammarUtil.getAllKeywords(this.grammarAccess.getGrammar()).contains(unexpectedText);
      if (_contains) {
        InputOutput.<String>println(context.getDefaultMessage());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        _builder.append(unexpectedText);
        _builder.append("\" is a reserved keyword which is not allowed as Identifier.");
        _builder.newLineIfNotEmpty();
        _builder.append("Please choose another word or alternatively confuse your co-workers by escaping it with the caret (^) character like this: \"^");
        _builder.append(unexpectedText);
        _builder.append("\".");
        return new SyntaxErrorMessage(_builder.toString(), 
          RDLSyntaxErrorMessageProvider.USED_RESERVED_KEYWORD);
      }
      _xblockexpression = super.getSyntaxErrorMessage(context);
    }
    return _xblockexpression;
  }
}
