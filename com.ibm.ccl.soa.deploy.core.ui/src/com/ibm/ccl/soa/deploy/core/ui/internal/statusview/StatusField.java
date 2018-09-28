/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.Set;

import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public abstract class StatusField implements IStatusField {
	private boolean visible = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.markers.internal.IField#isShowing()
	 */
	public boolean isShowing() {
		return visible;
	}

	/**
	 * Set whether or not the receiver is showing.
	 * 
	 * @param showing
	 */
	public void setShowing(boolean showing) {
		visible = showing;

	}

	/**
	 * @return The image to be displayed in the column header for this field or <code>null</code>.
	 */
	public Image getColumnHeaderImage() {
		return null;
	}

	/**
	 * Get the default direction for the receiver.
	 * 
	 * @return either
	 *         <li><code>1</code> if sort ascending
	 *         <li><code>-1</code> if sort descending
	 */

	public int getDefaultDirection() {
		return StatusSorter.ASCENDING;
	}

	/**
	 * @return String the description of the field.
	 */

	public String getDescription() {
		return this.getColumnHeaderText();
	}

	/**
	 * @return the image associated with the description of the field or <code>null</code>.
	 */
	public Image getDescriptionImage() {
		return null;
	}

	/**
	 * @return the image associated with the obj or <code>null</code>
	 */
	public Image getImage(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the preferred width to receiver
	 */
	public int getPreferredWidth() {
		if (isShowing())
			return 150;
		return 0;
	}

	/**
	 * @param obj1
	 * @param obj2
	 * @return Either:
	 *         <li>a negative number if the value of obj1 is less than the value of obj2 for this
	 *         field.
	 *         <li><code>0</code> if the value of obj1 and the value of obj2 are equal for this
	 *         field.
	 *         <li>a positive number if the value of obj1 is greater than the value of obj2 for this
	 *         field.
	 */
	public int compare(Object obj1, Object obj2) {
		try {

			return getValue(obj1).compareTo(getValue(obj2));
		} catch (NotSupportedTargetException e) {
			if (e.getTarget().equals(obj1)) {
				return -1;
			}
			return 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField#getEntries()
	 */
	public Set getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField#hasEntry()
	 */
	public boolean hasEntry() {
		// TODO Auto-generated method stub
		return false;
	}

}
