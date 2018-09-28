/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.internal.validator.matcher;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.ConstraintDependencyLinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.ConstraintLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * Identifies whether or not a (logical) link can be established between a {@link J2EEDataSource}
 * requirement (of a J2EE module) and a {@link DB2Database} capability (of a DB2 Database).
 */
public class DatasourceSatisfactionConstraintLinkMatcher extends ConstraintDependencyLinkMatcher {

	/**
	 * Construct a new logical dependency link from a {@link J2EEDatasource} to {@link DB2Database}.
	 */
	public DatasourceSatisfactionConstraintLinkMatcher() {
		super(new EClass[] { J2eePackage.Literals.EAR_MODULE, J2eePackage.Literals.EJB_MODULE,
				J2eePackage.Literals.WEB_MODULE },
				new EClass[] { J2eePackage.Literals.J2EE_DATASOURCE },
				new EClass[] { Db2Package.Literals.DB2_DATABASE_UNIT },
				new EClass[] { Db2Package.Literals.DB2_DATABASE }, true);
		addEndpointMatch(new EClass[] { J2eePackage.Literals.EAR_MODULE,
				J2eePackage.Literals.EJB_MODULE, J2eePackage.Literals.WEB_MODULE },
				new EClass[] { J2eePackage.Literals.J2EE_DATASOURCE },
				new EClass[] { DatabasePackage.Literals.DATABASE_COMPONENT },
				new EClass[] { DatabasePackage.Literals.DATABASE_DEFINITION });
		setLinkDescritptorFactory(new ConstraintLinkDescriptorFactory(
				new DatasourceConstraintFactory()));
	}
}
