/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OsDeployPlugin;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class SlashesToBackslashesInPathResolution extends DeployResolution {

	private String _suggestedPath = null;
	private EAttribute _pathAttribute = null;
	private String _attributeName;
	private String _from;;

	/**
	 * Construct a resolution over the status
	 * 
	 * @param context
	 * @param generator
	 * @param pathAttribute
	 * @param attributeName
	 * @param attributeValue
	 * @param suggestedPath
	 */
	public SlashesToBackslashesInPathResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, EAttribute pathAttribute, String attributeName,
			String attributeValue, String suggestedPath) {
		super(context, generator);
		_suggestedPath = suggestedPath;
		_pathAttribute = pathAttribute;
		_attributeName = attributeName;
		_from = attributeValue;
		String params[] = { _attributeName, _from, _suggestedPath };
		setDescription(NLS.bind(
				OsDomainMessages.Slashes_to_backslashes_resolution_attribute_0_from_1_to_2, params));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus message = context.getDeployStatus();
		DeployModelObject object = message.getDeployObject();

		try {
			assert (object.eClass().getEAllAttributes().contains(_pathAttribute));
			object.getEObject().eSet(_pathAttribute, _suggestedPath);
//			if (object instanceof DB2System) {
//				((DB2System)object).setInstallDir(_suggestedInstallDirName); 
//			}
			return Status.OK_STATUS;
		} catch (Throwable e) {
			return new Status(IStatus.ERROR, OsDeployPlugin.PLUGIN_ID, 0,
					OsDomainMessages.Slashes_to_backslashes_resolution_exception, e);
		}
	}
}
