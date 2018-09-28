/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.core.resources.IFile;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * wrapper for internal API
 * 
 * @author Ella Feng
 */
public class FieldTopology extends StatusField {

	public String getColumnHeaderText() {

		return Messages.Field_Topology_Name;
	}

	public String getValue(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IDeployPublishStatus status = (IDeployPublishStatus) ((StatusNode) obj).getStatus();
			assert (status != null);
			IFile file = WorkbenchResourceHelper.getFile(status.getDeployObject().getTopology()
					.getEObject());
			if (file != null) {
				String seperator = "/"; //$NON-NLS-1$
				String name = file.getProject().getName() + seperator + file.getName();
				return name;
			}

		}
		throw new NotSupportedTargetException(obj);
	}

	/**
	 * 
	 */
	public final static FieldTopology INSTANCE = new FieldTopology();
}
