/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;

/**
 * Factory used for creating common SWT widgets.
 * 
 */
public class DeployUIWidgetFactory {

	/**
	 * The singleton instance of the widget factory.
	 */
	public static DeployUIWidgetFactory INSTANCE = new DeployUIWidgetFactory();

	private String closeLabel;

	private static final class CloseHyperLinkListener implements IHyperlinkListener {
		private final Window window;

		private CloseHyperLinkListener(Window aWindow) {
			window = aWindow;
		}

		public void linkExited(HyperlinkEvent e) {
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkActivated(HyperlinkEvent e) {
			window.close();
		}
	}

	private static final class RunnableHyperLinkListener implements IHyperlinkListener {
		private final Window window;
		private final Runnable runnable;
		private final boolean shouldCloseOnExecute;

		private RunnableHyperLinkListener(Runnable aRunnable, Window aWindow, boolean closeOnExecute) {
			window = aWindow;
			runnable = aRunnable;
			shouldCloseOnExecute = closeOnExecute;
		}

		public void linkExited(HyperlinkEvent e) {
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkActivated(HyperlinkEvent e) {
			runnable.run();
			if (shouldCloseOnExecute) {
				window.close();
			}
		}
	}

	/**
	 * @see DeployUIWidgetFactory#INSTANCE
	 */
	protected DeployUIWidgetFactory() {
		super();
	}

	private String getCloseLabel() {
		if (closeLabel == null) {
			closeLabel = IDialogConstants.CLOSE_LABEL;
			char first = closeLabel.charAt(0);
			if (first == '&') {
				closeLabel = closeLabel.substring(1);
			}
		}
		return closeLabel;
	}

	/**
	 * 
	 * @param parent
	 * @param numColumns
	 * @return a {@link Composite}
	 */
	public Composite createModifiedDialogStatusBar(Composite parent, int numColumns) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setBackgroundMode(SWT.INHERIT_DEFAULT);

		GridLayout gl = new GridLayout(numColumns, false);
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		gl.verticalSpacing = 0;
		comp.setLayout(gl);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		comp.setBackground(parent.getShell().getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_LIGHT_SHADOW));
		return comp;
	}

	/**
	 * Create a "Close" hyperlink that will close the passed window when selected.
	 * 
	 * @param parent
	 * @param aWindow
	 * @return {@link Control}
	 */
	public Control createCloseHyperlink(Composite parent, Window aWindow) {
		return createCloseHyperlink(parent, true, aWindow);
	}

	/**
	 * Create a "Close" hyperlink that will close the passed window when selected.
	 * 
	 * @param parent
	 * @param shouldGrabHorizontal
	 * @param aWindow
	 * @return {@link Control}
	 */
	public Control createCloseHyperlink(Composite parent, boolean shouldGrabHorizontal,
			Window aWindow) {
		return createCloseHyperlink(parent, getCloseLabel(), shouldGrabHorizontal, aWindow);
	}

	/**
	 * Create a "Close" hyperlink that will close the passed window when selected.
	 * 
	 * @param parent
	 * @param text
	 *           The text to appear for the hyperlink.
	 * @param shouldGrabHorizontal
	 * @param aWindow
	 * @return {@link Control}
	 */
	public Control createCloseHyperlink(Composite parent, String text, boolean shouldGrabHorizontal,
			Window aWindow) {
		Hyperlink closeLink = new Hyperlink(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(shouldGrabHorizontal, false).align(SWT.RIGHT,
				SWT.BEGINNING).applyTo(closeLink);
		closeLink.setUnderlined(true);
		closeLink.setText(text);
		HyperlinkGroup group = new HyperlinkGroup(aWindow.getShell().getDisplay());
		group.add(closeLink);
		closeLink.addHyperlinkListener(new CloseHyperLinkListener(aWindow));
		return closeLink;
	}

	/**
	 * Create a "OK" hyperlink that will apply a set of changes and close the passed window when
	 * selected.
	 * 
	 * @param parent
	 *           A parent {@link Composite}.
	 * @param aRunnable
	 *           A {@link Runnable} that will be invoked when the hyperlink is selected.
	 * @param aWindow
	 *           The {@link Window} for the UI being constructed.
	 * @return {@link Control}
	 */
	public Control createOKHyperlink(Composite parent, Runnable aRunnable, Window aWindow) {
		Hyperlink okLink = new Hyperlink(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.BEGINNING).applyTo(
				okLink);
		okLink.setUnderlined(true);
		okLink.setText(IDialogConstants.OK_LABEL);
		HyperlinkGroup group = new HyperlinkGroup(aWindow.getShell().getDisplay());
		group.add(okLink);
		okLink.addHyperlinkListener(new RunnableHyperLinkListener(aRunnable, aWindow, true));
		return okLink;
	}

	/**
	 * @param parent
	 * @param aWindow
	 * @return A {@link Composite}
	 */
	public Composite createModifiedStatusBarWithClose(Composite parent, Window aWindow) {
		createHorizontalSeparator(parent);
		Composite statusBar = createModifiedDialogStatusBar(parent, 1);
		createCloseHyperlink(statusBar, aWindow);
		return statusBar;
	}

	/**
	 * Adds aComposite and all of its children and their chrildren to the list of controls.
	 * 
	 * @param aComposite
	 * @param controls
	 */
	public void addWithChildren(Composite aComposite, List<Control> controls) {
		if (aComposite != null) {
			controls.add(aComposite);
			addChildren(aComposite, controls);
		}
	}

	/**
	 * Adds the children of aComposite list of controls.
	 * 
	 * @param aComposite
	 * @param controls
	 */
	public void addChildren(Composite aComposite, List<Control> controls) {
		if (aComposite != null) {
			Control[] children = aComposite.getChildren();
			for (int i = 0; i < children.length; i++) {
				Control child = children[i];
				if (child instanceof Composite) {
					addWithChildren((Composite) child, controls);
				} else {
					controls.add(child);
				}
			}
		}
	}

	/**
	 * Create a horizontal separator for the given parent.
	 * 
	 * @param parent
	 *           The parent composite.
	 * @return The Control representing the horizontal separator.
	 */
	public Control createHorizontalSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.LINE_DOT);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(
				separator);
		return separator;
	}
}
