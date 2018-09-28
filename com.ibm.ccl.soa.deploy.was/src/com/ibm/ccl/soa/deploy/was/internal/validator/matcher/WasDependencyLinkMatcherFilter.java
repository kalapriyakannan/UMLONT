/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatchFilter;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * Disallow links - From DB2JDBCProviderUnit to unit providing DB2JDBCDriver capability if the units
 * are hosted on different operating systems - From WASDatasourceUnit to DB2JDBCProviderUnit if the
 * units are hosted on different websphere server instances
 * 
 */
public class WasDependencyLinkMatcherFilter extends LinkMatchFilter {

	@Override
	public IStatus canCreateLink(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {
		if (WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT
				.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			if (ValidatorUtils.getCapability(targetUnit, Db2Package.Literals.DB2_JDBC_DRIVER) != null) {
				if (ValidatorUtils.unitsAreNonLocal(sourceUnit, targetUnit,
						OsPackage.Literals.OPERATING_SYSTEM_UNIT)) {
					return new Status(IStatus.ERROR, WasDeployPlugin.pluginID, 0,
							Messages.JDBCDriverMustBeHostedOnSameOperatingSystem, null);
				}
			}
		}
		// TODO this is only correct for single-server case. 
		if (WasPackage.Literals.WAS_DATASOURCE_UNIT.isSuperTypeOf(sourceUnit.getEObject().eClass())
				&& WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT.isSuperTypeOf(targetUnit.getEObject()
						.eClass())) {
			if (ValidatorUtils.unitsAreNonLocal(sourceUnit, targetUnit,
					WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT)) {
				return new Status(IStatus.ERROR, WasDeployPlugin.pluginID, 0,
						Messages.JDBPProviderMustBeOnSameWebSphereAppServer, null);
			}
		}

		if (WasPackage.Literals.WAS_DATASOURCE_UNIT.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			if (Db2Package.Literals.DB2_DATABASE_UNIT.isSuperTypeOf(targetUnit.getEObject().eClass())
					|| Db2Package.Literals.DB2_CATALOG_UNIT.isSuperTypeOf(targetUnit.getEObject()
							.eClass())) {
				Unit dsUnitHost = ValidatorUtils.discoverHost(sourceUnit, null);
				if (dsUnitHost != null && dsUnitHost instanceof DB2JdbcProviderUnit) {
					DB2JdbcProvider db2JdbcProvider = (DB2JdbcProvider) ValidatorUtils.getCapability(
							dsUnitHost, WasPackage.eINSTANCE.getDB2JdbcProvider());
					if (db2JdbcProvider.getJdbcType().equals(JdbcTypeType._2_LITERAL)) {
						if (ValidatorUtils.unitsAreNonLocal(sourceUnit, targetUnit,
								OsPackage.Literals.OPERATING_SYSTEM_UNIT)) {
							return new Status(
									IStatus.ERROR,
									WasDeployPlugin.pluginID,
									0,
									Messages.Type2JDBCDependencyMustBeToDB2CatalogHostedOnSameOperatingSystem,
									null);
						}
					}
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.DependencyLinkMatcher#getPossibleLinks(com.ibm.ccl.soa.deploy.core.Unit,
//	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.Unit,
//	 *      com.ibm.ccl.soa.deploy.core.Capability)
//	 */
//	public Set<LinkDescriptor> getPossibleLinks(Unit source, Requirement sourceRequirement,
//			Unit target, Capability targetCapability) {
//		Set<LinkDescriptor> retVal = super.getPossibleLinks(source, sourceRequirement, target,
//				targetCapability);
//
//		Set<LinkDescriptor> newDescriptors = new HashSet<LinkDescriptor>();
//
//		// filter some matches out
//		// at the same time convert to WasLinkDescriptor
//		for (Iterator iter = retVal.iterator(); iter.hasNext();) {
//			LinkDescriptor ld = (LinkDescriptor) iter.next();
//			Unit sourceUnit = ld.getSourceUnit();
//			Unit targetUnit = ld.getTargetUnit();
//			// System.out.println("Checking link: " + sourceUnit.getName() + ":" + targetUnit.getName()); //$NON-NLS-1$ //$NON-NLS-2$
//			Capability targetCap = (Capability) ld.getTarget();
//			IStatus ccl = canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCap);
//			if (!ccl.getMessage().equals(DeployMatcherStatus.MATCH_FOUND.getMessage())) {
//				retVal.remove(ld);
//			} else {
//				if (LinkType.DEPENDENCY.equals(ld.getType())) {
//					newDescriptors
//							.add(new WasLinkDescriptor(ld.getType(), ld.getSourceUnit(), (Requirement) ld
//									.getSource(), ld.getTargetUnit(), (Capability) ld.getTarget()));
//				} else {
//					newDescriptors.add(ld);
//				}
//			}
//		}
//
//		return newDescriptors;
//	}
//
}
