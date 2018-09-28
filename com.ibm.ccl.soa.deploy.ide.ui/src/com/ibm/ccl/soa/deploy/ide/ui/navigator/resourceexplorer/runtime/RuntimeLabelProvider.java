/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.wst.server.ui.internal.viewers.RuntimeTreeLabelProvider;

import com.ibm.ccl.soa.deploy.ide.ui.IDEUIPlugin;
import com.ibm.ccl.soa.deploy.ide.ui.Messages;

public class RuntimeLabelProvider extends LabelProvider implements ICommonLabelProvider {
	private static final Image RUNTIME_IMAGE = IDEUIPlugin.getImageDescriptor(
			"icons/cview16/servers_view.gif").createImage(); //$NON-NLS-1$

	private static final Image ATTRIBUTE_IMAGE = IDEUIPlugin
			.getImageDescriptor("icons/getnew.gif").createImage(); //$NON-NLS-1$

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private RuntimeTreeLabelProvider delegateLabelProvider = new RuntimeTreeLabelProvider();

	public void init(ICommonContentExtensionSite aConfig) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento aMemento) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento aMemento) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IDescriptionProvider#getDescription(java.lang.Object)
	 */
	public String getDescription(Object anElement) {
		return getText(anElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element instanceof IWorkspaceRoot)
			return null;
		if (element instanceof String)
			return ATTRIBUTE_IMAGE;
		if (element instanceof ApplicationServerNode)
			return RUNTIME_IMAGE;
		return delegateLabelProvider.getColumnImage(element, 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof IWorkspaceRoot)
			return EMPTY_STRING;
		if (element instanceof ApplicationServerNode)
			return ((ApplicationServerNode) element).getName();
		if (element instanceof String)
			return (String) element;
		if (element instanceof AuthProviderServerNode)
			return ((AuthProviderServerNode) element).getName();
		String message = NLS.bind(Messages.APPLICATION_SERVER_LABEL, new Object[] {
				delegateLabelProvider.getColumnText(element, 0),
				delegateLabelProvider.getColumnText(element, 1) });
		return message;
	}

}
