/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.NewInterfaceDialog;
import com.ibm.ccl.soa.deploy.core.ui.composites.NewServiceDialog;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * @since 1.0
 * @deprecated
 * 
 */
public class CreateNubCommand extends DeployTransactionalCommand {

	private static final String DEFAULT_VERSION = "1.0.0"; //$NON-NLS-1$
	private SoftwareComponent component = null;
	private CreateElementRequest ceRequest = null;
	private GraphicalEditPart host = null;

	/**
	 * @param editingDomain
	 * @param createRequest
	 * @param hostEditPart
	 * @param componentToEdit
	 */
	public CreateNubCommand(TransactionalEditingDomain editingDomain,
			CreateElementRequest createRequest, GraphicalEditPart hostEditPart,
			SoftwareComponent componentToEdit) {
		super(editingDomain, "Create Nub Command", getAllWorkspaceFiles(hostEditPart)); //$NON-NLS-1$
		Assert.isNotNull(createRequest);
		Assert.isNotNull(hostEditPart);
		Assert.isNotNull(componentToEdit);
		ceRequest = createRequest;
		host = hostEditPart;
		component = componentToEdit;
		setResult(CommandResult.newOKCommandResult(null));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		Shell shell = host.getViewer().getControl().getShell();

		IInterfaceHandlerService handlerService = DeployCoreUIPlugin.getDefault()
				.getInterfaceHandlerService();
		/*
		 * first we create the service/reference
		 */
		DeployModelObject dmo = null;
		IElementType type = ceRequest.getElementType();
		if (type == DeploySemanticType.getComponentReferenceElementType()) {
			dmo = createNubHelper(type, CorePackage.eINSTANCE.getDeployCoreRoot_Reference(),
					"reference"); //$NON-NLS-1$
		} else {
			dmo = createNubHelper(type, CorePackage.eINSTANCE.getDeployCoreRoot_Service(), "service"); //$NON-NLS-1$
		}

		EClass serviceType = null;
		/*
		 * if we're creating a reference, prompt user for dmoType
		 */
		if (type == DeploySemanticType.getComponentReferenceElementType()) {

			NewServiceDialog selection = new NewServiceDialog(shell, handlerService);

			if (selection.open() == Window.OK) {
				serviceType = selection.resolveSelectedServiceType();
				// now set the dmo type
				Reference reference = (Reference) dmo;
				reference.setDmoEType(serviceType);
			} else {
				throw new ExecutionException(
						Messages.CreateNubCommand_The_creation_was_cancelled_at_the_r_);
			}
		}

		/*
		 * next we create the interface for this service/reference
		 */

		// get interfaces supported by SAF extension plugins
		// try to get one of them to create interface based on the service we just created
		Interface interfaze = null;

		NewInterfaceDialog selection = new NewInterfaceDialog(shell, handlerService, serviceType);
		if (selection.open() == Window.OK) {

			interfaze = selection.createSelectedInterface();
		} else {
			throw new ExecutionException(
					Messages.CreateNubCommand_The_creation_was_cancelled_at_the_r_);
		}

		// now stuff interface in new service/reference
		if (interfaze != null) {
			if (dmo instanceof Service) {
				((Service) dmo).setInterface(interfaze);
			} else {
				((Reference) dmo).setInterface(interfaze);
			}
		} else {
			throw new ExecutionException(
					Messages.CreateNubCommand_The_creation_was_cancelled_at_the_r_);
		}

		// now allow user to stuff values into new interface
		AbstractUIHandler uihandler = DeployCoreUIPlugin.getDefault().getInterfaceUIHandlerService()
				.findUIHandlerForSubstitutable(interfaze);
		try {
			if (!uihandler.editSubstitutable(host.getViewer().getControl().getShell(), dmo, interfaze,
					true)) {
				throw new ExecutionException(
						Messages.CreateNubCommand_The_creation_was_cancelled_at_the_r_);
			}
		} catch (SAFException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}

		return CommandResult.newOKCommandResult();
	}

	private DeployModelObject createNubHelper(IElementType type, EReference reference, String prefix) {
		EClass eClass = type.getEClass();
		//Check for an affiliation for the given reference.
		//The passed reference will be a reference to an element on the Document Root.
		EReference affiliation = (EReference) ExtendedMetaData.INSTANCE.getAffiliation(component
				.eClass(), reference);
		EReference featureToUse = affiliation != null ? affiliation : reference;
		DeployModelObject nubDMO = (DeployModelObject) EMFCoreUtil.create(component, featureToUse,
				eClass);
		nubDMO.setName(UnitUtil.generateUniqueName(component, prefix));

		if (CorePackage.eINSTANCE.getService().isSuperTypeOf(eClass)) {
			Service service = (Service) nubDMO;
			service.setVersion(DEFAULT_VERSION);
			service.setDisplayName(service.getName());
		}

		return nubDMO;
	}

	public boolean canExecute() {
		return true;
	}

}
