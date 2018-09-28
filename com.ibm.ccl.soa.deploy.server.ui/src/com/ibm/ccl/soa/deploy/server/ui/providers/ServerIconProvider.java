/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.server.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.server.ui.Activator;

/**
 * GMF won't let each specialization type have its own icon. It creates icons based on the EMF/Java
 * type. This class is a work-around that lets us offer our own icon.
 * 
 * @author Bill Arnold adapted from GSIconProvider by Ed Snible
 */
public class ServerIconProvider extends AbstractProvider implements IIconProvider {

	private static Image ICON_X86;
	private static Image ICON_POWER;
	private static Image ICON_SERVER;

	public boolean provides(IOperation operation) {
		IIconOperation oper = (IIconOperation) operation;
		IAdaptable ia = oper.getHint();
		Unit unit = (Unit) ia.getAdapter(Unit.class);
		if (unit != null) {
			if (unit instanceof ServerUnit) {
				return true;
			}
		}

		return false;
	}

	public Image getIcon(IAdaptable hint, int flags) {
		Unit unit = (Unit) hint.getAdapter(Unit.class);
		if (unit != null) {
			if (unit instanceof ServerUnit) {
				Server serverCap = (Server) ValidatorUtils.getFirstCapability(unit,
						ServerPackage.eINSTANCE.getServer());
				if (serverCap != null) {
					String cpuArchitecture = serverCap.getCpuArchitecture();
					if (cpuArchitecture != null) {
						if (serverCap.getCpuArchitecture().equalsIgnoreCase("intel")) { //$NON-NLS-1$
							return getX86Icon();
						} else if (serverCap.getCpuArchitecture().equalsIgnoreCase("powerpc")) { //$NON-NLS-1$
							return getPowerIcon();
						}
					}
				}
				// Use Server icon as default
				return getServerIcon();
			}
		}

		return null;
	}

	private static Image getServerIcon() {
		if (ICON_SERVER == null) {
			ICON_SERVER = createImage("icons/pal/server-pal16.gif"); //$NON-NLS-1$;
		}

		return ICON_SERVER;
	}

	private static Image getX86Icon() {
		if (ICON_X86 == null) {
			ICON_X86 = createImage("icons/pal/x86_server_16.gif"); //$NON-NLS-1$;
		}

		return ICON_X86;
	}

	private static Image getPowerIcon() {
		if (ICON_POWER == null) {
			ICON_POWER = createImage("icons/pal/power-server_pal16.gif"); //$NON-NLS-1$;
		}

		return ICON_POWER;
	}

	public static Image createImage(String path) {
		try {
			return createImageDescriptor(path).createImage();
		} catch (Exception ex) {
			return null;
		}
	}

	private static ImageDescriptor createImageDescriptor(String path) {
		return Activator.getImageDescriptor(path);
	}

}
