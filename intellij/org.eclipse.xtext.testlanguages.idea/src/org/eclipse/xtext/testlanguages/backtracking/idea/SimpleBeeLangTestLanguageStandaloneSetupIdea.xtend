/*
 * generated by Xtext
 */
package org.eclipse.xtext.testlanguages.backtracking.idea

import com.google.inject.Guice
import org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguageRuntimeModule
import org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguageStandaloneSetupGenerated
import org.eclipse.xtext.util.Modules2

class SimpleBeeLangTestLanguageStandaloneSetupIdea extends SimpleBeeLangTestLanguageStandaloneSetupGenerated {
	override createInjector() {
		val runtimeModule = new SimpleBeeLangTestLanguageRuntimeModule()
		val ideaModule = new SimpleBeeLangTestLanguageIdeaModule()
		val mergedModule = Modules2.mixin(runtimeModule, ideaModule)
		return Guice.createInjector(mergedModule)
	}
}
