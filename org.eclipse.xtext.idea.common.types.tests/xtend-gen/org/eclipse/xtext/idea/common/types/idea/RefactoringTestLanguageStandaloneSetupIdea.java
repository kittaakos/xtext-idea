/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types.idea;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.xtext.idea.common.types.RefactoringTestLanguageRuntimeModule;
import org.eclipse.xtext.idea.common.types.RefactoringTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.idea.common.types.idea.RefactoringTestLanguageIdeaModule;
import org.eclipse.xtext.util.Modules2;

@SuppressWarnings("all")
public class RefactoringTestLanguageStandaloneSetupIdea extends RefactoringTestLanguageStandaloneSetupGenerated {
  @Override
  public Injector createInjector() {
    final RefactoringTestLanguageRuntimeModule runtimeModule = new RefactoringTestLanguageRuntimeModule();
    final RefactoringTestLanguageIdeaModule ideaModule = new RefactoringTestLanguageIdeaModule();
    final Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
    return Guice.createInjector(mergedModule);
  }
}
