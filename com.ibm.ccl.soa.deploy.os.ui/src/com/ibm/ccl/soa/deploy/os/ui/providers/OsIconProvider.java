/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.ui.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.ui.Activator;

/**
 * GMF won't let each specialization type have its own icon. It creates icons based on the EMF/Java
 * type. This class is a work-around that lets us offer our own icon.
 * 
 * @author Bill Arnold adapted from GSIconProvider by Ed Snible
 */
public class OsIconProvider extends AbstractProvider implements IIconProvider {

	private static Image ICON_WINDOWS_2000;
	private static Image ICON_WINDOWS_XP;
	private static Image ICON_WINDOWS_2003_SERVER;
	private static Image ICON_SUSE_LINUX;
	private static Image ICON_REDHAT_LINUX;
	private static Image ICON_GENERIC_LINUX;
	private static Image ICON_AIX;
	private static Image ICON_OS;

	public boolean provides(IOperation operation) {
		IIconOperation oper = (IIconOperation) operation;
		IAdaptable ia = oper.getHint();
		Unit unit = (Unit) ia.getAdapter(Unit.class);
		if (unit != null) {
			if (unit instanceof WindowsOperatingSystemUnit) {
				return true;
			} else if (unit instanceof LinuxOperatingSystemUnit) {
				return true;
			} else if (unit instanceof AIXOperatingSystemUnit) {
				return true;
			} else if (unit instanceof OperatingSystemUnit) {
				return true;
			}
		}

		return false;
	}

	public Image getIcon(IAdaptable hint, int flags) {
		Unit unit = (Unit) hint.getAdapter(Unit.class);
		if (unit != null) {
			if (unit instanceof WindowsOperatingSystemUnit) {
				OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getFirstCapability(unit,
						OsPackage.eINSTANCE.getOperatingSystem());
				if (osCap == null) {
					return getOSIcon();
				} else if (osCap.getOsVersion().equalsIgnoreCase("XP")) { //$NON-NLS-1$
					return getWindowsXPIcon();
				} else if (osCap.getOsVersion().equals("2000")) { //$NON-NLS-1$
					return getWindows2000Icon();
				} else if (osCap.getOsVersion().equals("2003")) { //$NON-NLS-1$
					return getWindows2003ServerIcon();
				} else {
					// Use Windows 2000 icon as default
					return getWindows2000Icon();
				}
			} else if (unit instanceof LinuxOperatingSystemUnit) {
				OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getFirstCapability(unit,
						OsPackage.eINSTANCE.getOperatingSystem());
				if (osCap == null) {
					// Oops, no Capability
					return getLinuxIcon();
				} else if (osCap instanceof SUSELinuxOperatingSystem
						|| "SUSE".equalsIgnoreCase(osCap.getOsDistribution()) || "SLES".equalsIgnoreCase(osCap.getOsDistribution())) { //$NON-NLS-1$ //$NON-NLS-2$
					return getSUSELinuxIcon();
				} else if (osCap instanceof RedhatLinuxOperatingSystem
						|| "redhat".equalsIgnoreCase(osCap.getOsDistribution()) || "red hat".equalsIgnoreCase(osCap.getOsDistribution())) { //$NON-NLS-1$//$NON-NLS-2$
					return getRedhatLinuxIcon();
				} else {
					// Use Generic penguin icon as default
					return getLinuxIcon();
				}

			} else if (unit instanceof AIXOperatingSystemUnit) {
				return getAIXIcon();

			} else if (unit instanceof OperatingSystemUnit) {
				return getOSIcon();
			}
		}

		return null;
	}

	private static Image getOSIcon() {
		if (ICON_OS == null) {
			ICON_OS = createImage("icons/pal/os_16.gif"); //$NON-NLS-1$;
		}

		return ICON_OS;
	}

	private static Image getWindowsXPIcon() {
		if (ICON_WINDOWS_XP == null) {
			ICON_WINDOWS_XP = createImage("icons/pal/win_xp_16.gif"); //$NON-NLS-1$;
		}

		return ICON_WINDOWS_XP;
	}

	private static Image getWindows2000Icon() {
		if (ICON_WINDOWS_2000 == null) {
			ICON_WINDOWS_2000 = createImage("icons/pal/win_2000_16.gif"); //$NON-NLS-1$;
		}

		return ICON_WINDOWS_2000;
	}

	private static Image getWindows2003ServerIcon() {
		if (ICON_WINDOWS_2003_SERVER == null) {
			ICON_WINDOWS_2003_SERVER = createImage("icons/dgm/winsvr03_dgm.gif"); //$NON-NLS-1$;
		}

		return ICON_WINDOWS_2003_SERVER;
	}

	private static Image getSUSELinuxIcon() {
		if (ICON_SUSE_LINUX == null) {
			ICON_SUSE_LINUX = createImage("icons/dgm/suse_linux_server.gif"); //$NON-NLS-1$;
		}

		return ICON_SUSE_LINUX;
	}

	private static Image getRedhatLinuxIcon() {
		if (ICON_REDHAT_LINUX == null) {
			ICON_REDHAT_LINUX = createImage("icons/dgm/red_hat_server.gif"); //$NON-NLS-1$;
		}

		return ICON_REDHAT_LINUX;
	}

	private static Image getLinuxIcon() {
		if (ICON_GENERIC_LINUX == null) {
			ICON_GENERIC_LINUX = createImage("icons/pal/systemlinux_obj_16.gif"); //$NON-NLS-1$;
		}

		return ICON_GENERIC_LINUX;
	}

	private static Image getAIXIcon() {
		if (ICON_AIX == null) {
			ICON_AIX = createImage("icons/pal/aix_os_16_pal.gif"); //$NON-NLS-1$;
		}

		return ICON_AIX;
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
