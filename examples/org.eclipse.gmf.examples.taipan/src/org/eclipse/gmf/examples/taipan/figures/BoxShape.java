/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.figures;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;

/**
 * @author dstadnik
 */
public class BoxShape extends ScalableImageFigure {

	public BoxShape() {
		super(
				RenderedImageFactory.getInstance(FileLocator.find(
						Platform.getBundle("org.eclipse.gmf.examples.taipan"), //$NON-NLS-1$
						new Path("images/box.svg"), //$NON-NLS-1$
						null)),
				true, true, true);
	}
}
