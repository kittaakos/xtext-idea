/*
 * generated by Xtext
 */
package org.eclipse.xtext.lexer.idea;

import com.intellij.openapi.extensions.ExtensionFactory;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

public class BacktrackingLexerTestLanguageExtensionFactory implements ExtensionFactory {
	@Override
	public Object createInstance(String factoryArgument, String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return BacktrackingLexerTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}
}