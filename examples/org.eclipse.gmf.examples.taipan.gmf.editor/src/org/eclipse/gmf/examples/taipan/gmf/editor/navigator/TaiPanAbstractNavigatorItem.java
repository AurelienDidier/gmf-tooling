/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.gmf.runtime.diagram.ui.properties.views.IReadOnlyDiagramPropertySheetPageContributor;

import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class TaiPanAbstractNavigatorItem implements IAdaptable {

	/**
	 * @generated
	 */
	abstract public String getModelID();

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {
		if (ITabbedPropertySheetPageContributor.class.isAssignableFrom(adapter)) {
			return new IReadOnlyDiagramPropertySheetPageContributor() {

				public String getContributorId() {
					return "org.eclipse.gmf.examples.taipan.gmf.editor";
				}
			};
		}
		return null;
	}

}
