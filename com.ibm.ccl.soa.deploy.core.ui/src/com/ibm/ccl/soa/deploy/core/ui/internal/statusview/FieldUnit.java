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
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.export.DeployExportStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * 
 * @author Lynn
 * 
 */
/**
 * Unit Field
 */
public class FieldUnit extends StatusField {

	/**
	 * return the deploy model object's location if obj instance of
	 * <li> {@link IDeployPublishStatus}</li>
	 * 
	 * @throws NotSupportedTargetException
	 */
	public String getValue(Object obj) throws NotSupportedTargetException {
		DeployModelObject dmo = getDMO(obj);
		if (dmo == null)
			return Messages.NULL_MESSAGE;
		IFile file = WorkbenchResourceHelper.getFile(dmo.getTopology().getEObject());
		if (file == null)
			throw new NotSupportedTargetException(dmo);
		String seperator = "/"; //$NON-NLS-1$
		String name = file.getProject().getName() + seperator + file.getName() + seperator
				+ dmo.getDisplayName();
		return name;

	}

	/**
	 * 
	 * @param obj
	 * @return DeployModelObject contains in obj
	 * @throws NotSupportedTargetException
	 */
	public DeployModelObject getDMO(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			StatusNode node = (StatusNode) obj;
			IStatus status = node.getStatus();
			if (status instanceof IDeployPublishStatus) {
				return ((IDeployPublishStatus) status).getDeployObject();
			} else if (status instanceof DeployExportStatus) {
				//TODO
				return null;
			}
		}

		throw new NotSupportedTargetException(obj);
	}

	/**
	 * @return
	 * <li>{@value PublishMessages#Column_Title_DeployObject}</li>
	 */
	public String getColumnHeaderText() {
		return Messages.Field_Unit_Name;
	}

	/**
	 * 
	 */
	public final static FieldUnit INSTANCE = new FieldUnit();

}
