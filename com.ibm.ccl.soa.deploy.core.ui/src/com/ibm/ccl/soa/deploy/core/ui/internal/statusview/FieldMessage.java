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
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * Severity and Message field of Problem View. In problem view, severity is shown in image before
 * message.
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * @see FieldTopology
 */
public class FieldMessage extends StatusField {
	/**
	 * @see FieldTopology#compare(Object, Object)
	 */
	public int compare(Object obj1, Object obj2) {
		try {
			if ((obj1 instanceof StatusNode) && (obj2 instanceof StatusNode)) {
				IStatus s1 = ((StatusNode) obj1).getStatus();
				IStatus s2 = ((StatusNode) obj2).getStatus();
				if (s1.getSeverity() == s2.getSeverity()) {
					return getValue(obj1).compareTo(getValue(obj2));
				}
				return s1.getSeverity() - s2.getSeverity();
			}
			if (obj1 instanceof StatusGroup && obj2 instanceof StatusNode) {

				Object c2 = ((StatusNode) obj2).getParent();
				return getValue(obj1).compareTo(getValue(c2));

			}
			if (obj2 instanceof StatusGroup && obj1 instanceof StatusNode) {

				Object c1 = ((StatusNode) obj1).getParent();
				return getValue(obj2).compareTo(getValue(c1));

			}

			return getValue(obj1).compareTo(getValue(obj2));
		} catch (NotSupportedTargetException e) {
			if (e.getTarget().equals(obj1)) {
				return -1;
			}
			return 1;
		}
	}

	/**
	 * @return string message if obj instance of IDeployPublishStatus or <code>null</code>
	 * @throws NotSupportedTargetException
	 */
	public String getValue(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IStatus status = ((StatusNode) obj).getStatus();
			assert (status != null);
			return status.getMessage();
		} else if (obj instanceof StatusGroup) {
			StatusGroup category = (StatusGroup) obj;
			return NLS.bind(Messages.Views_Category_Title, new Object[] { category.getName(),
					new Integer(category.getChildrenNum()) });
		}
		throw new NotSupportedTargetException(obj);
	}

	/**
	 * @return
	 * <li>{@link Messages#Column_Title_Message}
	 */
	public String getColumnHeaderText() {
		return Messages.Field_Message_Name;
	}

	/**
	 * @see FieldTopology#getImage(Object)
	 */
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

	/**
	 * 
	 */
	public final static FieldMessage INSTANCE = new FieldMessage();
}
