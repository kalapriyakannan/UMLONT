/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui.actions;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.collation.platform.model.AttributeNotSetException;
import com.collation.platform.model.topology.meta.ObjectClass;
import com.ibm.ccl.soa.deploy.cmdb.ui.ICmdbUIHelpContextIds;
import com.ibm.ccl.soa.deploy.cmdb.ui.provider.CmdbTreeViewUtils;

/**
 * Dialog for showing a list of CDM Types and letting the user search and select one.
 * 
 * @author Bill Arnold
 */
public class FindCDMTypeDialog extends ElementListSelectionDialog {

	/**
	 * @param parent
	 * @param title
	 */
	public FindCDMTypeDialog(Shell parent, String title) {
		super(parent, getLabelProvider(parent.getFont()));

		setTitle(title);
		setHelpAvailable(false);
	}

	private static ILabelProvider getLabelProvider(Font f) {
		return new CDMMetadataLabelProvider();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				ICmdbUIHelpContextIds.FindCDMTypeDialog_HelpContextID);
		return super.createDialogArea(parent);

	}
	
	private static class CDMMetadataLabelProvider extends LabelProvider {

		public Image getImage(Object element) {
			return null;
		}

		@Override
		public String getText(Object element) {
			assert element instanceof ObjectClass;
			try {
//				return ((ObjectClass)element).getDisplayString();
				String className = ((ObjectClass)element).getName();
				// TODO or perhaps just classname?
				return CmdbTreeViewUtils.shortClassName(className);
			} catch (AttributeNotSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return element.toString();
		}

		@Override
		public void dispose() {
			// TODO Anything here?
		}
	}
	
} // end class FindCDMTypeDialog
