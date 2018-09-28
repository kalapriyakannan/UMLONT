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
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a> IStatusField is the definition of
 *         fields for status views.
 */
public interface IStatusField {

	/**
	 * @return String the description of the field.
	 */
	String getDescription();

	/**
	 * @return the image associated with the description of the field or <code>null<code>.
	 */
	Image getDescriptionImage();

	/**
	 * @return The text to be displayed in the column header for this field.
	 */
	String getColumnHeaderText();

	/**
	 * @return The image to be displayed in the column header for this field or <code>null<code>.
	 */
	Image getColumnHeaderImage();

	/**
	 * @param obj
	 * @return The String value of the object for this particular field to be displayed to the user.
	 */
	String getValue(Object obj) throws NotSupportedTargetException;

	/**
	 * @param obj
	 * @return The image value of the object for this particular field to be displayed to the user or
	 *         <code>null<code>.
	 */
	Image getImage(Object obj);

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
	int compare(Object obj1, Object obj2);

	/**
	 * Get the default direction for the receiver. Return either {@link StautsSorter#ASCENDING } or
	 * {@link StatusSorter#DESCENDING }
	 * 
	 * @return int
	 */
	int getDefaultDirection();

	/**
	 * Get the preferred width of the receiver.
	 * 
	 * @return int
	 */
	int getPreferredWidth();

	/**
	 * Return whether not the receiver is showing.
	 * 
	 * @return boolean
	 */
	boolean isShowing();

	/**
	 * Set whether or not the receiver is showing.
	 * 
	 * @param showing
	 */
	void setShowing(boolean showing);

	public boolean hasEntry();

	public Set getEntries();

}
