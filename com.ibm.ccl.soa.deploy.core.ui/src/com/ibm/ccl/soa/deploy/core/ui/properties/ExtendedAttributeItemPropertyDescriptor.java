/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;

/**
 * Allow EMF to see Extended Attributes.
 * 
 * @see DmoPropertiesProvider
 */
public class ExtendedAttributeItemPropertyDescriptor implements IItemPropertyDescriptor {

	private final ExtendedAttribute ea;
	private final EStructuralFeature esf;
	private final AttributeMetaData amd;

	/**
	 * Constructor
	 * 
	 * @param ea
	 * @param amd
	 *           <code>null</code> if there is no meta data for this extended attribute
	 */
	public ExtendedAttributeItemPropertyDescriptor(ExtendedAttribute ea, AttributeMetaData amd) {
		this.ea = ea;

		// Make a Feature for the extended attribute
		ResourceSet rs = ea.eResource().getResourceSet();
		ExtendedMetaData emd = new BasicExtendedMetaData(rs.getPackageRegistry());
		esf = emd.demandFeature("http://www.ibm.com/deploy/planner/ea/namespace", //$NON-NLS-1$ // TODO Name
				ea.getName(), false);
		esf.setEType(ea.getInstanceType());
		this.amd = amd;

	}

	public boolean canSetProperty(Object object) {
		// We want to return false if there is an AttributeMetaData for this attribute
		// saying that it isn't mutable.
		if (amd != null && !amd.isMutable()) {
			return false;
		}

		return true;
	}

	public String getCategory(Object object) {
		return Messages.ExtendedAttributeItemPropertyDescriptor_0;
	}

	public Collection getChoiceOfValues(Object object) {
		return null;
	}

	public String getDescription(Object object) {
		return null;
	}

	public String getDisplayName(Object object) {
		return ea.getName();
	}

	public Object getFeature(Object object) {
		return esf;
	}

	public String[] getFilterFlags(Object object) {
		return null;
	}

	public Object getHelpContextIds(Object object) {
		return null;
	}

	public String getId(Object object) {
		return ea.getName();
	}

	public IItemLabelProvider getLabelProvider(Object object) {
		return new IItemLabelProvider() {

			public Object getImage(Object object) {
				return null;
			}

			public String getText(Object object) {
				return object.toString();
			}
		};
	}

	public Object getPropertyValue(Object object) {
		return ea.getValue();
	}

	public boolean isCompatibleWith(Object object, Object anotherObject,
			IItemPropertyDescriptor anotherPropertyDescriptor) {
		return false;
	}

	public boolean isMany(Object object) {
		return false;
	}

	public boolean isMultiLine(Object object) {
		return false;
	}

	public boolean isPropertySet(Object object) {
		return (ea.getValue() != null);
	}

	public boolean isSortChoices(Object object) {
		return false;
	}

	public void resetPropertyValue(Object object) {
		// do nothing
	}

	public void setPropertyValue(Object object, Object value) {
		// This method apparently never gets called?
//		System.out.println("EAIP.setPVal(" + object.getClass().getName() + ", " + value + ")");  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * @return the described ExtendedAttribute
	 */
	public ExtendedAttribute getExtendedAttribute() {
		return ea;
	}

}
