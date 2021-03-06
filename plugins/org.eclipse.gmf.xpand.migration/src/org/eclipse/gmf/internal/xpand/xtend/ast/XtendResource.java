/*
 * <copyright>
 *
 * Copyright (c) 2005-2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Alexander Shatalin (Borland)
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.xtend.ast;

import java.util.List;
import java.util.Set;

import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;

public interface XtendResource extends ResourceMarker {

    public static final String FILE_EXTENSION = "ext";

    List<Extension> getExtensions();

    List<Extension> getPublicExtensions(ResourceManager resourceManager);

    public String[] getImportedNamespaces();

    public String[] getImportedExtensions();
    
    public boolean isReexported(String importedExtensionName);

    void analyze(ExecutionContext ctx, Set<AnalysationIssue> issues);
}
