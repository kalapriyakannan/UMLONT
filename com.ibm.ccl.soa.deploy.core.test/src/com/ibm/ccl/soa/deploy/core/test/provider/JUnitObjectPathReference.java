/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.provider;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * "Fake" test type used for {@link JUnitTopologyProvider} to provide units
 * from.
 * <p>
 * The units actually come from the provider's "infrastructure" topology.
 */
public class JUnitObjectPathReference {
	public final String path;

	public final String title;

	public final EClass type;

	public JUnitObjectPathReference(DeployModelObject obj) {
		this.path = obj.getFullPath();
		this.title = DeployModelObjectUtil.getTitle(obj);
		this.type = obj.eClass();
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}

	public EClass getType() {
		return type;
	}

	public String getTypeName() {
		return type.getName();
	}
}
