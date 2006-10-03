/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.ui.dashboard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gmf.bridge.ui.dashboard.DashboardState;
import org.eclipse.ui.IMemento;

/**
 * @author dstadnik
 */
public class DashboardPersistence {

	private static final String DS_ELEMENT = "dashboardState"; //$NON-NLS-1$

	private static final String PROJECT_KEY = "project"; //$NON-NLS-1$

	private static final String DM_KEY = "domainModel"; //$NON-NLS-1$

	private static final String DGM_KEY = "domainGenerationModel"; //$NON-NLS-1$

	private static final String GDM_KEY = "graphicalDefinitionModel"; //$NON-NLS-1$

	private static final String TDM_KEY = "toolingDefinitionModel"; //$NON-NLS-1$

	private static final String MM_KEY = "mappingModel"; //$NON-NLS-1$

	private static final String GM_KEY = "generationModel"; //$NON-NLS-1$

	public static Map<IProject, DashboardState> read(IMemento memento) {
		Map<IProject, DashboardState> states = new HashMap<IProject, DashboardState>();
		IMemento[] stateMementos = memento.getChildren(DS_ELEMENT);
		for (int i = 0; i < stateMementos.length; i++) {
			IMemento stateMemento = stateMementos[i];
			String projectName = stateMemento.getString(PROJECT_KEY);
			if (projectName == null) {
				continue;
			}
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (!project.exists()) {
				continue;
			}
			DashboardState state = new DashboardState();
			state.dmFileName = stateMemento.getString(DM_KEY);
			state.dgmFileName = stateMemento.getString(DGM_KEY);
			state.gdmFileName = stateMemento.getString(GDM_KEY);
			state.tdmFileName = stateMemento.getString(TDM_KEY);
			state.mmFileName = stateMemento.getString(MM_KEY);
			state.gmFileName = stateMemento.getString(GM_KEY);
			states.put(project, state);
		}
		return states;
	}

	public static void write(IMemento memento, Map states) {
		for (Iterator it = states.keySet().iterator(); it.hasNext();) {
			IProject project = (IProject) it.next();
			DashboardState state = (DashboardState) states.get(project);
			IMemento stateMemento = memento.createChild(DS_ELEMENT);
			stateMemento.putString(PROJECT_KEY, project.getName());
			if (state.dmFileName != null) {
				stateMemento.putString(DM_KEY, state.dmFileName);
			}
			if (state.dgmFileName != null) {
				stateMemento.putString(DGM_KEY, state.dgmFileName);
			}
			if (state.gdmFileName != null) {
				stateMemento.putString(GDM_KEY, state.gdmFileName);
			}
			if (state.tdmFileName != null) {
				stateMemento.putString(TDM_KEY, state.tdmFileName);
			}
			if (state.mmFileName != null) {
				stateMemento.putString(MM_KEY, state.mmFileName);
			}
			if (state.gmFileName != null) {
				stateMemento.putString(GM_KEY, state.gmFileName);
			}
		}
	}
}
