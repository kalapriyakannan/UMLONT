/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * Clients should not use the provider directly, but instead should refer to the type-safe API class
 * {@link com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel}. The provider is required
 * by the Smart Datamodels Framework (SDF).
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel
 * @generated (mde.utilities.datamodels)
 */
public class LinkDiscoveryDataModelProvider extends AbstractDataModelProvider implements
		ILinkDiscoveryDataModelProperties {
	private final DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ILinkDiscoveryDataModelProperties#UNIT
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateUnit() {
		// TODO Remove the @generated tag above and validate the property. 
		Assert.isTrue(model.getProperty(ILinkDiscoveryDataModelProperties.UNIT) instanceof Unit);
		return Status.OK_STATUS;
	}

	private boolean hasAtLeastOneUnfilledMember() {
		Unit unit = (Unit) getProperty(UNIT);
		return dvs.canBeLinkTarget(unit, new LinkType[] { LinkType.MEMBER }).isOK();

	}

	private boolean hasAtLeastOneUnfilledDependency() {
		Unit unit = (Unit) getProperty(UNIT);
		return dvs.canBeLinkSource(unit, new LinkType[] { LinkType.DEPENDENCY }).isOK();

	}

	private boolean hasAtLeastOneUnfilledHosting() {
		Unit unit = (Unit) getProperty(UNIT);
		return dvs.canBeLinkTarget(unit, new LinkType[] { LinkType.HOSTING }).isOK();

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ILinkDiscoveryDataModelProperties#UNIT
	 * @generated (mde.utilities.datamodels)
	 */
	protected Unit getDefaultUnit() {
		// TODO Return the default value of the Unit property.
		return null;
	}

	public IStatus validateIsHosting() {

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ILinkDiscoveryDataModelProperties#IS_HOSTING
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsHosting() {
		return Boolean.FALSE;
	}

	public IStatus validateIsLogical() {
		return Status.OK_STATUS;
	}

	protected Boolean getDefaultIsLogical() {
		return Boolean.FALSE;
	}

	public IStatus validateIsDependency() {

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ILinkDiscoveryDataModelProperties#IS_DEPENDENCY
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsDependency() {
		return Boolean.FALSE;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ILinkDiscoveryDataModelProperties#IS_GROUP
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateIsGroup() {
		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ILinkDiscoveryDataModelProperties#IS_GROUP
	 * @generated (mde.utilities.datamodels)
	 */
	protected Boolean getDefaultIsGroup() {
		return Boolean.FALSE;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ILinkDiscoveryDataModelProperties#REQUIREMENT
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateReference() {
		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ILinkDiscoveryDataModelProperties#REQUIREMENT
	 * @generated (mde.utilities.datamodels)
	 */
	protected DeployModelObject getDefaultDeploymentObjectModel() {
		return null;
	}

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see ILinkDiscoveryDataModelProperties#DESCRIPTORS
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDescriptors() {

		Object[] descriptors = (Object[]) model
				.getProperty(ILinkDiscoveryDataModelProperties.DESCRIPTORS);
		if (descriptors == null || descriptors.length == 0) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.LinkDiscoveryDataModelProvider_Please_select_a_check_box_in_the_ta_,
							null);
		}
		if (containsTwoHostersForSameUnit(Arrays.asList(descriptors))) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.LinkDiscoveryDataModelProvider_A_Unit_may_only_be_hosted_by_one_Un_,
							null);

		}

		if (containsDuplicateRequirements(Arrays.asList(descriptors))) {
			return DeployCorePlugin
					.createErrorStatus(
							0,
							DeployCoreMessages.LinkDiscoveryDataModelProvider_Requirements_may_only_link_to_singl_,
							null);
		}

		return Status.OK_STATUS;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ILinkDiscoveryDataModelProperties#DESCRIPTORS
	 * @generated (mde.utilities.datamodels)
	 */
	protected Object[] getDefaultDescriptors() {
		return new Object[0];
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validate(String property) {
		if (ILinkDiscoveryDataModelProperties.IS_HOSTING.equals(property)) {
			return validateIsHosting();
		} else if (ILinkDiscoveryDataModelProperties.IS_LOGICAL.equals(property)) {
			return validateIsLogical();
		} else if (ILinkDiscoveryDataModelProperties.UNIT.equals(property)) {
			return validateUnit();
		} else if (ILinkDiscoveryDataModelProperties.DESCRIPTORS.equals(property)) {
			return validateDescriptors();
		} else if (ILinkDiscoveryDataModelProperties.REQUIREMENT.equals(property)) {
			return validateReference();
		} else if (ILinkDiscoveryDataModelProperties.IS_DEPENDENCY.equals(property)) {
			return validateIsDependency();
		} else if (ILinkDiscoveryDataModelProperties.IS_GROUP.equals(property)) {
			return validateIsGroup();
		} else {
			return Status.OK_STATUS;
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultProperty(String property) {
		if (ILinkDiscoveryDataModelProperties.IS_HOSTING.equals(property)) {
			return getDefaultIsHosting();
		} else if (ILinkDiscoveryDataModelProperties.IS_LOGICAL.equals(property)) {
			return getDefaultIsLogical();
		} else if (ILinkDiscoveryDataModelProperties.UNIT.equals(property)) {
			return getDefaultUnit();
		} else if (ILinkDiscoveryDataModelProperties.DESCRIPTORS.equals(property)) {
			return getDefaultDescriptors();
		} else if (ILinkDiscoveryDataModelProperties.REQUIREMENT.equals(property)) {
			return getDefaultDeploymentObjectModel();
		} else if (ILinkDiscoveryDataModelProperties.IS_DEPENDENCY.equals(property)) {
			return getDefaultIsDependency();
		} else if (ILinkDiscoveryDataModelProperties.IS_GROUP.equals(property)) {
			return getDefaultIsGroup();
		} else if (ILinkDiscoveryDataModelProperties.SHOULD_SHOW_SELCTION_PAGE.equals(property)) {
			return Boolean.TRUE;
		} else {
			return null;
		}

	}

	/**
	 * Override this method to handle dependencies between different properties. That is, if changing
	 * a name property updates the default values of other properties, this is where you respond to
	 * these changes.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String,
	 *      Object)
	 * 
	 */
	public boolean propertySet(String propertyName, Object propertyValue) {
		if (propertyName.equals(UNIT)) {
			setupScribblerParameters((Unit) propertyValue);
		}
		if (propertyName.equals(REQUIREMENT)) {
			if (propertyValue instanceof Requirement) {
				Requirement requirement = (Requirement) propertyValue;
				if (requirement.getParent() instanceof Unit) {
					Unit unit = (Unit) requirement.getParent();
					setProperty(UNIT, unit);
				}
//				setProperty(IS_DEPENDENCY, true);
//				setProperty(IS_HOSTING, false);
//				setProperty(SHOULD_SHOW_SELCTION_PAGE, false);
			}
		}
//		if (propertyName.equals(IS_HOSTING)) {
//			setProperty(IS_DEPENDENCY, false);
//			setProperty(SHOULD_SHOW_SELCTION_PAGE, false);
//		}
		return super.propertySet(propertyName, propertyValue);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames()
	 * @generated (mde.utilities.datamodels)
	 */
	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(IS_HOSTING);
		propertyNames.add(IS_LOGICAL);
		propertyNames.add(UNIT);
		propertyNames.add(DESCRIPTORS);
		propertyNames.add(REQUIREMENT);
		propertyNames.add(IS_DEPENDENCY);
		propertyNames.add(IS_GROUP);
		propertyNames.add(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL);
		propertyNames.add(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS);
		propertyNames.add(IAbstractScribblerDataModelProperties.PROJECT_NAME);
		propertyNames.add(SHOULD_SHOW_SELCTION_PAGE);
		return propertyNames;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation()
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation getDefaultOperation() {
		return new LinkDiscoveryDataModelOperation(model);
	}

	public boolean isPropertyEnabled(String propertyName) {

		if (ILinkDiscoveryDataModelProperties.IS_HOSTING.equals(propertyName)) {
			return hasAtLeastOneUnfilledHosting();
		} else if (ILinkDiscoveryDataModelProperties.IS_DEPENDENCY.equals(propertyName)) {
			return hasAtLeastOneUnfilledDependency();
		} else if (ILinkDiscoveryDataModelProperties.IS_GROUP.equals(propertyName)) {
			return hasAtLeastOneUnfilledMember();
		}
		return true;

	}

	private boolean containsTwoHostersForSameUnit(List descriptors) {
		Set<Unit> hostees = new HashSet<Unit>();

		for (Iterator<DiscoveryDescriptor> it = descriptors.iterator(); it.hasNext();) {
			DiscoveryDescriptor dd = it.next();
			if (dd.getType() == LinkType.HOSTING) {
				if (!hostees.add(dd.getTarget())) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean containsDuplicateRequirements(List descriptors) {
		Set<Requirement> set = new HashSet<Requirement>();

		for (Iterator<DiscoveryDescriptor> it = descriptors.iterator(); it.hasNext();) {
			DiscoveryDescriptor dd = it.next();
			if (dd.getReq() != null && !set.add(dd.getReq())) {
				return true;
			}
		}

		return false;
	}

	protected void setupScribblerParameters(EObject obj) {
		IProject project = WorkbenchResourceHelper.getProject(obj.eResource());
		IFile file = WorkbenchResourceHelper.getFile(obj.eResource());
		model.setProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL,
				DeploymentTopologyDomain.generateEditModelLabel(file));
		model.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
				new IScribblerDomain[] { new DeploymentTopologyDomain(file) });
		model.setProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME, project.getName());
	}

}
