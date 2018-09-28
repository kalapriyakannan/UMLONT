/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.handlers.CommonDescriptorLabelProvider;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.handler.IServiceDescriptor;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;

/**
 * Present a dialog to select a type of interface to create.
 * 
 */
public class NewServiceDialog extends ElementListSelectionDialog {

	private IInterfaceHandlerService handlerService;
	private IServiceDescriptor[] availableServices;
	private EClass serviceType;

	protected NewServiceDialog(Shell parent) {
		super(parent, new CommonDescriptorLabelProvider());
		setTitle(Messages.SELECT_INTERFACE_TECHNOLOGY_TITLE);
		setMessage(Messages.SELECT_INTERFACE_TECHNOLOGY_MESSAGE);

	}

	/**
	 * Create a NewInterfaceDialog pre-populated with provided Interfaces. If the list of options has
	 * only one possible interface to select, the dialog will not be presented, and the default
	 * interface handler will be returned.
	 * 
	 * @param parent
	 *           A Shell to parent the new dialog from.
	 * @param managementService
	 *           The {@link IInterfaceHandlerService} that should manage any created
	 *           {@link AbstractInterfaceHandler handlers}.
	 */
	public NewServiceDialog(Shell parent, IInterfaceHandlerService managementService) {
		this(parent);
		Assert.isNotNull(managementService);
		handlerService = managementService;
		init();
	}

	private void init() {
		if (availableServices == null) {
			availableServices = handlerService.findAvailableServices();
		}

		setElements(availableServices);
	}

	@Override
	public int open() {
		if (availableServices.length > 1) {
			serviceType = null;
			return super.open();
		}
		return Window.OK;
	}

	public EClass resolveSelectedServiceType() {
		if (serviceType == null) {
			if (getFirstResult() != null) {
				serviceType = ((IServiceDescriptor) getFirstResult()).resolveType();
			} else if (availableServices.length == 1) {
				serviceType = availableServices[0].resolveType();
			}
		}
		return serviceType;
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_NEW_SERVICE_DIALOG);
		return super.createDialogArea(parent);

	}
}
