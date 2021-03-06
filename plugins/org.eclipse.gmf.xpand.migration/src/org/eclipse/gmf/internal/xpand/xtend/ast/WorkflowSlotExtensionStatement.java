/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.xtend.ast;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.expression.ast.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.migration.ExpressionAnalyzeTrace;

public class WorkflowSlotExtensionStatement extends Extension {

	private final Identifier slotName;

    public WorkflowSlotExtensionStatement(final int start, final int end, final int line, final int startOffset, final int endOffset, final Identifier name,
            final List<DeclaredParameter> formalParameters, final Identifier returnType, final Identifier slotName,
            final boolean cached, final boolean isPrivate) {
        super(start, end, line, startOffset, endOffset, name, returnType, formalParameters, cached, isPrivate);
        this.slotName = slotName;
    }

    @Override
    public Object evaluateInternal(final Object[] parameters, final ExecutionContext ctx) {
    	final Variable result = ctx.getGlobalVariable(slotName.getValue());
    	if (result == null) {
    		return null;
    	}
        return result.getValue();
    }


    @Override
    public void analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        if (returnType == null) {
            issues.add(new AnalysationIssue(AnalysationIssue.Type.SYNTAX_ERROR,
                    "A return type must be specified for workflow slot extensions!", this));
		} else {
			createAnalyzeTrace(ctx, new ExpressionAnalyzeTrace(ctx.getTypeForName(getReturnTypeIdentifier().getValue())));
		}
    }

    @Override
    protected EClassifier internalGetReturnType(final EClassifier[] parameters, final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        if (returnType == null) {
            issues.add(new AnalysationIssue(AnalysationIssue.Type.SYNTAX_ERROR,
                    "A return type must be specified for workflow slot extensions!", this));
            return null;
        } else {
            return ctx.getTypeForName(returnType.getValue());
        }
    }
    
    public Identifier getSlotName() {
    	return slotName;
    }

}
