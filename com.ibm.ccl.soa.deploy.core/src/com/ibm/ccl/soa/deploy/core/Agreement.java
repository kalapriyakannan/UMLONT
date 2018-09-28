/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

/**
 * An agreement defines the public elements and public editable DeployModelObjects on a Topology.
 * 
 * @since 1.0
 * @see ConfigurationContract
 * @see InstanceConfiguration
 * 
 */
public interface Agreement {

	/**
	 * Returns the set of visible units from the referenced Topology. The returned set will include
	 * public units, as well as units that contain public children or exposed properties.
	 * 
	 * <p>
	 * The list that is returned may not be modified.
	 * </p>
	 * 
	 * @return The set of visible units from the referenced Topology.
	 */
	List<Unit> getVisibleUnits();

	/**
	 * @deprecated Use {@link #getVisibleUnits()}
	 */
	List<Unit> getPublicUnits();

	/**
	 * @deprecated Use {@link #getVisibleUnits()}
	 */
	List<Unit> getPublicEditableUnits();

	/**
	 * Return the set of global properties exposed by the agreement.
	 * 
	 * @return The set of global properties.
	 */
	List<Property> getGlobalProperties();

	/**
	 * Return a property of the given name.
	 * 
	 * <p>
	 * This method may return null.
	 * </p>
	 * 
	 * @param property
	 *           The name of the property to look for.
	 * 
	 * @return The property of the given name.
	 */
	Property getProperty(String property);

	/**
	 * Return true if the given DeployModelObject contains a child which is public.
	 * 
	 * @param source
	 *           The DeployModelObject source to test
	 * @return True if the given DeployModelObject contains a child which is public
	 */
	boolean isVisible(DeployModelObject source);

	/**
	 * Return true if the given DeployModelObject is <i>public</i>.
	 * 
	 * @param source
	 *           The DeployModelObject source to test for <i>public</i>
	 * @return True if the given DeployModelObject is public
	 */
	boolean isPublic(DeployModelObject source);

	/**
	 * Return true if the given DeployModelObject is <i>public editable</i>.
	 * 
	 * @param source
	 *           The DeployModelObject source to test for <i>public editability</i>
	 * @return True if the given DeployModelObject is public editable
	 */
	boolean isPublicEditable(DeployModelObject source);

	/**
	 * Return true if the given property of the given DeployModelObject is <i>public editable</i>.
	 * 
	 * @param propertyName
	 *           The name of a property associated with the given DeployModelObject.
	 * @param source
	 *           The DeployModelObject source to test for <i>public editability</i>
	 * @return True if the given DeployModelObject is public editable
	 */
	boolean isPublicEditable(DeployModelObject source, String propertyName);

}
