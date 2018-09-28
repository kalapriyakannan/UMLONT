/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * Override to deal with Config Contracts and Install states.
 * 
 * @author NKruk
 * 
 * TODO update to use corepackage.literals
 */
public class GeneralDmoSyncHelperModel extends DmoSyncHelperModel {
	private PropertyDescriptor[] installStates;

	/**
	 * Ctor
	 */
	public GeneralDmoSyncHelperModel() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.properties.DmoSyncHelperModel#getValidPropertyDescriptors(org.eclipse.emf.ecore.EStructuralFeature)
	 * 
	 * overridden to provide seperate implementations for install state and config contract
	 */
	public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature property) {
		if (CorePackage.Literals.UNIT__INIT_INSTALL_STATE == property
				|| CorePackage.Literals.UNIT__GOAL_INSTALL_STATE == property) {
			return getInstallDescriptors();
		}
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == property) {
			return getContractDescriptors();
		}

		return super.getValidPropertyDescriptors(property);
	}

	@Override
	public Object getProperty(EStructuralFeature property) {
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME == property) {
			return getCaption();
		}
		return super.getProperty(property);
	}

	private PropertyDescriptor[] getInstallDescriptors() {
		//Populate and cache descriptors
		if (installStates == null) {
			installStates = new PropertyDescriptor[9];
			// uninstalled > installed
			// installed > uninstalled
			// installed > installed
			// uninstalled > uninstalled
			// unknown > unknown
			// unknown > installed
			// unknown > uninstalled
			// installed > unknown
			// uninstalled > unknown
			String[] items = { Messages.GeneralDmoSyncHelperModel_uninstalled_installed_,
					Messages.GeneralDmoSyncHelperModel_installed_uninstalled_,
					Messages.GeneralDmoSyncHelperModel_installed_,
					Messages.GeneralDmoSyncHelperModel_uninstalled_,
					Messages.GeneralDmoSyncHelperModel_unknown_,
					Messages.GeneralDmoSyncHelperModel_unknown_installed_,
					Messages.GeneralDmoSyncHelperModel_unknown_uninstalled_,
					Messages.GeneralDmoSyncHelperModel_installed_unknown_,
					Messages.GeneralDmoSyncHelperModel_uninstalled_unknown_, };
			for (int i = 0; i < items.length; i++) {
				installStates[i] = new PropertyDescriptor(items[i], i);
			}
		}
		return installStates;
	}

	protected void doSetProperty(final EStructuralFeature property, final Object propertyValue) {
		if (CorePackage.Literals.UNIT__INIT_INSTALL_STATE == property
				|| CorePackage.Literals.UNIT__GOAL_INSTALL_STATE == property) {
			switch ((Integer) propertyValue)
			{
			case 0:
				// 0: uninstalled > installed
				setInstallState(InstallState.NOT_INSTALLED_LITERAL, InstallState.INSTALLED_LITERAL);
				break;
			case 1:
				// 1: installed > uninstalled
				setInstallState(InstallState.INSTALLED_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
				break;
			case 2:
				// 2: installed > installed
				setInstallState(InstallState.INSTALLED_LITERAL, InstallState.INSTALLED_LITERAL);
				break;
			case 3:
				// 3: uninstalled > uninstalled
				setInstallState(InstallState.NOT_INSTALLED_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
				break;
			case 4:
				// 4: unknown > unknown
				setInstallState(InstallState.UNKNOWN_LITERAL, InstallState.UNKNOWN_LITERAL);
				break;
			case 5:
				// 5: unknown > installed
				setInstallState(InstallState.UNKNOWN_LITERAL, InstallState.INSTALLED_LITERAL);
				break;
			case 6:
				// 6: unknown > uninstalled
				setInstallState(InstallState.UNKNOWN_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
				break;
			case 7:
				// 7: installed > unknown
				setInstallState(InstallState.INSTALLED_LITERAL, InstallState.UNKNOWN_LITERAL);
				break;
			case 8:
				// 8: uninstalled > unknown
				setInstallState(InstallState.NOT_INSTALLED_LITERAL, InstallState.UNKNOWN_LITERAL);
				break;
			}
		} else if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == property) {
			updateContract((Integer) propertyValue);
		} else if (CorePackage.Literals.UNIT__PUBLISH_INTENT == property) {
			boolean bol = ((Boolean) propertyValue).booleanValue();
			if (bol) {
				super.doSetProperty(property, PublishIntent.PUBLISH_LITERAL);
			} else {
				super.doSetProperty(property, PublishIntent.DO_NOT_PUBLISH_LITERAL);
			}

		} else {
			super.doSetProperty(property, propertyValue);
		}
	}

	/**
	 * Wraps Initial and Goal install state changes in a single operation
	 * 
	 * @param initialState
	 *           the new initial state
	 * @param goalState
	 *           the new goal state
	 */
	private void setInstallState(final Object initialState, final Object goalState) {
		AbstractEMFOperation op = new AbstractEMFOperation(TransactionUtil.getEditingDomain(dmo), NLS
				.bind(Messages.GeneralDmoSyncHelperModel_Set_the_initial_install_state_to_,
						new Object[] { initialState, goalState })) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				dmo.eSet(CorePackage.Literals.UNIT__INIT_INSTALL_STATE, initialState);
				dmo.eSet(CorePackage.Literals.UNIT__GOAL_INSTALL_STATE, goalState);
				return Status.OK_STATUS;
			}
		};
		LightweightOperationFactory.addUndoContext(op, dmo);
		try {
			scope.execute(op, ChangeScope.OPTION_DO_NOT_SAVE, new NullProgressMonitor());
		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.properties.DmoSyncHelperModel#isPropertyEnabled(org.eclipse.emf.ecore.EStructuralFeature)
	 * 
	 * Override to disable fields in the composite
	 */
	public boolean isPropertyEnabled(EStructuralFeature property) {
		//Do not allow changes to specific fields within an import
		if (dmo.getTopology() != null && !dmo.getTopology().equals(dmo.getEditTopology())) {
			if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == property
					|| CorePackage.Literals.UNIT__CONCEPTUAL == property
					|| CorePackage.Literals.UNIT__CONFIGURATION_UNIT == property) {
				return false;
			}
		}

		//Disable contract changes for non-explicit contracts
		//TODO this probably no longer applies since only explict contracts are used
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == property
				&& !(dmo.getTopology() != null && dmo.getTopology().getConfigurationContract() instanceof ExplicitContract)) {
			return false;
		}

		//Disable Caption if name is linked
		//if linked actual title will differ from caption provider
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME == property) {
			String cap = getCaption();
			if (!cap.equals(dmo.getDisplayName()) && !cap.equals(dmo.getName())) {
				return false;
			}
		}

		if (CorePackage.Literals.UNIT__CONCEPTUAL == property) {
			if (dmo instanceof ConceptualNode) {
				return false;
			}
		}

		//TODO Hack until an adequate solution is found for disabling the config flag
//		if (CorePackage.eINSTANCE.getUnit_ConfigurationUnit().equals(property)
//				&& !dmo.eClass().getName().equals("GenericUnit")) {
//			return false;
//		}

		return dmo.isPublicEditable();
	}

	//Only works with units
	private String getCaption() {
		if (dmo instanceof Unit) {
			return ((Unit) dmo).getCaptionProvider().title((Unit) dmo);
		}
		return ""; //$NON-NLS-1$
	}

	//Hack for publish checkbox until model changes
	public boolean getBooleanProperty(EStructuralFeature property) {
		if (CorePackage.Literals.UNIT__PUBLISH_INTENT == property) {
			PublishIntent temp = (PublishIntent) getProperty(property);
			if (temp.equals(PublishIntent.DO_NOT_PUBLISH_LITERAL)) {
				return false;
			}
			return true;
		}
		return super.getBooleanProperty(property);
	}

	public PropertyDescriptor getPropertyDescriptor(EStructuralFeature property) {
		if (CorePackage.Literals.UNIT__INIT_INSTALL_STATE == property
				|| CorePackage.Literals.UNIT__GOAL_INSTALL_STATE == property) {
			InstallState init = (InstallState) getProperty(CorePackage.Literals.UNIT__INIT_INSTALL_STATE);
			InstallState goal = (InstallState) getProperty(CorePackage.Literals.UNIT__GOAL_INSTALL_STATE);
			if (installStates == null) {
				getInstallDescriptors();
			}
			// TODO this design is error prone but was inherited ...
			// 0: uninstalled > installed
			// 1: installed > uninstalled
			// 2: installed > installed
			// 3: uninstalled > uninstalled
			// 4: unknown > unknown
			// 5: unknown > installed
			// 6: unknown > uninstalled
			// 7: installed > unknown
			// 8: uninstalled > unknown
			switch (init.getValue())
			{
			case InstallState.INSTALLED:
				switch (goal.getValue())
				{
				case InstallState.INSTALLED:
					return installStates[2];
				case InstallState.NOT_INSTALLED:
					return installStates[1];
				case InstallState.UNKNOWN:
					return installStates[7];
				}
				break;
			case InstallState.NOT_INSTALLED:
				switch (goal.getValue())
				{
				case InstallState.INSTALLED:
					return installStates[0];
				case InstallState.NOT_INSTALLED:
					return installStates[3];
				case InstallState.UNKNOWN:
					return installStates[8];
				}
				break;
			case InstallState.UNKNOWN:
				switch (goal.getValue())
				{
				case InstallState.INSTALLED:
					return installStates[5];
				case InstallState.NOT_INSTALLED:
					return installStates[6];
				case InstallState.UNKNOWN:
					return installStates[4];
				}
				break;

			}
			if (goal.getValue() == InstallState.INSTALLED) {
				if (init.getValue() == InstallState.NOT_INSTALLED) {
					return installStates[1];
				}
				if (init.getValue() == InstallState.UNKNOWN) {
					return installStates[3];
				}
			} else if (goal.getValue() == InstallState.NOT_INSTALLED) {
				if (init.getValue() == InstallState.INSTALLED) {
					return installStates[0];
				}
				if (init.getValue() == InstallState.UNKNOWN) {
					return installStates[2];
				}
			} else if (goal.getValue() == InstallState.UNKNOWN
					&& init.getValue() == InstallState.INSTALLED) {
				return installStates[4];
			}
			if (init.getValue() == InstallState.NOT_INSTALLED) {
				return installStates[5];
			}
			return installStates[6];
		} else if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == property) {
			ConfigurationContract contract = dmo.getTopology() == null ? null : dmo.getTopology()
					.getConfigurationContract();
			if (contractStates == null) {
				getContractDescriptors();
			}
			if (contract == null) {
				return contractStates[2]; // if there is no contract, consider everything private
			} else if (contract.isPublicEditable(dmo)) {
				return contractStates[0];
			} else if (contract.isPublic(dmo)) {
				return contractStates[1];
			} else {
				return contractStates[2];
			}
		}
		return super.getPropertyDescriptor(property);
	}

	public Image getPropertyImage(EStructuralFeature property) {

		//Image for contract state
		if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == property) {
			Topology top = dmo.getEditTopology();
			if (top != null) {
				ConfigurationContract contract = top.getConfigurationContract();
				if (contract != null) {
					if (contract.isPublicEditable(dmo)) {
						//Return public editable image.
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
					}
					if (contract.isPublic(dmo)) {
						//Return public image.
						return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PUBLIC);
					}
					//Return private image.
					return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
							ISharedImages.IMG_CONTRACT_PRIVATE);
				}
			}
		}

		if (CorePackage.Literals.UNIT__INIT_INSTALL_STATE == property
				|| CorePackage.Literals.UNIT__GOAL_INSTALL_STATE == property) {
			InstallState init = (InstallState) getProperty(CorePackage.Literals.UNIT__INIT_INSTALL_STATE);
			InstallState goal = (InstallState) getProperty(CorePackage.Literals.UNIT__GOAL_INSTALL_STATE);

			String imageKey = null;
			switch (init.getValue())
			{
			case InstallState.NOT_INSTALLED:
				switch (goal.getValue())
				{
				//Uninstalled -> Installed
				case InstallState.INSTALLED:
					imageKey = ISharedImages.IMG_UNINSTALL_INSTALL;
					break;
				//Uninstalled -> Uninstalled	
				case InstallState.NOT_INSTALLED:
					imageKey = ISharedImages.IMG_UNINSTALLED;
					break;
				//Uninstalled -> Unknown
				case InstallState.UNKNOWN:
					imageKey = ISharedImages.IMG_UNINSTALLED_UNKNOWN;
					break;
				}
				break;

			case InstallState.INSTALLED:
				switch (goal.getValue())
				{
				//Installed -> Installed
				case InstallState.INSTALLED:
					imageKey = ISharedImages.IMG_INSTALLED;
					break;
				//Installed -> Uninstalled
				case InstallState.NOT_INSTALLED:
					imageKey = ISharedImages.IMG_INSTALL_UNINSTALL;
					break;
				//Installed -> Unknown
				case InstallState.UNKNOWN:
					imageKey = ISharedImages.IMG_INSTALLED_UNKNOWN;
					break;
				}
				break;
			case InstallState.UNKNOWN:
				switch (goal.getValue())
				{
				//Unknown -> Installed
				case InstallState.INSTALLED:
					imageKey = ISharedImages.IMG_UNKNOWN_INSTALL;
					break;
				//Unknown -> Uninstalled 
				case InstallState.NOT_INSTALLED:
					imageKey = ISharedImages.IMG_UNKNOWN_UNINSTALL;
					break;
				//Unknown -> Unknown
				case InstallState.UNKNOWN:
					// Fall through: no icon for unknown
					break;
				}
			}
			if (imageKey != null) {
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(imageKey);
			}
		}
		return null;
	}

}
