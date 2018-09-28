/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator.constraint;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.ConstraintOnLinkValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDomainMessages;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;
import com.ibm.ccl.soa.deploy.waswebplugin.internal.validator.IWasWebPluginValidatorID;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.IWasWebPluginProblemTypes;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.WasWebServerConfigurationActivePattern;
import com.ibm.ccl.soa.deploy.waswebplugin.validator.status.WasWebServerToIhsStatus;

/**
 * Validator for {@link WasWebServerToIhsConstraint} on a {@link ConstraintLink}.
 */
public class WasWebServerToIhsConstraintValidator extends ConstraintOnLinkValidator {

	public WasWebServerToIhsConstraintValidator() {
		super(WaswebpluginPackage.Literals.WAS_WEB_SERVER_TO_IHS_CONSTRAINT,
				new EClass[] { WasPackage.Literals.WAS_WEB_SERVER_UNIT }, false, new EClass[] {
						IhsPackage.Literals.IHS_SERVER_UNIT, IhsPackage.Literals.IHS_SYSTEM_UNIT,
						WaswebpluginPackage.Literals.IHS_WAS_PLUGIN_UNIT });
	}

	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return Collections.emptyList();
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return WaswebpluginPackage.Literals.WAS_WEB_SERVER_TO_IHS_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	protected IDeployStatus createCanSatisfyStatus(Constraint constraint, DeployModelObject context) {
		WasWebServerToIhsStatus s = new WasWebServerToIhsStatus(IStatus.ERROR,
				IWasWebPluginValidatorID.WAS_WEB_SERVER_TO_IHS_CONSTRAINT_VALIDATION,
				IWasWebPluginProblemTypes.WAS_WEB_SERVER_TO_IHS_CONSTRAINT_FAILS,
				WasWebPluginDomainMessages.Validator_Implement_WasWebServerToIhsPluginConstraint,
				new Object[] {}, constraint, getWasWebServerUnitFromContext(context),
				getIhsWasPluginUnitFromContext(context));
		return s;
	}

	@Override
	protected IStatus validateConstraint(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		WasWebServerUnit server = getWasWebServerUnitFromContext(context);
		IhsWasPluginUnit plugin = getIhsWasPluginUnitFromContext(context);

		if (plugin == null) {
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IWasWebPluginValidatorID.WAS_WEB_SERVER_TO_IHS_CONSTRAINT_VALIDATION,
					IWasWebPluginProblemTypes.IHS_WAS_PLUGIN_UNIT_NOT_FOUND,
					WasWebPluginDomainMessages.Validator_Expected_IHS_Was_Plugin_Not_Found,
					new Object[] {}, constraint);
		}

		WasWebServerConfigurationActivePattern pattern = new WasWebServerConfigurationActivePattern(
				server, plugin);
		IStatus status = pattern.find(false, new NullProgressMonitor());
		return status;
	}

	/**
	 * Finds a {@link IhsWasPluginUnit} hosted on the same operating system as the
	 * {@link IhsServerUnit} or {@link IhsSystemUnit}.
	 * 
	 * @param pluginOrserverOrSystem
	 *           an IHS plugin or IHS server or IHS systemunit.
	 * @return the IHS WAS plugin unit, or null if not found.
	 */
	private IhsWasPluginUnit getWasPluginUnit(Unit pluginOrserverOrSystem) {
		if (pluginOrserverOrSystem == null || pluginOrserverOrSystem.getEditTopology() == null) {
			return null;
		}

		if (WaswebpluginPackage.Literals.IHS_WAS_PLUGIN_UNIT.isSuperTypeOf(pluginOrserverOrSystem
				.getEObject().eClass())) {
			return (IhsWasPluginUnit) pluginOrserverOrSystem;
		}

		Unit osUnit = ValidatorUtils.discoverHostInStackWithCapability(pluginOrserverOrSystem,
				OsPackage.eINSTANCE.getOperatingSystem(), null);
		if (osUnit == null) {
			return null;
		}
		List<Unit> list = ValidatorUtils.discoverHosted(osUnit,
				WaswebpluginPackage.Literals.IHS_WAS_PLUGIN_UNIT, null);
		if (list == null || list.size() == 0) {
			return null;
		}

		return (IhsWasPluginUnit) list.get(0);
	}

	/**
	 * Get the {@link WasWebServerUnit} from the context; ie, the source of the link.
	 * 
	 * @param context
	 *           the constraint context (link)
	 * @return the {@link WasWebServerUnit}
	 */
	private WasWebServerUnit getWasWebServerUnitFromContext(DeployModelObject context) {
		return (WasWebServerUnit) getSource(context);
	}

	/**
	 * Get the {@link IhsWasPluginUnit} from the context; ie, the target of the link.
	 * 
	 * @param context
	 *           the constraint context (link)
	 * @return the {@link IhsWasPluginUnit}
	 */
	private IhsWasPluginUnit getIhsWasPluginUnitFromContext(DeployModelObject context) {
		return getWasPluginUnit((Unit) getTarget(context));
	}

}
