/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.ui.internal.providers;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.analysis.Deployment;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet;
import com.ibm.ccl.soa.deploy.analysis.ui.Activator;
import com.ibm.ccl.soa.deploy.analysis.ui.internal.AnalysisUIMessages;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * GMF won't let each specialization type have its own icon. It creates icons based on the EMF/Java
 * type. This class is a work-around that lets us offer our own icon.
 */
public class AnalysisIconProvider extends AbstractProvider implements IIconProvider {

	private static Image ICON_DEPLOYMENT_UNIT;
	private static Image ICON_PRESENTATION_DEPLOYMENT_UNIT;
	private static Image ICON_EXECUTION_DEPLOYMENT_UNIT;
	private static Image ICON_DATA_DEPLOYMENT_UNIT;

	public boolean provides(IOperation operation) {
		IIconOperation oper = (IIconOperation) operation;
		IAdaptable ia = oper.getHint();
		Unit unit = (Unit) ia.getAdapter(Unit.class);
		if (unit != null) {
			if (unit instanceof DeploymentUnit) {
				return true;
			}
		}

		return false;
	}

	public Image getIcon(IAdaptable hint, int flags) {
		Unit unit = (Unit) hint.getAdapter(Unit.class);
		if (unit != null) {
			if (unit instanceof DeploymentUnit) {
				return getDeploymentUnitIcon((DeploymentUnit) unit);
			}
		}

		return null;
	}

	private Image getDeploymentUnitIcon(DeploymentUnit du) {
		Iterator it = du.getCapabilities().iterator();
		Deployment depCap = null;
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof Deployment) {
				depCap = (Deployment) capability;
				if(depCap.getFacet() == DeploymentUnitFacet.PRESENTATION_LITERAL){
					return getPresentationDeploymentUnitIcon();
				}else if(depCap.getFacet() == DeploymentUnitFacet.DATA_LITERAL){
					return getDataDeploymentUnitIcon();
				}else if(depCap.getFacet() == DeploymentUnitFacet.EXECUTION_LITERAL){
					return getExecutionDeploymentUnitIcon();
				}
				break;
			}
		}
		return getDeploymentUnitIcon();
	}
	
	private static Image getDeploymentUnitIcon() {
		if (ICON_DEPLOYMENT_UNIT == null) {
			ICON_DEPLOYMENT_UNIT = createImage("icons/pal/deploymentUnit_16.gif"); //$NON-NLS-1$;
		}
		return ICON_DEPLOYMENT_UNIT;
	}
	private static Image getPresentationDeploymentUnitIcon() {
		if (ICON_PRESENTATION_DEPLOYMENT_UNIT == null) {
			ICON_PRESENTATION_DEPLOYMENT_UNIT = createImage("icons/pal/presentationDeploymentUnit_16.gif"); //$NON-NLS-1$;
		}
		return ICON_PRESENTATION_DEPLOYMENT_UNIT;
	}
	
	private static Image getExecutionDeploymentUnitIcon() {
		if (ICON_EXECUTION_DEPLOYMENT_UNIT == null) {
			ICON_EXECUTION_DEPLOYMENT_UNIT = createImage("icons/pal/executionDeploymentUnit_16.gif"); //$NON-NLS-1$;
		}
		return ICON_EXECUTION_DEPLOYMENT_UNIT;
	}
	
	private static Image getDataDeploymentUnitIcon() {
		if (ICON_DATA_DEPLOYMENT_UNIT == null) {
			ICON_DATA_DEPLOYMENT_UNIT = createImage("icons/pal/dataDeploymentUnit_16.gif"); //$NON-NLS-1$;
		}
		return ICON_DATA_DEPLOYMENT_UNIT;
	}

	public static Image createImage(String path) {
		try {
			return createImageDescriptor(path).createImage();
		} catch (Exception ex) {
			Activator.logError(-1, "createImage:"+path, ex); //$NON-NLS-1$
			return null;
		}
	}

	private static ImageDescriptor createImageDescriptor(String path) {
		return Activator.getImageDescriptor(path);
	}

}
