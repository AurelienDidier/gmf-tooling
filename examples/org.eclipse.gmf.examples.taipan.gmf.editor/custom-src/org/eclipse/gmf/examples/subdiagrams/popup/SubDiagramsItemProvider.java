package org.eclipse.gmf.examples.subdiagrams.popup;

import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.examples.subdiagrams.SubDiagramManager;
import org.eclipse.gmf.examples.subdiagrams.SubDiagramManagerImpl;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchPage;

public class SubDiagramsItemProvider extends AbstractContributionItemProvider implements IProvider {

	public static final String MENU_MANAGE_SUB_DIAGRAMS = "menu_manage_subdiagrams"; //$NON-NLS-1$

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_MANAGE_SUB_DIAGRAMS.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager("Open Sub Diagram");
		MenuBuilder builder = new MenuBuilder(partDescriptor);
		// XXX: build initial content -- otherwise menu is never shown
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	private class MenuBuilder implements IMenuListener {

		private final IWorkbenchPartDescriptor myWorkbenchPart;

		public MenuBuilder(IWorkbenchPartDescriptor workbenchPart) {
			myWorkbenchPart = workbenchPart;
		}

		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}

		public void buildMenu(IMenuManager manager) {
			manager.removeAll();
			DiagramEditPart selected = (DiagramEditPart) getSelectedObject(myWorkbenchPart);
			Diagram diagram = selected.getDiagramView();

			SubDiagramManager subsetManager = SubDiagramManagerImpl.findOrCreateSubsetManager(diagram);
			SubDiagramSupport support = subsetManager.getSubDiagramSupport();
			if (support == null) {
				return;
			}

			SubDiagramSpec thisSpec = support.findDiagramSpec(diagram);
			if (thisSpec == null) {
				return;
			}

			for (SubDiagramSpec nextSpec : support.getAllDiagrams()) {
				if (nextSpec == thisSpec) {
					continue;
				}
				OpenSubDiagramAction action = new OpenSubDiagramAction(getWorkbenchPage(), nextSpec);
				action.init();
				manager.add(action);
			}

			manager.add(new Separator());

			CreateSubDiagramAction createNew = new CreateSubDiagramAction(getWorkbenchPage(), thisSpec, support);
			createNew.init();
			manager.add(createNew);
		}

		private IWorkbenchPage getWorkbenchPage() {
			return myWorkbenchPart.getPartPage();
		}
	}

}