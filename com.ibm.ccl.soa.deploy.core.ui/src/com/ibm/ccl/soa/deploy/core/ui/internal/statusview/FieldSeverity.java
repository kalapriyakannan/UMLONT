/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * Severity Field
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class FieldSeverity extends StatusField {

	public String getColumnHeaderText() {
		return Messages.Field_Severity_Name;
	}

	public String getValue(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IStatus status = ((StatusNode) obj).getStatus();
			assert (status != null);
			switch (status.getSeverity())
			{
			case IStatus.ERROR:
				return "Error"; //$NON-NLS-1$
			case IStatus.INFO:
				return "Info"; //$NON-NLS-1$
			case IStatus.WARNING:
				return "Warning"; //$NON-NLS-1$
			}
		}
		throw new NotSupportedTargetException(obj);
	}

	/**
	 * 
	 * @param obj
	 * @return serverity value of obj
	 * @throws NotSupportedTargetException
	 */
	public int getSeverity(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IStatus status = ((StatusNode) obj).getStatus();
			assert (status != null);
			return status.getSeverity();
		}
		throw new NotSupportedTargetException(obj);
	}

	public boolean isShowing() {

		return false;
	}

	public void setShowing(boolean showing) {

	}

	/**
	 * 
	 */
	public final static FieldSeverity INSTANCE = new FieldSeverity();

	public Image getImage(Object obj) {
		if (obj instanceof StatusNode) {
			IStatus status = ((StatusNode) obj).getStatus();
			switch (status.getSeverity())
			{
			case IStatus.ERROR:
				return DeployCoreImages.IMAGE_ERROR_TBL;

			case IStatus.WARNING:
				return DeployCoreImages.IMAGE_WARNING_TBL;
			case IStatus.INFO:
				return DeployCoreImages.IMAGE_INFO_TBL;
			}

		} else if (obj instanceof StatusGroup) {
			return DeployCoreImages.IMAGE_CATEGORY_TBL;
		}
		return null;
	}
}
