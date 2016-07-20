/*
 * generated by Xtext
 */
package org.eclipse.xtext.testlanguages.backtracking.idea;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.intellij.facet.FacetTypeId;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.idea.DefaultIdeaModule;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.testlanguages.backtracking.ide.contentassist.antlr.ExBeeLangTestLanguageParser;
import org.eclipse.xtext.testlanguages.backtracking.ide.contentassist.antlr.lexer.InternalExBeeLangTestLanguageLexer;
import org.eclipse.xtext.testlanguages.backtracking.idea.facet.ExBeeLangTestLanguageFacetConfiguration;
import org.eclipse.xtext.testlanguages.backtracking.idea.facet.ExBeeLangTestLanguageFacetType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.ExBeeLangTestLanguageParserDefinition;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.ExBeeLangTestLanguagePsiParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.ExBeeLangTestLanguageTokenTypeProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.antlr.ExBeeLangTestLanguageAntlrTokenFileProvider;
import org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal.PsiInternalExBeeLangTestLanguageLexer;

/**
 * Manual modifications go to {@link ExBeeLangTestLanguageIdeaModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractExBeeLangTestLanguageIdeaModule extends DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return ExBeeLangTestLanguageAntlrTokenFileProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends Lexer> bindLexer() {
		return PsiInternalExBeeLangTestLanguageLexer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public void configureRuntimeLexer(Binder binder) {
		binder.bind(Lexer.class)
			.annotatedWith(Names.named(LexerBindings.RUNTIME))
			.to(PsiInternalExBeeLangTestLanguageLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends PsiParser> bindPsiParser() {
		return ExBeeLangTestLanguagePsiParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends TokenTypeProvider> bindTokenTypeProvider() {
		return ExBeeLangTestLanguageTokenTypeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends ParserDefinition> bindParserDefinition() {
		return ExBeeLangTestLanguageParserDefinition.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	@SingletonBinding
	public Class<? extends IElementTypeProvider> bindIElementTypeProvider() {
		return ExBeeLangTestLanguageElementTypeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends AbstractFacetConfiguration> bindAbstractFacetConfiguration() {
		return ExBeeLangTestLanguageFacetConfiguration.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public FacetTypeId bindFacetTypeIdToInstance() {
		return ExBeeLangTestLanguageFacetType.TYPEID;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return ExBeeLangTestLanguageParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(InternalExBeeLangTestLanguageLexer.class);
	}
	
}