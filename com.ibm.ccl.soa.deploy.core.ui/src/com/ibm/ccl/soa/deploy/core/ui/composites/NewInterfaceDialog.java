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

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.handlers.CommonDescriptorLabelProvider;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.handler.IInterfaceDescriptor;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;

/**
 * Present a dialog to select a type of interface to create.
 * 
 */
public class NewInterfaceDialog extends ElementListSelectionDialog {

	private IInterfaceHandlerService handlerService;
	private IInterfaceDescriptor[] availableInterfaces;
	private AbstractInterfaceHandler selectedHandler;
	private EClass serviceType;

	protected NewInterfaceDialog(Shell parent) {
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
	 * @param options
	 *           A list of {@link IInterfaceDescriptor interfaces} the user may choose from.
	 */
	public NewInterfaceDialog(Shell parent, IInterfaceHandlerService managementService,
			IInterfaceDescriptor[] options) {
		this(parent);
		Assert.isNotNull(managementService);
		Assert.isNotNull(options);
		availableInterfaces = options;
		handlerService = managementService;
		init();
	}

	/**
	 * Create a NewInterfaceDialog pre-populated with Interfaces that are available for the given
	 * Service Type. If the service has only one possible interface to select, the dialog will not be
	 * presented, and the default interface handler will be returned.
	 * 
	 * @param parent
	 *           A Shell to parent the new dialog from.
	 * @param managementService
	 *           The {@link IInterfaceHandlerService} that should manage any created
	 *           {@link AbstractInterfaceHandler handlers}.
	 * @param editedServiceType
	 *           The {@link EClass} of the {@link Service} that will hold the interface created.
	 */
	public NewInterfaceDialog(Shell parent, IInterfaceHandlerService managementService,
			EClass editedServiceType) {
		this(parent);
		Assert.isNotNull(managementService);
		Assert.isNotNull(editedServiceType);
		handlerService = managementService;
		serviceType = editedServiceType;
		init();
	}

	private void init() {
		if (availableInterfaces == null) {
			availableInterfaces = handlerService.findInterfaceDescriptorsForService(serviceType);
		}

		setElements(availableInterfaces);
	}

	@Override
	public int open() {
		if (availableInterfaces.length > 1) {
			selectedHandler = null;
			return super.open();
		}
		return Window.OK;
	}

	/**
	 * Return the selected {@link AbstractInterfaceHandler} that can work with the type of interface
	 * selected by the user.
	 * 
	 * @return The selected {@link AbstractInterfaceHandler} that can work with the type of interface
	 *         selected by the user.
	 * @see #createSelectedInterface()
	 */
	public AbstractInterfaceHandler getSelectedHandler() {

		if (selectedHandler == null) {
			if (getFirstResult() != null) {
				selectedHandler = handlerService
						.getInterfaceHandler((IInterfaceDescriptor) getFirstResult());
			} else if (availableInterfaces.length == 1) {
				selectedHandler = handlerService.getInterfaceHandler(availableInterfaces[0]);
			}
		}
		return selectedHandler;
	}

	/**
	 * Create an Interface of the type that was selected by the user.
	 * 
	 * @return A newly created Interface of the type that was selected by the user.
	 */
	public Interface createSelectedInterface() {

		Interface interfaze = null;
		try {
			if (getSelectedHandler() != null) {
				interfaze = getSelectedHandler().createInterfaceForService(serviceType);
			}
		} catch (SAFException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		} catch (InvalidOperationException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}
		return interfaze;
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_NEW_INTERFACE_DIALOG);
		return super.createDialogArea(parent);

	}
}
