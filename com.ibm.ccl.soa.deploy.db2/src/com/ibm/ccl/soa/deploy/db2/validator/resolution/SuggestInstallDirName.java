/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

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
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.Messages;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class SuggestInstallDirName extends DeployResolution {

	private String _suggestedInstallDirName = null;
	private EAttribute _pathAttribute = null;
	private final String _attributeName;;

	/**
	 * Construct a resolution over the status
	 * 
	 * @param context
	 * @param generator
	 * @param suggestedInstallDirName
	 */
	public SuggestInstallDirName(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, EAttribute pathAttribute, String attributeName,
			String suggestedInstallDirName) {
		super(context, generator);
		_suggestedInstallDirName = suggestedInstallDirName;
		_pathAttribute = pathAttribute;
		_attributeName = attributeName;
		String params[] = { _attributeName, _suggestedInstallDirName };
		setDescription(NLS.bind(Messages.Resolution_suggest_path_0_to_1, params));
		// This is a very specific resolution so bump priority
		setPriority(getPriority() + 1);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus message = context.getDeployStatus();
		DeployModelObject object = message.getDeployObject();

		try {
			assert object.eClass().getEAllAttributes().contains(_pathAttribute);
			object.getEObject().eSet(_pathAttribute, _suggestedInstallDirName);
			return Status.OK_STATUS;
		} catch (Throwable e) {
			DB2DeployPlugin.logError(0, e.getMessage(), e);
			return new Status(IStatus.ERROR, DB2DeployPlugin.PLUGIN_ID, 0,
					Messages.Suggest_windows_install_dir_resolution_exception, e);
		}
	}
}
