/*
 * generated by Xtext
 */
grammar PsiInternalBug297105TestLanguage;

options {
	superClass=AbstractPsiAntlrParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.Bug297105TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;
}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/

	protected Bug297105TestLanguageGrammarAccess grammarAccess;

	protected Bug297105TestLanguageElementTypeProvider elementTypeProvider;

	public PsiInternalBug297105TestLanguageParser(PsiBuilder builder, TokenStream input, Bug297105TestLanguageElementTypeProvider elementTypeProvider, Bug297105TestLanguageGrammarAccess grammarAccess) {
		this(input);
		setPsiBuilder(builder);
    	this.grammarAccess = grammarAccess;
		this.elementTypeProvider = elementTypeProvider;
	}

	@Override
	protected String getFirstRuleName() {
		return "Model";
	}

}

//Entry rule entryRuleModel
entryRuleModel returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getModelElementType()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getModel_ExpressionsExpressionParserRuleCall_0ElementType());
			}
			lv_expressions_0_0=ruleExpression
			{
				doneComposite();
				if(!$current) {
					associateWithSemanticElement();
					$current = true;
				}
			}
		)
	)*
;

//Entry rule entryRuleExpression
entryRuleExpression returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getExpressionElementType()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [Boolean current=false]
:
	(
		(
			(
				{
					markComposite(elementTypeProvider.getExpression_LeftLiteralParserRuleCall_0_0ElementType());
				}
				lv_left_0_0=ruleLiteral
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
		{
			markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1ElementType());
		}
		otherlv_1='+'
		{
			doneLeaf(otherlv_1);
		}
		(
			(
				{
					markComposite(elementTypeProvider.getExpression_RightLiteralParserRuleCall_2_0ElementType());
				}
				lv_right_2_0=ruleLiteral
				{
					doneComposite();
					if(!$current) {
						associateWithSemanticElement();
						$current = true;
					}
				}
			)
		)
	)
;

//Entry rule entryRuleLiteral
entryRuleLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getLiteralElementType()); }
	iv_ruleLiteral=ruleLiteral
	{ $current=$iv_ruleLiteral.current; }
	EOF;

// Rule Literal
ruleLiteral returns [Boolean current=false]
:
	(
		{
			/* */
		}
		{
			markComposite(elementTypeProvider.getLiteral_RealLiteralParserRuleCall_0ElementType());
		}
		this_RealLiteral_0=ruleRealLiteral
		{
			$current = $this_RealLiteral_0.current;
			doneComposite();
		}
		    |
		{
			/* */
		}
		{
			markComposite(elementTypeProvider.getLiteral_IntLiteralParserRuleCall_1ElementType());
		}
		this_IntLiteral_1=ruleIntLiteral
		{
			$current = $this_IntLiteral_1.current;
			doneComposite();
		}
	)
;

//Entry rule entryRuleIntLiteral
entryRuleIntLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getIntLiteralElementType()); }
	iv_ruleIntLiteral=ruleIntLiteral
	{ $current=$iv_ruleIntLiteral.current; }
	EOF;

// Rule IntLiteral
ruleIntLiteral returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getIntLiteral_ValueIntValueParserRuleCall_0ElementType());
			}
			lv_value_0_0=ruleIntValue
			{
				doneComposite();
				if(!$current) {
					associateWithSemanticElement();
					$current = true;
				}
			}
		)
	)
;

//Entry rule entryRuleRealLiteral
entryRuleRealLiteral returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRealLiteralElementType()); }
	iv_ruleRealLiteral=ruleRealLiteral
	{ $current=$iv_ruleRealLiteral.current; }
	EOF;

// Rule RealLiteral
ruleRealLiteral returns [Boolean current=false]
:
	(
		(
			{
				markComposite(elementTypeProvider.getRealLiteral_ValueRealValueParserRuleCall_0ElementType());
			}
			lv_value_0_0=ruleRealValue
			{
				doneComposite();
				if(!$current) {
					associateWithSemanticElement();
					$current = true;
				}
			}
		)
	)
;

//Entry rule entryRuleIntValue
entryRuleIntValue returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getIntValueElementType()); }
	iv_ruleIntValue=ruleIntValue
	{ $current=$iv_ruleIntValue.current; }
	EOF;

// Rule IntValue
ruleIntValue returns [Boolean current=false]
:
	{
		markLeaf(elementTypeProvider.getIntValue_INTTerminalRuleCallElementType());
	}
	this_INT_0=RULE_INT
	{
		doneLeaf(this_INT_0);
	}
;

//Entry rule entryRuleRealValue
entryRuleRealValue returns [Boolean current=false]:
	{ markComposite(elementTypeProvider.getRealValueElementType()); }
	iv_ruleRealValue=ruleRealValue
	{ $current=$iv_ruleRealValue.current; }
	EOF;

// Rule RealValue
ruleRealValue returns [Boolean current=false]
:
	{
		markComposite(elementTypeProvider.getRealValue_RealParserRuleCallElementType());
	}
	ruleReal
	{
		doneComposite();
	}
;

//Entry rule entryRuleReal
entryRuleReal returns [Boolean current=false]@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	{ markComposite(elementTypeProvider.getRealElementType()); }
	iv_ruleReal=ruleReal
	{ $current=$iv_ruleReal.current; }
	EOF;
finally {
	myHiddenTokenState.restore();
}

// Rule Real
ruleReal returns [Boolean current=false]
@init {
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}:
	(
		(
			{
				markLeaf(elementTypeProvider.getReal_INTTerminalRuleCall_0ElementType());
			}
			this_INT_0=RULE_INT
			{
				doneLeaf(this_INT_0);
			}
		)?
		{
			markLeaf(elementTypeProvider.getReal_FullStopKeyword_1ElementType());
		}
		kw='.'
		{
			doneLeaf(kw);
		}
		(
			{
				markLeaf(elementTypeProvider.getReal_EXT_INTTerminalRuleCall_2_0ElementType());
			}
			this_EXT_INT_2=RULE_EXT_INT
			{
				doneLeaf(this_EXT_INT_2);
			}
			    |
			{
				markLeaf(elementTypeProvider.getReal_INTTerminalRuleCall_2_1ElementType());
			}
			this_INT_3=RULE_INT
			{
				doneLeaf(this_INT_3);
			}
		)
	)
;
finally {
	myHiddenTokenState.restore();
}

RULE_EXT_INT : RULE_INT ('e'|'E') ('-'|'+') RULE_INT;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;