/*
 *  Copyright (c) 2006, 2009 Borland Software Corporation and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class GMFGraphEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (GMFGraphVisualIDRegistry.getVisualID(view)) {

			case CanvasEditPart.VISUAL_ID:
				return new CanvasEditPart(view);

			case CompartmentEditPart.VISUAL_ID:
				return new CompartmentEditPart(view);

			case CompartmentNameEditPart.VISUAL_ID:
				return new CompartmentNameEditPart(view);

			case NodeEditPart.VISUAL_ID:
				return new NodeEditPart(view);

			case NodeNameEditPart.VISUAL_ID:
				return new NodeNameEditPart(view);

			case ConnectionEditPart.VISUAL_ID:
				return new ConnectionEditPart(view);

			case ConnectionNameEditPart.VISUAL_ID:
				return new ConnectionNameEditPart(view);

			case FigureGalleryEditPart.VISUAL_ID:
				return new FigureGalleryEditPart(view);

			case FigureGalleryNameEditPart.VISUAL_ID:
				return new FigureGalleryNameEditPart(view);

			case DiagramLabelEditPart.VISUAL_ID:
				return new DiagramLabelEditPart(view);

			case DiagramLabelNameEditPart.VISUAL_ID:
				return new DiagramLabelNameEditPart(view);

			case FigureDescriptorEditPart.VISUAL_ID:
				return new FigureDescriptorEditPart(view);

			case FigureDescriptorNameEditPart.VISUAL_ID:
				return new FigureDescriptorNameEditPart(view);

			case RectangleEditPart.VISUAL_ID:
				return new RectangleEditPart(view);

			case Rectangle2EditPart.VISUAL_ID:
				return new Rectangle2EditPart(view);

			case EllipseEditPart.VISUAL_ID:
				return new EllipseEditPart(view);

			case RoundedRectangleEditPart.VISUAL_ID:
				return new RoundedRectangleEditPart(view);

			case PolylineEditPart.VISUAL_ID:
				return new PolylineEditPart(view);

			case PointEditPart.VISUAL_ID:
				return new PointEditPart(view);

			case PolygonEditPart.VISUAL_ID:
				return new PolygonEditPart(view);

			case LabelEditPart.VISUAL_ID:
				return new LabelEditPart(view);

			case LabelTextEditPart.VISUAL_ID:
				return new LabelTextEditPart(view);

			case Ellipse2EditPart.VISUAL_ID:
				return new Ellipse2EditPart(view);

			case RoundedRectangle2EditPart.VISUAL_ID:
				return new RoundedRectangle2EditPart(view);

			case Polyline2EditPart.VISUAL_ID:
				return new Polyline2EditPart(view);

			case Polygon2EditPart.VISUAL_ID:
				return new Polygon2EditPart(view);

			case Label2EditPart.VISUAL_ID:
				return new Label2EditPart(view);

			case LabelText2EditPart.VISUAL_ID:
				return new LabelText2EditPart(view);

			case Rectangle3EditPart.VISUAL_ID:
				return new Rectangle3EditPart(view);

			case Ellipse3EditPart.VISUAL_ID:
				return new Ellipse3EditPart(view);

			case RoundedRectangle3EditPart.VISUAL_ID:
				return new RoundedRectangle3EditPart(view);

			case Polyline3EditPart.VISUAL_ID:
				return new Polyline3EditPart(view);

			case Polygon3EditPart.VISUAL_ID:
				return new Polygon3EditPart(view);

			case Label3EditPart.VISUAL_ID:
				return new Label3EditPart(view);

			case LabelText3EditPart.VISUAL_ID:
				return new LabelText3EditPart(view);

			case CompartmentVisualFacetsEditPart.VISUAL_ID:
				return new CompartmentVisualFacetsEditPart(view);

			case NodeVisualFacetsEditPart.VISUAL_ID:
				return new NodeVisualFacetsEditPart(view);

			case ConnectionVisualFacetsEditPart.VISUAL_ID:
				return new ConnectionVisualFacetsEditPart(view);

			case FigureGalleryFiguresEditPart.VISUAL_ID:
				return new FigureGalleryFiguresEditPart(view);

			case DiagramLabelVisualFacetsEditPart.VISUAL_ID:
				return new DiagramLabelVisualFacetsEditPart(view);

			case ChildAccessEditPart.VISUAL_ID:
				return new ChildAccessEditPart(view);

			case CompartmentAccessorEditPart.VISUAL_ID:
				return new CompartmentAccessorEditPart(view);

			case DiagramLabelAccessorEditPart.VISUAL_ID:
				return new DiagramLabelAccessorEditPart(view);

			case NodeContentPaneEditPart.VISUAL_ID:
				return new NodeContentPaneEditPart(view);

			case DiagramElementFigureEditPart.VISUAL_ID:
				return new DiagramElementFigureEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
