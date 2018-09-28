/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.IConstraintFactory;
import com.ibm.ccl.soa.deploy.was.db2.WasDb2Factory;

/**
 * Factory to create instances of DatasourceSatisfactory constraints
 */
public class DatasourceConstraintFactory implements IConstraintFactory {

	public Constraint createConstraint() {
		return WasDb2Factory.eINSTANCE.createDatasourceSatisfactionConstraint();
	}
}