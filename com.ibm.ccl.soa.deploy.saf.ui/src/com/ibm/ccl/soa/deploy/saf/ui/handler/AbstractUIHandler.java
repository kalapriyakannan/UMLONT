/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.saf.ui.handler;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.IWizardRegistry;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;

/**
 * This class provides a common interface for all UI handlers contributed to the framework.
 * 
 * @see IUIHandlerService
 */
public abstract class AbstractUIHandler {

	protected String kind = null;

	private String name = null;
	private String description = null;

	/**
	 * The IDescriptionProvider maps an interface object to an optional image and optional text
	 * string used to display the element in the viewer's control.
	 */
	public abstract class AbstractDescriptionProvider {

		/**
		 * Returns the name for the label of the given interface object.
		 * 
		 * @param interfaceObject
		 *           the interface object whose label is required
		 * @return interface object name
		 */
		public abstract String getName(Object interfaceObject);

		/**
		 * Returns the name of the qualifier for the label of the given interface object.
		 * 
		 * @param interfaceObject
		 *           the interface object whose label is required
		 * @return qualifier name
		 */
		public abstract String getQualifier(Object interfaceObject);

		/**
		 * Returns the {@link Image} for the label of the given interface object.
		 * 
		 * @param interfaceObject
		 *           the interface object whose label is required
		 * @return interface image {@link Image}
		 */
		public abstract Image getObjectImage(Object interfaceObject);

		/**
		 * Returns the {@link Image} for the location label of the given interface object.
		 * 
		 * @param interfaceObject
		 *           the interface object whose label is required
		 * @return interface location image {@link Image}
		 */
		public abstract Image getContainerImage(Object interfaceObject);

		/**
		 * Returns the IFile containing the given interface object.
		 * 
		 * @param interfaceObject
		 *           the interface object whose file is required
		 * @return IFile
		 */
		public abstract IFile getFile(Object interfaceObject);

	}

	/**
	 * This method returns the handler's instance of
	 * {@link AbstractUIHandler.AbstractDescriptionProvider}. .
	 * 
	 * @return the {@link AbstractUIHandler.AbstractDescriptionProvider} instance
	 */
	public AbstractDescriptionProvider getDescriptionProvider() {
		return null;
	}

	/**
	 * @param aKind
	 * 
	 * @param aName
	 * @param aDescription
	 * 
	 */
	final public void initialize(String aKind, String aName, String aDescription) {
		kind = aKind;

		name = aName;
		description = aDescription;

	}

	/**
	 * Returns a string corresponding to a implementation, binding, or interface kind. This string
	 * acts as an identifier for a implementation, binding, or interface handler (the handler
	 * registered to process the specified kind).
	 * 
	 * For example, in case of java implementation, getKind() will return 'implementation.java'.
	 * 
	 * @return the QName string of the implementation kind of a component, or the binding kind of an
	 *         reference or service, or an interface kind of an SCA interface
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * Returns a name for the component, reference, service, or interface kind. This string is
	 * intended to be suitable for display to an end user.
	 * 
	 * @return the name of the implementation kind of a component, or the binding kind of an external
	 *         service or entry point, or the interface kind of an SCA interface.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns text that describes the component, reference, service, or interface kind. This string
	 * is intended to be suitable for display to an end user.
	 * 
	 * @return the description for the implementation kind of a component, or the binding kind of an
	 *         external service or entry point, or the interface kind of an SCA interface
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns <code>true</code> if the handler can provide a UI for the object.
	 * 
	 * @param obj
	 *           an object to show in a user interface
	 * 
	 * @return <code>true</code> if the handler can provide a UI for the object.
	 */
	abstract public boolean isUIHandlerForObject(Substitutable obj);

	/**
	 * This method returns true if this handler can open the given interface, or false otherwise.
	 * 
	 * <p>
	 * The default implementation is to return true.
	 * </p>
	 * 
	 * @param substitutableObj
	 *           An interface that the user may ask the handler to open.
	 * @throws SAFException
	 *            An unexpected exception occurred.
	 * @exception InvalidOperationException
	 *               The interface cannot be opened.
	 * @return True if this handler can open the given interface or false otherwise.
	 */
	public boolean canOpen(Substitutable substitutableObj) {
		return isUIHandlerForObject(substitutableObj);
	}

	/**
	 * Creates a new interface object to be used by an SCA interface. Also, the IUIContext is
	 * optionally used by this method to display the corresponding wizard used to create the new
	 * interface object.
	 * 
	 * @param defaultLocation
	 *           the default container to use when creating the interface
	 * @param shell
	 *           callback object that the handler can use to obtain additional information needed to
	 *           create the interface object
	 * @return the new Substitutable object
	 * @exception SAFException
	 *               An unexpected exception occurred.
	 * @exception InvalidOperationException
	 *               The interface object cannot be created.
	 * @exception InterruptedException
	 *               The caller did not provide a callback object needed by the handler, or the
	 *               callback request was canceled or aborted.
	 */
	public Object createNewSubstitutableObject(IContainer defaultLocation, Shell shell)
			throws SAFException, InvalidOperationException {
		WizardShortcutAction action = getCreationAction(null);
		if (action != null) {
			action.run();
		}
		return null;
	}

	/**
	 * This method opens a registered editor for the given interface type.
	 * 
	 * @param substitutableObj
	 *           the substitutable to open
	 * @throws SAFException
	 *            An unexpected exception occurred.
	 * @exception InvalidOperationException
	 *               The interface cannot be opened.
	 */
	public abstract void open(Substitutable substitutableObj) throws SAFException,
			InvalidOperationException;

	/**
	 * Present the user with some means to edit the contents of the interface.
	 * 
	 * @param shell
	 *           A parent shell to use if any windows are opened
	 * @param dmo
	 *           The dmo that contains the interface
	 * @param substitutable
	 *           The interface undergoing changes
	 * @param isEditNubDmo
	 * @return True if the interface was edited.
	 */
	public abstract boolean editSubstitutable(Shell shell, DeployModelObject dmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException;

	public WizardShortcutAction getCreationAction(IWorkbenchWindow window) {
		WizardShortcutAction action = null;
		if (window == null) {
			window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		}

		if (window == null || window.getShell() == null || window.getShell().isDisposed()) {
			return null;
		}

		String wizardId = getWizardId();
		if (wizardId == null || wizardId.trim().length() == 0) {
			return null;
		}

		IWizardRegistry wizardRegistry = PlatformUI.getWorkbench().getNewWizardRegistry();
		IWizardDescriptor descriptor = wizardRegistry.findWizard(getWizardId());
		if (descriptor != null) {
			action = new WizardShortcutAction(window, descriptor);
		}

		return action;
	}

	public String getWizardId() {
		return null;
	}
}
