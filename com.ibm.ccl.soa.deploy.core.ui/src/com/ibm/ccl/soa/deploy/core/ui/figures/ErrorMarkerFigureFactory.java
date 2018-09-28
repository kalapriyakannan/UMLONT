/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * @since 1.0 ErrorMarkerFigureFactory returns the appropriate image for the given status
 * 
 */

public class ErrorMarkerFigureFactory {

	public static final int WARNING_RESOLUTIONS = 25;

	public static final int ERROR_RESOLUTIONS = 35;

	private static Image errorImg = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_ERROR);
	private static Image errorImg16 = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_ERROR16);
	private static Image warningImg = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_WARNING);
	private static Image quickfixErrorImg = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImage(ISharedImages.IMG_QUICKFIX_ERROR16);
	private static Image quickfixWarningImg = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImage(ISharedImages.IMG_QUICKFIX_WARNING16);
	private static Image infoImg = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_INFO);
	private static Image warningImg16 = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_WARNING16);
	private static Image infoImg16 = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_INFO16);

	/**
	 * @param status
	 * @return Returns the image depending upon the status
	 */
	public static Image getFigureImage(IStatus status) {
		return getRegularFigureImage(status.getSeverity(), hasResolution(status), false);
	}

	public static Image getFigureImage(IStatus status, boolean use16bit) {
		return getRegularFigureImage(status.getSeverity(), hasResolution(status), use16bit);
	}

	public static Image getFigureImage(int severity, boolean use16bit) {
		return getRegularFigureImage(severity, false, use16bit);
	}

	public static Image getRegularFigureImage(int serverity, boolean hasResolutions, boolean use16bit) {

		switch (serverity)
		{
		case IStatus.ERROR: {
			if (hasResolutions) {
				return quickfixErrorImg;
			} else if (use16bit) {
				return errorImg16;
			}
			return errorImg;
		}
		case IStatus.WARNING: {
			if (hasResolutions) {
				if (use16bit) {
					return warningImg16;
				}
				return quickfixWarningImg;
			}
			if (use16bit) {
				return warningImg16;
			}
			return warningImg;

		}
		case IStatus.INFO: {
			if (use16bit) {
				return infoImg16;
			}
			return infoImg;
		}
		case ERROR_RESOLUTIONS: {
			return quickfixErrorImg;
		}
		case WARNING_RESOLUTIONS: {
			return quickfixWarningImg;
		}
		default:
			break;
		}
		return infoImg;
	}

	/**
	 * Check if the status has resolutions.
	 * 
	 * @param status
	 *           a status that may be, or contain, a deploy status.
	 * @return true if the status has resolutions
	 */
	public static boolean hasResolution(IStatus status) {
		boolean hasResolution = false;
		if (status != null
				&& (status.getSeverity() == IStatus.ERROR || status.getSeverity() == IStatus.WARNING)) {

			try {
				hasResolution = ResourceUtils.getActiveDeployEditorValidatorService().hasResolutions(
						status);
			} catch (Throwable e) {
				DeployCorePlugin.logError(0, e.getLocalizedMessage(), e);
			}
		}
		return hasResolution;
	}

}
