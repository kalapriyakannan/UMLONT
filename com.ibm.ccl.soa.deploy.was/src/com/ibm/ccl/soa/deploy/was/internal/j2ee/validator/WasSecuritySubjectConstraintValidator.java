/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDefaultSecuritySubjectEnum;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validator to validate {@link WasSecuritySubjectConstraint}.
 */
public class WasSecuritySubjectConstraintValidator extends ConstraintValidator {

	public boolean isPlacementValidOnDMO(DeployModelObject dmo) {
		// indirect approach is taken because we understand that this method
		// may be removed from the interface.
		return isValidPlacement(dmo);
	}

	protected boolean isValidPlacement(DeployModelObject dmo) {
		if (!J2eePackage.Literals.J2EE_SECURITY_ROLE.isSuperTypeOf(dmo.getEObject().eClass())) {
			return false;
		}

		J2EESecurityRole securityRole = (J2EESecurityRole) dmo;
		if (securityRole.getParent() == null) {
			return false;
		}

		return WasJ2eeValidatorUtils.isJ2eeHostedOnWas(securityRole);
	}

	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		IStatus returnStatus = null;

		if (!WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {
			// we don't know how to validate this constraint
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// we know it is a {@link WasSecuritySubjectConstraint}
		WasSecuritySubjectConstraint ssConstraint = (WasSecuritySubjectConstraint) constraint;
		//		System.out.println("Constraint Parent is: " + ssConstraint.getParent()); //$NON-NLS-1$

		// check that the constraint is on a valid {@link HostingLink}
		if (!isValidPlacement(context)) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.WARNING,
					IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT,
					WasDomainMessages.WasJ2eeValidator_WasSecuritySubjectConstraint_In_Invalid_Context,
					new Object[] {}, ssConstraint);
			return status;
			//TODO RESOLUTION -> delete constraint
		}

		// context is a {@link J2EESecurityRole}; should be on a module that is ultimately hosted
		// hosting link should never be null b/c that condition is tested in the isValidPlacement method above
		HostingLink link = WasJ2eeValidatorUtils.findHostingLink(context);
		Unit hostee = (Unit) RealizationLinkUtil.getFinalRealization(link.getTarget());
		Unit host = (Unit) RealizationLinkUtil.getFinalRealization(link.getSource());

		J2EESecurityRole securityRole = (J2EESecurityRole) ssConstraint.getParent();
		String wasSubject = ssConstraint.getWasSecuritySubject();
		if (null == wasSubject) {
			IDeployStatus status = new DeployAttributeStatus(
					IStatus.ERROR,
					IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL_VALIDATOR_001,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL,
					WasDomainMessages.WasJ2eeValidator_Constraint_Attribute_Undefined_0,
					new String[] { WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT
							.getName() }, ssConstraint,
					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT);
			returnStatus = addStatus(returnStatus, status);
			//TODO RESOLUTION -> set was security subject
		}

		// if we had some errors then return them and stop processing
		if (returnStatus != null) {
			return returnStatus;
		}

		IStatus status = validateWasSecuritySubject(securityRole.getRole(), hostee, wasSubject, host,
				ssConstraint);
		returnStatus = addStatus(returnStatus, status);

		// return resulting status
		return returnStatus == null ? DeployCoreStatusFactory.INSTANCE.getOKStatus() : returnStatus;
	}

	private static IStatus addStatus(IStatus currentStatus, IStatus newStatus) {

		if (newStatus != null && newStatus.getSeverity() != IStatus.OK) {
			if (currentStatus == null) {
				currentStatus = newStatus;
			} else if (currentStatus instanceof MultiStatus) {
				((MultiStatus) currentStatus).add(newStatus);
			} else {
				currentStatus = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] {
						currentStatus, newStatus }, DeployCoreMessages.Model_consistency_status_message,
						null);
			}
		}
		return currentStatus;
	}

	private IStatus validateWasSecuritySubject(String j2eeSecurityRole, Unit j2eeModule,
			String wasSecuritySubject, Unit wasContainer, Constraint context) {
		IStatus resultStatus = null;

		int numServersWithSecurityEnabled = 0;
		List<Unit> servers = null;

		if (wasContainer instanceof WasClusterUnit) {
			servers = WebsphereContext.getMembers(wasContainer,
					WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, wasContainer.getEditTopology());
		} else if (wasContainer instanceof WebsphereAppServerUnit) {
			servers = new ArrayList<Unit>();
			servers.add(wasContainer);
		} else {
			// should not happen
			servers = new ArrayList<Unit>();
		}

		for (int i = 0; i < servers.size(); i++) {
			Unit server = servers.get(i);
			ServerSecuritySettings security = new ServerSecuritySettings(
					(WebsphereAppServerUnit) server);
			resultStatus = addStatus(resultStatus, security.getSecurityStatus());
			if (security.isSecurityEnabled()) {
				numServersWithSecurityEnabled++;
				resultStatus = addStatus(resultStatus, validateWasSecuritySubjectOnServer(
						wasSecuritySubject, (WebsphereAppServerUnit) server, security
								.getUserRegistryType(), context));
			}
		}

		if (numServersWithSecurityEnabled < servers.size() && numServersWithSecurityEnabled > 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE
					.createDeployStatus(
							IStatus.WARNING,
							IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT_VALIDATOR_001,
							IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT,
							WasDomainMessages.WasJ2eeValidator_Server_Security_Inconsistent,
							new Object[] {}, context);
			resultStatus = addStatus(resultStatus, status);
			//TODO RESOLUTION -> set global security
		}

		return resultStatus == null ? DeployCoreStatusFactory.INSTANCE.getOKStatus() : resultStatus;
	}

	private IStatus validateWasSecuritySubjectOnServer(String role, WebsphereAppServerUnit server,
			WasUserRegistryTypes userRegistry, Constraint context) {
		IStatus resultStatus = null;

		// security is enabled; look for the security subject in the registry
		// but first look for predefined subjects
		if (WasDefaultSecuritySubjectEnum.EVERYONE_LITERAL.toString().equalsIgnoreCase(role)
				|| WasDefaultSecuritySubjectEnum.ALL_AUTHENTICATED_LITERAL.toString().equalsIgnoreCase(
						role)) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		IStatus status = null;
		if (userRegistry.equals(WasUserRegistryTypes.OS_LITERAL)) {
			// user registry is local OS
			status = validateWasSecuritySubjectUsingOs(role, server, context);
		} else if (userRegistry.equals(WasUserRegistryTypes.LDAP_LITERAL)) {
			// user registry is LDAP
			// currently not supported
			//			status = DeployCoreStatusFactory.INSTANCE
			//					.createDeployStatus(
			//							IStatus.WARNING,
			//							IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
			//							IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
			//							WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0,
			//							new Object[] { role }, context);
			status = new DeployAttributeStatus(
					IStatus.ERROR,
					IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
					WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0,
					new String[] { role }, context,
					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT);

		} else if (userRegistry.equals(WasUserRegistryTypes.CUSTOM_LITERAL)) {
			// user registry is a custom registry
			// currently not suppported
			//			status = DeployCoreStatusFactory.INSTANCE
			//					.createDeployStatus(
			//							IStatus.WARNING,
			//							IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
			//							IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
			//							WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0,
			//							new Object[] { role }, context);
			status = new DeployAttributeStatus(
					IStatus.ERROR,
					IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
					WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0,
					new String[] { role }, context,
					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT);
		} else {
			// user registry is not recognized
			// currently not supported
			//			status = DeployCoreStatusFactory.INSTANCE
			//					.createDeployStatus(
			//							IStatus.WARNING,
			//							IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
			//							IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
			//							WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0,
			//							new Object[] { role }, context);
			status = new DeployAttributeStatus(
					IStatus.ERROR,
					IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
					WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0,
					new String[] { role }, context,
					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT);
		}
		if (null != status) {
			resultStatus = addStatus(resultStatus, status);
		}

		return resultStatus == null ? DeployCoreStatusFactory.INSTANCE.getOKStatus() : resultStatus;
	}

	private IStatus validateWasSecuritySubjectUsingOs(String role, WebsphereAppServerUnit server,
			Constraint context) {
		OperatingSystemUnit os = (OperatingSystemUnit) ValidatorUtils.discoverHostInStack(server,
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, null);
		if (null == os) {
			// could not find OS; can't validate role
			//			IDeployStatus status = DeployCoreStatusFactory.INSTANCE
			//					.createDeployStatus(
			//							IStatus.WARNING,
			//							IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
			//							IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
			//							WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Os_0,
			//							new Object[] { role }, context);
			IDeployStatus status = new DeployAttributeStatus(
					IStatus.WARNING,
					IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
					IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
					WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Os_0,
					new String[] { role }, context,
					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT);
			return status;
		}

		// best practice is to use a group; so we look for our subject here first
		List<Unit> groups = ValidatorUtils.getHosted(os, OsPackage.Literals.USER_GROUP_UNIT);
		for (int i = 0; i < groups.size(); i++) {
			if (isSubjectGroup(role, (UserGroupUnit) groups.get(i))) {
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
		}

		List<Unit> users = ValidatorUtils.getHosted(os, OsPackage.Literals.USER_UNIT);
		for (int i = 0; i < users.size(); i++) {
			if (isSubjectUser(role, (UserUnit) users.get(i))) {
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
		}

		// we didn't find the role
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.WARNING,
						IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND_VALIDATOR_001,
						IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND,
						WasDomainMessages.WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_NotFound_0,
						new Object[] { role }, context);
		return status;
	}

	private boolean isSubjectUser(String subject, UserUnit userUnit) {
		if (null == subject) {
			return false;
		}

		User user = (User) ValidatorUtils.getCapability(userUnit, OsPackage.Literals.USER);
		if (null == user) {
			return false;
		}

		return subject.equals(user.getUserId());
	}

	private boolean isSubjectGroup(String subject, UserGroupUnit groupUnit) {
		if (null == subject) {
			return false;
		}

		UserGroup group = (UserGroup) ValidatorUtils.getCapability(groupUnit,
				OsPackage.Literals.USER_GROUP);
		if (null == group) {
			return false;
		}

		return subject.equals(group.getGroupName());
	}

	private class ServerSecuritySettings {
		private WasUserRegistryTypes userRegistry = null;
		private boolean securityEnabled = false;
		private IStatus resultStatus = null;

		/**
		 * Constructor extracts fields from {@link WasSecurity} capability on a Websphere server.
		 * <p>
		 * Creates a status if there is no {@link WasSecurity} capability.
		 * 
		 * @param server
		 *           the server
		 */
		public ServerSecuritySettings(WebsphereAppServerUnit server) {
			WasSecurity securityProperties = (WasSecurity) ValidatorUtils.getCapability(server,
					WasPackage.Literals.WAS_SECURITY);
			if (null == securityProperties) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(
								IStatus.WARNING,
								IWasValidatorID.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED_VALIDATOR_001,
								IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED,
								WasDomainMessages.WasJ2eeValidator_Server_Security_Properties_Not_Specified,
								new Object[] {}, server);
				//TODO RESOLUTION --> create was security properties
				resultStatus = addStatus(resultStatus, status);
				// assume preferences is for security enabled and user registry is OS
				securityEnabled = false;
				userRegistry = WasUserRegistryTypes.OS_LITERAL;
			} else {
				userRegistry = securityProperties.getActiveUserRegistry();
				securityEnabled = securityProperties.isGlobalSecurityEnabled();
			}
		}

		/**
		 * Get the user registry type
		 * 
		 * @return the user registry type
		 */
		public WasUserRegistryTypes getUserRegistryType() {
			return userRegistry;
		}

		/**
		 * Determine if global security is enabled on the server.
		 * 
		 * @return true if global security is enabled; false otherwise
		 */
		public boolean isSecurityEnabled() {
			return securityEnabled;
		}

		/**
		 * Retrieve any {@IDeployStatus} created while finding the security settings.
		 * 
		 * @return a {@IDeployStatus}
		 */
		public IStatus getSecurityStatus() {
			return resultStatus;
		}
	}

	public boolean canValidateConstraint(Constraint constraint) {
		return constraint instanceof WasSecuritySubjectConstraint;
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// TODO: confirm the logic
		// don't allow child constraints
		return EMPTY_CONSTRAINT_LIST;
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		// TODO: confirm the logic
		// don't allow child constraints
		return null;
	}

	@Override
	public String title(Constraint constraint) {
		if (constraint == null) {
			return DeployCoreMessages.null_value;
		}
		String typeName = computeTypeName(constraint);
		StringBuffer buf = new StringBuffer(typeName);
		String caption = constraint.getDisplayName();
		if (caption != null && caption.trim().length() > 0) {
			buf.append(' ').append('(').append(caption.trim()).append(')');
		}
		String subject = ((WasSecuritySubjectConstraint) constraint).getWasSecuritySubject();
		if (subject != null && subject.length() > 0) {
			buf.append(" = ").append(subject); //$NON-NLS-1$
		}
		return buf.toString();
	}

}
