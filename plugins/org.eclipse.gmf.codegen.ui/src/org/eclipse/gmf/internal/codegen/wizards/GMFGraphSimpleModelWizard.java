/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dstadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.wizards;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.presentation.GMFGraphModelWizard;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class GMFGraphSimpleModelWizard extends GMFGraphModelWizard {

	protected DomainModelSelectionPage domainModelSelectionPage;

	protected GraphicalDefinitionPage graphicalDefinitionPage;

	protected EObject createInitialModel() {
		Canvas canvas = (Canvas) gmfGraphFactory.createCanvas();
		CheckboxTreeViewer viewer = graphicalDefinitionPage.getViewer();
		EPackage ePackage = (EPackage) viewer.getInput();
		if (ePackage != null) {
			canvas.setName(ePackage.getName());
			FigureGallery fGallery = gmfGraphFactory.createFigureGallery();
			fGallery.setName("default");
			canvas.getFigures().add(fGallery);
			for (Iterator ePackageIt = ePackage.eContents().iterator(); ePackageIt.hasNext();) {
				EObject ePackageObj = (EObject) ePackageIt.next();
				if (!viewer.getChecked(ePackageObj)) {
					continue;
				}
				if (ePackageObj instanceof EClass) {
					EClass eClass = (EClass) ePackageObj;
					Rectangle figure = gmfGraphFactory.createRectangle();
					figure.setName(eClass.getName() + "Figure");
					fGallery.getFigures().add(figure);
					Node dElement = gmfGraphFactory.createNode();
					dElement.setFigure(figure);
					dElement.setName(eClass.getName() + "Node");
					canvas.getNodes().add(dElement);
				}
			}
		}
		return canvas;
	}

	public void addPages() {
		super.addPages();

		if (selection != null && !selection.isEmpty()) {
			Object selected = selection.getFirstElement();
			if (selected instanceof IFile) {
				newFileCreationPage.setFileName(WizardUtil.getDefaultFileName((IFile) selected, "gmfgraph"));
			}
		}

		initialObjectCreationPage.dispose();
		initialObjectCreationPage = new PredefinedInitialObjectCreationPage("Whatever2");

		domainModelSelectionPage = new DomainModelSelectionPage("DomainModelSelectionPage", selection);
		domainModelSelectionPage.setTitle("Domain Model");
		domainModelSelectionPage.setDescription("Select file with ecore domain model");
		addPage(domainModelSelectionPage);

		graphicalDefinitionPage = new GraphicalDefinitionPage("GraphicalDefinitionPage", domainModelSelectionPage);
		graphicalDefinitionPage.setTitle("Graphical Definition");
		graphicalDefinitionPage.setDescription("Specify basic graphical definition of the domain model");
		addPage(graphicalDefinitionPage);
	}

	public void addPage(IWizardPage page) {
		if (page == initialObjectCreationPage) {
			return;
		}
		super.addPage(page);
	}

	public class PredefinedInitialObjectCreationPage extends GMFGraphModelWizardInitialObjectCreationPage {

		public PredefinedInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			setControl(composite);
		}

		protected boolean validatePage() {
			return true;
		}

		public void setVisible(boolean visible) {
			getControl().setVisible(visible);
		}

		public String getInitialObjectName() {
			return gmfGraphPackage.getCanvas().getName();
		}

		public String getEncoding() {
			return "UTF-8";
		}
	}

	public class GraphicalDefinitionPage extends DefinitionPage {

		public GraphicalDefinitionPage(String pageId, DomainModelSelectionPage domainModelSelectionPage) {
			super(pageId, domainModelSelectionPage);
		}

		protected boolean isDomainElementShown(Object element) {
			if (element instanceof EPackage) {
				return true;
			} else if (element instanceof EClass) {
				return true;
			} else if (element instanceof EStructuralFeature) {
				return true;
			}
			return false;
		}

		protected void processNewDomainModel(EPackage contents) {
			CheckboxTreeViewer viewer = getViewer();
			viewer.expandAll();
			viewer.setAllChecked(true);
		}

		public final CheckboxTreeViewer getViewer() {
			return (CheckboxTreeViewer) viewer;
		}
	}
}
