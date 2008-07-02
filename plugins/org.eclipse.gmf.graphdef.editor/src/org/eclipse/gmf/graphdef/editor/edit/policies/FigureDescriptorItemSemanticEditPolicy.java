/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.graphdef.editor.edit.commands.ChildAccessCreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.ChildAccessReorientCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.DiagramElementFigureCreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.DiagramElementFigureReorientCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.Ellipse2CreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.Label2CreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.Polygon2CreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.Polyline2CreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.RectangleCreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.commands.RoundedRectangle2CreateCommand;
import org.eclipse.gmf.graphdef.editor.edit.parts.ChildAccessEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.DiagramElementFigureEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Ellipse2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Label2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polygon2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.Polyline2EditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RectangleEditPart;
import org.eclipse.gmf.graphdef.editor.edit.parts.RoundedRectangle2EditPart;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphVisualIDRegistry;
import org.eclipse.gmf.graphdef.editor.providers.GMFGraphElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FigureDescriptorItemSemanticEditPolicy extends GMFGraphBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (GMFGraphElementTypes.Rectangle_3010 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureDescriptor_ActualFigure());
			}
			return getGEFWrapper(new RectangleCreateCommand(req));
		}
		if (GMFGraphElementTypes.Ellipse_3015 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureDescriptor_ActualFigure());
			}
			return getGEFWrapper(new Ellipse2CreateCommand(req));
		}
		if (GMFGraphElementTypes.RoundedRectangle_3016 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureDescriptor_ActualFigure());
			}
			return getGEFWrapper(new RoundedRectangle2CreateCommand(req));
		}
		if (GMFGraphElementTypes.Polyline_3017 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureDescriptor_ActualFigure());
			}
			return getGEFWrapper(new Polyline2CreateCommand(req));
		}
		if (GMFGraphElementTypes.Polygon_3024 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureDescriptor_ActualFigure());
			}
			return getGEFWrapper(new Polygon2CreateCommand(req));
		}
		if (GMFGraphElementTypes.Label_3027 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(GMFGraphPackage.eINSTANCE.getFigureDescriptor_ActualFigure());
			}
			return getGEFWrapper(new Label2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (GMFGraphVisualIDRegistry.getVisualID(node)) {
			case RectangleEditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case Ellipse2EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case RoundedRectangle2EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case Polyline2EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case Polygon2EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case Label2EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (GMFGraphElementTypes.ChildAccess_4002 == req.getElementType()) {
			return getGEFWrapper(new ChildAccessCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (GMFGraphElementTypes.DiagramElementFigure_4005 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (GMFGraphElementTypes.ChildAccess_4002 == req.getElementType()) {
			return null;
		}
		if (GMFGraphElementTypes.DiagramElementFigure_4005 == req.getElementType()) {
			return getGEFWrapper(new DiagramElementFigureCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ChildAccessEditPart.VISUAL_ID:
			return getGEFWrapper(new ChildAccessReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case DiagramElementFigureEditPart.VISUAL_ID:
			return getGEFWrapper(new DiagramElementFigureReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
