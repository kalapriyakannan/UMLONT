/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.ui.actions.FindUnitAction;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Dialog for showing a list of units and letting the user search and select one.
 * 
 * @author Ed Snible
 * @see FindUnitAction
 */
public class FindUnitDialog extends ElementListSelectionDialog {

	/**
	 * @param parent
	 * @param title
	 */
	public FindUnitDialog(Shell parent, String title) {
		super(parent, getLabelProvider(parent.getFont()));

		//		setTitle(Messages.FIND_UNIT);
		setTitle(title);
		setHelpAvailable(false);

		//		setElements(PropertyUtils.getUnitsInTopologyForSemantic(top).toArray());
	}

	private static ILabelProvider getLabelProvider(Font f) {
		// Unfortunately, ElementListSelectionDialog doesn't know about IFontProvider, because it uses
		// Table directly and not TableViewer.  I can't
		// wedge in WrappedViewerLabelProvider because it's package-private to org.eclipse.jface.viewers,
		// so there is no way to get italics...
		return new TopologyOutlinePopup.ItalicizingTopologyLabelProvider(f);
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_FIND_DIALOG);
		return super.createDialogArea(parent);

	}
	//	static private class FindUnitRenderer extends LabelProvider {
	//
	//		public Image getImage(Object element) {
	//			if (element instanceof EObject) {
	//				return IconService.getInstance().getIcon(new EObjectAdapter((EObject) element),
	//						IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
	//			}
	//
	//			return null;
	//		}
	//
	//		public String getText(Object element) {
	//			if (element instanceof Unit) {
	//				Unit unit = (Unit) element;
	//				return unit.titleWithContext();
	//			}
	//
	//			return element.getClass().getName();
	//		}
	//
	//	} // end inner class FindUnitRenderer
} // end class FindUnitDialog
