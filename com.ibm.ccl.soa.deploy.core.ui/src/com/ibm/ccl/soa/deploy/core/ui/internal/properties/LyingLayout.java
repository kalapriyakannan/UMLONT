/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * Tell caller whatever it wants to hear. This layout may be used as a block to an upstream
 * {@link ScrolledComposite} where you wish to block the scrolling functionality but you are unable
 * to change the composite itself.
 */
public class LyingLayout extends Layout {

	/** Tell caller whatever it wants to hear */
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		int width = 0;
		int height = 0;
		if (wHint != SWT.DEFAULT) {
			width = wHint;
		}
		if (hHint != SWT.DEFAULT) {
			height = hHint;
		}

		return new Point(width, height);
	}

	protected void layout(Composite composite, boolean flushCache) {
		if (composite.isDisposed()) {
			return;
		}

//			printAllChildren(0, composite);

		Control[] children = composite.getChildren();
		Rectangle clientArea = composite.getClientArea();
		for (int i = 0; i < children.length; i++) {
			if (!children[i].isDisposed()) {
				children[i].setBounds(clientArea);
			}
		}
	}

}